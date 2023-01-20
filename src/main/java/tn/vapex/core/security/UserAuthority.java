package tn.vapex.core.security;

import lombok.Getter;

@Getter
public enum UserAuthority {
    ADMIN("ADMIN"),
    USER("USER");

    String authority;

    UserAuthority(String authority) {
        this.authority = authority;
    }
}
