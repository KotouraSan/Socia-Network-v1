package uz.ksan.socialmedia.backend.socialnetwork1.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.ksan.socialmedia.backend.socialnetwork1.model.UserEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.repository.UserRepository;

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

    @Override
    public List<UserEntity> displayAllUsers() {
        return repository.findAll();
    }


    @Override
    public UserEntity updateUser(UserEntity user) {
        return repository.save(user);
    }

    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<UserEntity> findUserByFirstName(String firstName) {
        return repository.findUserByFirstName(firstName);
    }

    @Override
    public Optional<UserEntity> findUserByLastName(String lastName)
    {
        return (repository.findUserByLastName(lastName));
    }

    @Override
    public Optional<UserEntity> findUserByEmail(String email) {
        return (repository.findUserByEmail(email));
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteUserByEmail(String email) {
        repository.deleteUserByEmail(email);
    }
    
    public Optional<UserEntity> findUserByUsername(String userName) {
        return repository.findUserByUserName(userName);
    }


    public void addLoginUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
