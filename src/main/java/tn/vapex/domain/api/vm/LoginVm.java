package tn.vapex.domain.api.vm;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginVm {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
