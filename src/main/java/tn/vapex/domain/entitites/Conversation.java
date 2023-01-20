package tn.vapex.domain.entitites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Conversation extends BaseEntity {

    @ManyToMany
    @JoinColumn
    private List<User> participants;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private List<Message> messages;

    public static Conversation between(User firstParticipant, User secondParticipant) {
        Conversation conversation = new Conversation();
        conversation.setParticipants(List.of(firstParticipant, secondParticipant));
        return conversation;
    }

    public void  addMessage(Message message){
        if (Objects.isNull(this.getMessages())) this.messages = new ArrayList<>();
        this.messages.add(message);
    }

    public boolean hasMessages(){
        return Objects.nonNull(this.getMessages()) && !this.getMessages().isEmpty();
    }
}
