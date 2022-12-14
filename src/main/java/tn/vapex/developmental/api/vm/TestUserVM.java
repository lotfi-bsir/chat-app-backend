package tn.vapex.developmental.api.vm;

import lombok.Getter;
import lombok.Setter;
import tn.vapex.core.security.UserRole;
import tn.vapex.domain.validators.phone.TunisianPhone;

@Getter
@Setter
public class TestUserVM {
    @TunisianPhone
    private String phone;
    private UserRole role = UserRole.ROLE_USER;
}
