package uz.ksan.socialmedia.backend.socialnetwork1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.socialmedia.backend.socialnetwork1.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserByFirstName(String firstName);
    UserEntity findUserByLastName(String lastName);
    UserEntity findUserByEmail(String email);
    void deleteUserByEmail(String email);

}

