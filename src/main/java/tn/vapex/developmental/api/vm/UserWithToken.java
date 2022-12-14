package tn.vapex.developmental.api.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.vapex.domain.api.dtos                     .UserDto;
import tn.vapex.domain.api.vm.JWTToken;

@Data
@AllArgsConstructor
public class UserWithToken {
    JWTToken token;
    UserDto user;
    Integer validationCode;
}
