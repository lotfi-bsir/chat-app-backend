package tn.vapex.developmental.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.vapex.core.security.UserRole;
import tn.vapex.core.security.jwt.TokenManager;
import tn.vapex.developmental.Developmental;
import tn.vapex.developmental.api.vm.UserWithToken;
import tn.vapex.developmental.fakers.factories.FakerFactory;
import tn.vapex.domain.api.mappers.UserMapper;
import tn.vapex.domain.api.vm.JWTToken;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Developmental
public class UserServiceDevelopmental {

    private final UserRepository userRepository;
    private final TokenManager tokenManager;
    private final UserMapper userMapper;

    public UserWithToken createTestUser(String phone, UserRole role) {
        Optional<User> userOptional = userRepository.findByPhone(phone);
        userOptional.ifPresent(userRepository::delete);


        User user = FakerFactory.getInstance().fakeEntitiesFactory().getUserFactory().withRole(role);
        this.userRepository.saveAndFlush(user);

        JWTToken token = this.tokenManager.generateAccessAndRefreshToken(user.getPhone());
        Integer validationCode = user.getValidationCode().getCode();

        return new UserWithToken(token, this.userMapper.toDto(user), validationCode);
    }
}
