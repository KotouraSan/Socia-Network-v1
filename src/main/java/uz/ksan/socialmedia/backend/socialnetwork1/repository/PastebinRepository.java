package uz.ksan.socialmedia.backend.socialnetwork1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.PastebinEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.UserEntity;

import java.util.Optional;

public interface PastebinRepository extends JpaRepository<PastebinEntity, Long> {
    Optional <PastebinEntity> findByUrl(String url);
    Optional <PastebinEntity> findByAuthor(UserEntity author);


}
