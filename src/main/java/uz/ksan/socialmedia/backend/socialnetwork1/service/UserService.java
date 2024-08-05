package uz.ksan.socialmedia.backend.socialnetwork1.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.UserEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void addLoginUser(UserEntity user);             //Create user
    UserEntity updateUser(UserEntity user);
    void deleteUserById(Long id);
    void deleteUserByEmail(String email);
    List<UserEntity> displayAllUsers();
    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findUserById(Long id);
    @Query("SELECT param FROM UserEntity param WHERE " +
            "(:dateOfBirth IS NULL OR param.dateOfBirth = :dateOfBirth) AND " +
            "(:firstName IS NULL OR param.firstName = :firstName) AND " +
            "(:lastName IS NULL OR param.lastName = :lastName) AND " +
            "(:userName IS NULL OR param.userName = :userName) AND " +
            "(:email IS NULL OR param.email = :email) " )                               //filter search by birth date, name, last name, username, email
    List<UserEntity> findByFilters(@Param("dateOfBirth")LocalDate dateOfBirth,
                                   @Param("firstName") String firstName,
                                   @Param("lastName") String lastName,
                                   @Param("userName") String userName,
                                   @Param("email") String email);


//    Optional<UserEntity> findUserByFirstName(String firstName);
//    Optional<UserEntity> findUserByLastName(String lastName);


}
