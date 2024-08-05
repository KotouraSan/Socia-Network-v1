package uz.ksan.socialmedia.backend.socialnetwork1.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.PastebinEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.UserEntity;
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
    @CachePut("users")
    public PastebinEntity createPost(PastebinEntity post) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity author = userRepository.findUserByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        post.setCreatedAt(LocalDateTime.now());
        post.setUrl(UUID.randomUUID().toString());
        post.setAuthor(author);
        return pastebinRepository.save(post);
    }

    @Override
    public List<PastebinEntity> displayAll() {
        return pastebinRepository.findAll();
    }

    @Override
    @Cacheable("users")
    public PastebinEntity getPostByUrl(String url) {
        return pastebinRepository.findByUrl(url)
                .orElseThrow(() -> new RuntimeException("Pastebin Not Found"));
    }

    @Override
    public PastebinEntity getPostByAuthor(UserEntity author) {
        return pastebinRepository.findByAuthor(author)
                .orElseThrow(() -> new RuntimeException("Pastebin Not Found"));
    }


}
