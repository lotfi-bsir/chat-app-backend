package tn.vapex.domain.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tn.vapex.domain.storage.rest.CustomFileDto;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link tn.vapex.domain.entitites.Message} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MessageDto implements Serializable {
    private Date createdAt;
    private Date updatedAt;
    private Long id;
    private String text;
    private CustomFileDto image;
    private UserDto sender;
    private UserDto recipient;
}