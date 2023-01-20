package tn.vapex.domain.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tn.vapex.domain.api.dtos.ConversationDto;
import tn.vapex.domain.api.mappers.EntityMapper;
import tn.vapex.domain.entitites.Conversation;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",uses = {MessageMapper.class, UserMapper.class})
public interface ConversationMapper extends EntityMapper<ConversationDto, Conversation> {
}