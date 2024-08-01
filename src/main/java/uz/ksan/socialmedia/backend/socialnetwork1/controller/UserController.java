
package uz.ksan.socialmedia.backend.socialnetwork1.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.ksan.socialmedia.backend.socialnetwork1.dto.AckDTO;
import uz.ksan.socialmedia.backend.socialnetwork1.exceptions.NotFoundException;
import uz.ksan.socialmedia.backend.socialnetwork1.model.UserEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {


    @Autowired
    private final UserService service;

    @GetMapping("/display")
    public List<UserEntity> displayAllUsers() {
        return service.displayAllUsers();
    }

    @PostMapping("/saveUser")
    public UserEntity saveUser(@RequestBody UserEntity user) {
        return service.saveUser(user);
    }

    @PutMapping("/updateUser")
    public UserEntity updateUser(@RequestBody UserEntity user) {

        return service.updateUser(user);
    }

    @GetMapping("/findid/{id}")
    public UserEntity findUserById(@PathVariable("id") Long id) {
        return service.findUserById(id)
                .orElseThrow(() -> new NotFoundException("Not found user with id: " + id));
    }

    @GetMapping("/findname/{firstName}")
    public UserEntity findUserByFirstName(@PathVariable("firstName") String firstName) {
        return service.findUserByFirstName(firstName)
                .orElseThrow(() -> new NotFoundException("Not found user with Name: " + firstName));
    }

    @GetMapping("/findlname/{lastName}")
    public UserEntity findUserByLastName(@PathVariable("lastName") String lastName) {
        return service.findUserByLastName(lastName)
                .orElseThrow(() -> new NotFoundException("Not found user with last name: " + lastName));
    }

    @GetMapping("/findemail/{email}")
    public UserEntity findUserByEmail(@PathVariable("email") String email) {
        return service.findUserByEmail(email)
                .orElseThrow(() -> new NotFoundException("Not found user with email: " + email));
    }

    @DeleteMapping("/deleteid/{id}")
    public AckDTO deleteUser(@PathVariable("id") Long id) {
        UserEntity user = getProjectOrThrowException(id);
        service.deleteUserById(id);
        return AckDTO.makeDefault(true);

    }

    private UserEntity getProjectOrThrowException(Long id) {
        return service.findUserById(id)
                .orElseThrow(() -> new NotFoundException("Not found user with id: " + id));
    }


}
