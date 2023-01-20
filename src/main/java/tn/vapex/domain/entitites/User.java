package tn.vapex.domain.entitites;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import tn.vapex.core.security.UserRole;
import tn.vapex.domain.enums.Gender;
import tn.vapex.domain.storage.CustomFile;

import javax.persistence.*;

@Entity
@Getter
@Setter
@FieldNameConstants
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    @JoinColumn
    private CustomFile photo;

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role = UserRole.ROLE_USER;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
