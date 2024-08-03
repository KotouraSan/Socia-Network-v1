package uz.ksan.socialmedia.backend.socialnetwork1.service;

import uz.ksan.socialmedia.backend.socialnetwork1.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<UserEntity> displayAllUsers();
    UserEntity updateUser(UserEntity user);
    Optional<UserEntity> findUserById(Long id);
    Optional<UserEntity> findUserByFirstName(String firstName);
    Optional<UserEntity> findUserByLastName(String lastName);
    Optional<UserEntity> findUserByEmail(String email);
    void deleteUserById(Long id);
    void deleteUserByEmail(String email);
    void addLoginUser(UserEntity user);

}
