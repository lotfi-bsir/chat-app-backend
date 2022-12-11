package tn.vapex.domain.api.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.vapex.domain.validators.token.Token;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenVM {
    @Token
    private String refreshToken;
}
