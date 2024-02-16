package com.quarkus.developers.mappers;

import com.quarkus.developers.converters.DateConverter;
import com.quarkus.developers.dto.FooDto;
import com.quarkus.developers.entities.FooEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {DateConverter.class}, componentModel = "jakarta")
public interface FooMapper {
    FooEntity dtoToEntity(FooDto dto);

    FooDto entityToDto(FooEntity entity);
}
