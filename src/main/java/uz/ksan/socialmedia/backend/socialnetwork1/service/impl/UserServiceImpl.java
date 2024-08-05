package uz.ksan.socialmedia.backend.socialnetwork1.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.UserEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
@Transactional
public class UserServiceImpl implements uz.ksan.socialmedia.backend.socialnetwork1.service.UserService{

    @Autowired
    private UserRepository repository;
    private PasswordEncoder passwordEncoder;


    public void addLoginUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    @Cacheable("users")
    public List<UserEntity> displayAllUsers() {
        return repository.findAll();
    }


    @Override
    public UserEntity updateUser(UserEntity user) {
        return repository.save(user);
    }

    @Override
    @CacheEvict("users")
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @CacheEvict("users")
    public void deleteUserByEmail(String email) {
        repository.deleteUserByEmail(email);
    }

    @Override
    @Cacheable("users")
    public Optional<UserEntity> findUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Cacheable("users")
    public Optional<UserEntity> findUserByEmail(String email) {return (repository.findUserByEmail(email));}

    @Override
    public List<UserEntity> findByFilters(LocalDate dateOfBirth, String firstName, String lastName, String userName, String email) {
        return repository.findByFilters(dateOfBirth, firstName, lastName, userName, email);


//    @Override
//    @Cacheable("users")
//    public Optional<UserEntity> findUserByFirstName(String firstName) {
//        return repository.findUserByFirstName(firstName);
//    }
//
//    @Override
//    @Cacheable("users")
//    public Optional<UserEntity> findUserByLastName(String lastName)
//    {
//        return (repository.findUserByLastName(lastName));
//    }
//
    }

}
