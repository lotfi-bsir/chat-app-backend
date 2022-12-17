package tn.vapex.developmental.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.vapex.developmental.Developmental;
import tn.vapex.developmental.api.vm.TestUserVM;
import tn.vapex.developmental.api.vm.UserWithToken;
import tn.vapex.developmental.services.UserServiceDevelopmental;
import tn.vapex.domain.api.dtos.UserDto;
import tn.vapex.domain.api.mappers.UserMapper;
import tn.vapex.domain.api.vm.JWTToken;

import java.util.List;

/**
 * Developmental feature! DO NOT USE IN PRODUCTION
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("developmental/users")
@Developmental
public class UserControllerDevelopmental {

    private final UserServiceDevelopmental userService;
    private final UserMapper userMapper;



    @PostMapping("/test")
    public ResponseEntity<UserWithToken> createTestUser(@RequestBody TestUserVM testUserVM) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createTestUser(testUserVM.getPhone(), testUserVM.getRole()));
    }


    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getTestUsers(){
        return ResponseEntity.ok(userMapper.toDto(this.userService.fetchAllUsers()) );
    }

    @GetMapping("/token/{identifier}")
    public ResponseEntity<JWTToken> getUserToken(@PathVariable String identifier){
        return ResponseEntity.ok(this.userService.generateUserToken(identifier));
    }

    @GetMapping("/{identifier}")
    public  ResponseEntity<UserDto> getUser(@PathVariable String identifier){
        return ResponseEntity.ok(this.userMapper.toDto(this.userService.getUserByIdentifier(identifier)));
    }


    @DeleteMapping("/purge")
    public ResponseEntity<Void> deleteAllUsers(){
    this.userService.deleteUsers();
    return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{identifier}")
    public ResponseEntity<Void> deleteUserByIdentifier(@PathVariable String identifier){
    this.userService.deleteUserByIdentifier(identifier);
    return ResponseEntity.ok().build();
    }


}
