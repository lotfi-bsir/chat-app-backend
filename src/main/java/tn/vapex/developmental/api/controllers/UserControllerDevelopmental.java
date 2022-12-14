package tn.vapex.developmental.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.vapex.developmental.Developmental;
import tn.vapex.developmental.api.vm.TestUserVM;
import tn.vapex.developmental.api.vm.UserWithToken;
import tn.vapex.developmental.services.UserServiceDevelopmental;

/**
 * Developmental feature! DO NOT USE IN PRODUCTION
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("developmental")
@Developmental
public class UserControllerDevelopmental {

    private final UserServiceDevelopmental userService;

    @PostMapping("test-user")
    public ResponseEntity<UserWithToken> createTestUser(@RequestBody TestUserVM testUserVM) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createTestUser(testUserVM.getPhone(), testUserVM.getRole()));
    }

    // similar endpoint in selket : tn.selket.developmental.rest.controllers
    // TODO: endpoint -> get all users
    // TODO: endpoint -> get tokens for user (by phone or id)
    // TODO: endpoint -> get user (by phone or id)
    // TODO endpoint  -> purge users

}
