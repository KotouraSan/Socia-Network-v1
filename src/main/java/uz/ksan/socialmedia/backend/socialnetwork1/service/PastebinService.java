package uz.ksan.socialmedia.backend.socialnetwork1.service;

import uz.ksan.socialmedia.backend.socialnetwork1.model.PastebinEntity;

import java.util.List;

public interface PastebinService {
    PastebinEntity getPostByUrl(String url);
//    PastebinEntity getPostByAuthor(String author);
    PastebinEntity createPost(String content);
    List<PastebinEntity> displayAll();

}
