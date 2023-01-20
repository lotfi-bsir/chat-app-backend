package tn.vapex.domain.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tn.vapex.domain.api.dtos.MessageDto;
import tn.vapex.domain.entitites.Message;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MessageMapper extends EntityMapper<MessageDto, Message> {
}