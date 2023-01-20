package tn.vapex.domain.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.vapex.domain.api.dtos.UserDto;
import tn.vapex.domain.api.mappers.UserMapper;
import tn.vapex.domain.api.vm.JWTToken;
import tn.vapex.domain.api.vm.LoginOrRegisterVm;
import tn.vapex.domain.services.AuthService;
import tn.vapex.domain.storage.CustomFile;
import tn.vapex.domain.storage.rest.CustomFileMapper;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final CustomFileMapper customFileMapper;
    private final UserMapper userMapper;

    @PostMapping("login")
    public ResponseEntity<JWTToken> loginOrRegister(@RequestBody @Valid LoginOrRegisterVm vm) {
        CustomFile image = this.customFileMapper.toEntity(vm.getPhoto());
        return ResponseEntity.ok(JWTToken.of(this.authService.loginOrRegister(vm.getEmail(), image, vm.getGender(),vm.getFirstName(), vm.getLastName(),vm.getPassword())));
    }

    @GetMapping("me")
    public ResponseEntity<UserDto> loginOrRegister() {
        return ResponseEntity.ok(this.userMapper.toDto(this.authService.getConnectedUser()));
    }
}
