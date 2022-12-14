package tn.vapex.domain.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.vapex.core.security.UserRole;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link tn.vapex.domain.entitites.User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Date createdAt;
    private Date updatedAt;
    private Long id;
    private String phone;
    private UserRole role = UserRole.ROLE_USER;
}