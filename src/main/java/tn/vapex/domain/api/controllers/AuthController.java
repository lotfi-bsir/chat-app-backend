package tn.vapex.domain.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.vapex.domain.api.dtos.UserDto;
import tn.vapex.domain.api.mappers.UserMapper;
import tn.vapex.domain.api.vm.JWTToken;
import tn.vapex.domain.api.vm.LoginOrRegisterVm;
import tn.vapex.domain.api.vm.LoginVm;
import tn.vapex.domain.repositories.UserRepository;
import tn.vapex.domain.services.AuthService;
import tn.vapex.domain.storage.CustomFile;
import tn.vapex.domain.storage.rest.CustomFileMapper;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final CustomFileMapper customFileMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @PostMapping("registre")
    public ResponseEntity<JWTToken> register(@RequestBody @Valid LoginOrRegisterVm vm) {
        CustomFile image = this.customFileMapper.toEntity(vm.getPhoto());
        return ResponseEntity.ok(JWTToken.of(this.authService.loginOrRegister(vm.getEmail(), image, vm.getGender(), vm.getFirstName(), vm.getLastName(), vm.getPassword())));
    }

    @PostMapping("login")
    public ResponseEntity<JWTToken >  login(@RequestBody LoginVm vm) {
        String logStatus = this.authService.login(vm.getEmail(), vm.getPassword());
        if (!Objects.equals(logStatus, "userNotFound") && !Objects.equals(logStatus, "passwordIncorrect")) {
            return ResponseEntity.ok(JWTToken.of(logStatus));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("me")
    public ResponseEntity<UserDto> loginOrRegister() {
        return ResponseEntity.ok(this.userMapper.toDto(this.authService.getConnectedUser()));
    }
}
