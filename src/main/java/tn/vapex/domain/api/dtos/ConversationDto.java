package tn.vapex.domain.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link tn.vapex.domain.entitites.Conversation} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ConversationDto implements Serializable {
    private Date createdAt;
    private Date updatedAt;
    private Long id;
    private List<UserDto> participants;
    private List<MessageDto> messages;
}