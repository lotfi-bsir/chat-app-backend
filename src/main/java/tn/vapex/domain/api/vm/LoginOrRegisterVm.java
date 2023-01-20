package tn.vapex.domain.api.vm;

import lombok.Data;
import tn.vapex.domain.enums.Gender;
import tn.vapex.domain.storage.rest.CustomFileDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class LoginOrRegisterVm {
    @NotNull
    private CustomFileDto photo;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String password;
    @NotNull
    private Gender gender;
}
