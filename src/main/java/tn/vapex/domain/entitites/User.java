package tn.vapex.domain.entitites;

import lombok.Getter;
import lombok.Setter;
import tn.vapex.core.security.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class User extends BaseEntity {
    @Column(unique = true, updatable = false, nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ROLE_USER;

    @Column
    private boolean banned = false;
}
