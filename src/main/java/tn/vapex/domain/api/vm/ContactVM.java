package tn.vapex.domain.api.vm;

import lombok.Data;
import tn.vapex.domain.api.dtos.MessageDto;
import tn.vapex.domain.api.dtos.UserDto;

@Data
public class ContactVM {
    private UserDto userDto;
    private MessageDto lastMessage;

    public static ContactVM of(UserDto userDto, MessageDto messageDto) {
        ContactVM contact = new ContactVM();
        contact.setUserDto(userDto);
        contact.setLastMessage(messageDto);
        return contact;
    }
}
