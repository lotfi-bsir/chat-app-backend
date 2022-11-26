package tn.vapex.core.security;

import lombok.Getter;

@Getter
public enum UserAuthority {
    ADMIN("ADMIN"),
    DELIVERY_MAN("DELIVERY_MAN"),
    USER("USER");

    String authority;

    UserAuthority(String authority) {
        this.authority = authority;
    }
}
