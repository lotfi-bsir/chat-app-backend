package tn.vapex.domain.entitites;

import lombok.Getter;
import lombok.Setter;
import tn.vapex.core.security.UserRole;
import tn.vapex.domain.code.ValidationCode;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User extends BaseEntity {
    @Column(unique = true, updatable = false, nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ROLE_USER;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "validation_code_id")
    private ValidationCode validationCode;

    @Column
    private boolean banned = false;
}
