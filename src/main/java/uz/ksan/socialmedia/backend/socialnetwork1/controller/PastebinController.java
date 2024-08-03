package uz.ksan.socialmedia.backend.socialnetwork1.controller;


import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.ksan.socialmedia.backend.socialnetwork1.model.PastebinEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.service.impl.PastebinServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/pastebin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PastebinController {

    @Autowired
    PastebinServiceImpl service;

    @GetMapping("/displayall")
    public ResponseEntity<List<PastebinEntity>> displayAll() {
        List<PastebinEntity> list = service.displayAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/createpost")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<PastebinEntity> createPost(@RequestBody String content){
        PastebinEntity post = service.createPost(content);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/find/posturl/{url}")
    public ResponseEntity<PastebinEntity> getPostByUrl(@PathVariable String url){
        PastebinEntity post = service.getPostByUrl(url);
        return ResponseEntity.ok(post);
    }

//    @GetMapping("/find/authorid/{author}")
//    public ResponseEntity<PastebinEntity> getPostByAuthor(@PathVariable String author){
//        PastebinEntity post = service.getPostByAuthor(author);
//        return ResponseEntity.ok(post);
//    }

}
