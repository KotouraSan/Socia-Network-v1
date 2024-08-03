package uz.ksan.socialmedia.backend.socialnetwork1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.socialmedia.backend.socialnetwork1.model.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByFirstName(String firstName);
    Optional<UserEntity> findUserByLastName(String lastName);
    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findUserByUserName(String userName);

    void deleteUserByEmail(String email);

}

