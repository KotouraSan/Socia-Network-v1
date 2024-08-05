package uz.ksan.socialmedia.backend.socialnetwork1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.UserEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findUserByUserName(String userName);
    void deleteUserByEmail(String email);
    @Query("SELECT param FROM UserEntity param WHERE " +
            "(:dateOfBirth IS NULL OR param.dateOfBirth = :dateOfBirth) AND " +
            "(:firstName IS NULL OR param.firstName = :firstName) AND " +
            "(:lastName IS NULL OR param.lastName = :lastName) AND " +
            "(:userName IS NULL OR param.userName = :userName) AND " +
            "(:email IS NULL OR param.email = :email) " )
    List<UserEntity> findByFilters(@Param("dateOfBirth") LocalDate dateOfBirth,
                                   @Param("firstName") String firstName,
                                   @Param("lastName") String lastName,
                                   @Param("userName") String userName,
                                   @Param("email") String email);

    //    Optional<UserEntity> findUserByFirstName(String firstName);
//    Optional<UserEntity> findUserByLastName(String lastName);
}

