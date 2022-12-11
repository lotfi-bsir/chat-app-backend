package tn.vapex.domain.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.vapex.core.security.AuthFacade;
import tn.vapex.core.security.jwt.LoginVM;
import tn.vapex.domain.api.vm.JWTToken;
import tn.vapex.domain.api.vm.PhoneVM;
import tn.vapex.domain.api.vm.RefreshTokenVM;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.services.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthFacade authFacade;

    @PostMapping("login")
    public ResponseEntity<Void> loginOrRegister(@RequestBody @Valid PhoneVM phoneVM) {
        this.authService.loginOrRegister(phoneVM.getPhone());
        return ResponseEntity.ok().build();
    }

    @PostMapping("validate")
    public ResponseEntity<JWTToken> validateLogin(@RequestBody @Valid LoginVM loginVM) {
        return ResponseEntity.ok(this.authService.validateLogin(loginVM.getPhone(), loginVM.getCode()));
    }

    @PostMapping("refresh")
    public ResponseEntity<JWTToken> getRefreshToken(@RequestBody RefreshTokenVM refreshTokenVM) {
        return ResponseEntity.ok(this.authService.refreshToken(refreshTokenVM.getRefreshToken()));
    }

    @GetMapping("me")
    public ResponseEntity<User> getAuthenticatedUser(){
        return ResponseEntity.ok(this.authFacade.getAuthenticated());
    }
}
