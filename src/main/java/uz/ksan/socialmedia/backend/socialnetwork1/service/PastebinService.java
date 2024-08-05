package uz.ksan.socialmedia.backend.socialnetwork1.service;

import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.PastebinEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.UserEntity;

import java.util.List;

public interface PastebinService {
    PastebinEntity createPost(PastebinEntity post);
    List<PastebinEntity> displayAll();
    PastebinEntity getPostByUrl(String url);
    PastebinEntity getPostByAuthor(UserEntity author);

}
