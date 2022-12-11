package tn.vapex.core.security;

import tn.vapex.domain.entitites.User;

public interface AuthFacade {
    User getAuthenticated();
}
