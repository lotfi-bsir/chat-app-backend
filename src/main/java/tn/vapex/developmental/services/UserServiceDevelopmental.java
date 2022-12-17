package tn.vapex.developmental.services;

import com.google.common.collect.Lists;
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
import tn.vapex.domain.exceptions.exceptions.UserNotFoundException;
import tn.vapex.domain.repositories.UserRepository;

import java.util.List;
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

    public List<User> fetchAllUsers() {
        return Lists.newArrayList(this.userRepository.findAll());
    }

    public User getUserByIdentifier(String id) {
        Optional<User> userById = this.userRepository.findById(Long.valueOf(id));
        return userById.orElseGet(() -> this.userRepository.findByPhone(id).orElseThrow(UserNotFoundException::new));
    }

    public JWTToken generateUserToken(String id) {
        Optional<User> userById = this.userRepository.findById(Long.valueOf(id));
        if (userById.isPresent()) {
            return this.tokenManager.generateAccessAndRefreshToken(userById.get().getPhone());
        }
        User userByPhone = this.userRepository.findByPhone(id).orElseThrow(UserNotFoundException::new);
        return this.tokenManager.generateAccessAndRefreshToken(userByPhone.getPhone());
    }

    public void deleteUsers() {
        this.userRepository.deleteAll();
    }

    public void deleteUserByIdentifier(String id) {
        Optional<User> userById = this.userRepository.findById(Long.valueOf(id));
        if (userById.isPresent()) {
            this.userRepository.delete(userById.get());
            return;
        }
        User userByPhone = this.userRepository.findByPhone(id).orElseThrow(UserNotFoundException::new);
        this.userRepository.delete(userByPhone);
    }
}
