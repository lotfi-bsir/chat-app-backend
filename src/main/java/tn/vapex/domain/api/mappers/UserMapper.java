package tn.vapex.domain.api.mappers;

import org.mapstruct.*;
import tn.vapex.domain.api.dtos.UserDto;
import tn.vapex.domain.entitites.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper extends EntityMapper<User, UserDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}