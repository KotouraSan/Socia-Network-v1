package uz.ksan.socialmedia.backend.socialnetwork1.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.ksan.socialmedia.backend.socialnetwork1.dto.AckDTO;
import uz.ksan.socialmedia.backend.socialnetwork1.exceptions.NotFoundException;
import uz.ksan.socialmedia.backend.socialnetwork1.models.entities.UserEntity;
import uz.ksan.socialmedia.backend.socialnetwork1.service.UserService;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    @Autowired
    private final UserService service;



    @PostMapping("users/newLoginUser")
    public String addLoginUser(@RequestBody UserEntity user) {
        service.addLoginUser(user);
        return "User is saved";
    }

    @PutMapping("users/updateUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return service.updateUser(user);
    }


    @DeleteMapping("users/delete/id/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public AckDTO deleteUserById(@PathVariable("id") Long id) {
        UserEntity user = getProjectIdOrThrowException(id);
        service.deleteUserById(id);
        return AckDTO.makeDefault(true);
    }

    @DeleteMapping("users/delete/email/{email}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public AckDTO deleteUserByEmail(@PathVariable("email") String email) {
        UserEntity user = getProjectEmailOrThrowException(email);
        service.deleteUserByEmail(email);
        return AckDTO.makeDefault(true);
    }

    @GetMapping("users/display")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserEntity> displayAllUsers() {
        return service.displayAllUsers();
    }

    @GetMapping("users/find")
    public List<UserEntity> findByFilters(@RequestParam(required = false) LocalDate dateOfBirth,
                                          @RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName,
                                          @RequestParam(required = false) String userName,
                                          @RequestParam(required = false) String email){
        return service.findByFilters(dateOfBirth, firstName, lastName, userName, email);
    }

    private UserEntity getProjectIdOrThrowException(Long id) {
        return service.findUserById(id)
                .orElseThrow(() -> new NotFoundException("Not found user with id: " + id));
    }

    private UserEntity getProjectEmailOrThrowException(String email) {
        return service.findUserByEmail(email)
                .orElseThrow(() -> new NotFoundException("Not found user with email: " + email));
    }

//    @GetMapping("users/find/id/{id}")
//    public UserEntity findUserById(@PathVariable("id") Long id) {
//        return service.findUserById(id)
//                .orElseThrow(() -> new NotFoundException("Not found user with id: " + id));
//    }
//
//
//    @GetMapping("users/find/name/{firstName}")
//    public UserEntity findUserByFirstName(@PathVariable("firstName") String firstName) {
//        return service.findUserByFirstName(firstName)
//                .orElseThrow(() -> new NotFoundException("Not found user with Name: " + firstName));
//    }
//
//
//    @GetMapping("users/find/lname/{lastName}")
//    public UserEntity findUserByLastName(@PathVariable("lastName") String lastName) {
//        return service.findUserByLastName(lastName)
//                .orElseThrow(() -> new NotFoundException("Not found user with last name: " + lastName));
//    }
//
//
//    @GetMapping("users/find/email/{email}")
//    public UserEntity findUserByEmail(@PathVariable("email") String email) {
//        return service.findUserByEmail(email)
//                .orElseThrow(() -> new NotFoundException("Not found user with email: " + email));
//    }












}
