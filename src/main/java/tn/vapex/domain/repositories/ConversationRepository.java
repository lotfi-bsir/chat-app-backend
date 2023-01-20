package tn.vapex.domain.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.vapex.domain.entitites.Conversation;
import tn.vapex.domain.entitites.User;

import java.util.List;
import java.util.Optional;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {

    @Query("select c from Conversation c where ?1 member of c.participants and ?2 member of c.participants")
    Optional<Conversation> findConversationBetween(User firstParticipant,User secondParticipant);
}