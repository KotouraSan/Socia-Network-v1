package uz.ksan.socialmedia.backend.socialnetwork1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.UserEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = repository.findUserByUserName(username);
        return user.map(uz.ksan.socialmedia.backend.socialnetwork1.security.UserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
