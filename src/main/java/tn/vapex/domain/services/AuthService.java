package tn.vapex.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.vapex.core.security.AuthFacade;
import tn.vapex.core.security.UserRole;
import tn.vapex.core.security.jwt.TokenManager;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.enums.Gender;
import tn.vapex.domain.repositories.UserRepository;
import tn.vapex.domain.storage.CustomFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final TokenManager tokenManager;
    private final AuthFacade authFacade;
    private final PasswordEncoder passwordEncoder;

    public String loginOrRegister(String email, CustomFile photo, Gender gender, String firstName, String lastName, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        User user;
        if (userOptional.isEmpty()) {
            user = this.createUser(email, firstName, lastName, password, gender, photo);
        } else {
            user = userOptional.get();
        }

        this.userRepository.save(user);
        return this.tokenManager.generateToken(email);
    }


    public User getConnectedUser() {
        return this.authFacade.getAuthenticated();
    }

    private User createUser(String email, String firstName, String lastName, String password, Gender gender, CustomFile photo) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoto(photo);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(UserRole.ROLE_USER);
        user.setGender(gender);
        return user;
    }

    ;

}
