package uz.ksan.socialmedia.backend.socialnetwork1.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.ksan.socialmedia.backend.socialnetwork1.model.PastebinEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.model.UserEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.repository.PastebinRepository;
import uz.ksan.socialmedia.backend.socialnetwork1.repository.UserRepository;
import uz.ksan.socialmedia.backend.socialnetwork1.service.PastebinService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Primary
@Transactional
public class PastebinServiceImpl implements PastebinService {

    @Autowired
    PastebinRepository pastebinRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public PastebinEntity createPost(String content) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity author = userRepository.findUserByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        PastebinEntity post = new PastebinEntity();
        post.setContent(content);
        post.setCreatedAt(LocalDateTime.now());
        post.setUrl(UUID.randomUUID().toString());
        post.setAuthor(author);
        return pastebinRepository.save(post);
    }

    @Override
    public PastebinEntity getPostByUrl(String url) {
        return pastebinRepository.findByUrl(url)
                .orElseThrow(() -> new RuntimeException("Pastebin Not Found"));
    }

//    @Override
//    public PastebinEntity getPostByAuthor(String author) {
//        return pastebinRepository.findByAuthor(author)
//                .orElseThrow(() -> new RuntimeException("Pastebin Not Found"));
//    }

    @Override
    public List<PastebinEntity> displayAll() {
        return pastebinRepository.findAll();
    }
}
