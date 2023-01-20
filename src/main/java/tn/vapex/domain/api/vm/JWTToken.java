package tn.vapex.domain.api.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.vapex.domain.validators.token.Token;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JWTToken {
    @Token
    private String token;

    public static JWTToken of(String token){
        JWTToken jwtToken = new JWTToken();
        jwtToken.setToken(token);
        return jwtToken;
    }
}
