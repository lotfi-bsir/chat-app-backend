package tn.vapex.domain.storage.rest;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.vapex.domain.api.mappers.EntityMapper;
import tn.vapex.domain.storage.CustomFile;

@Mapper(componentModel = "spring")
public interface CustomFileMapper extends EntityMapper<CustomFileDto, CustomFile> {
    CustomFileMapper INSTANCE = Mappers.getMapper(CustomFileMapper.class);
}
