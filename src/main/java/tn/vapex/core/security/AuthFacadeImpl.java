package tn.vapex.core.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.exceptions.exceptions.UserNotFoundException;
import tn.vapex.domain.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class AuthFacadeImpl implements AuthFacade {

    private final UserRepository userRepository;

    @Override
    public User getAuthenticated() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }
}
