package tn.vapex.core.security.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVM {
    private String username;
    private String password;
}
