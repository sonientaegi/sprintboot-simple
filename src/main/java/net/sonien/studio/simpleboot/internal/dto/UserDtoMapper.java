package net.sonien.studio.simpleboot.internal.dto;

import net.sonien.studio.simpleboot.internal.repository.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDtoMapper {
    // https://velog.io/@letsdev/MapStruct-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EB%B3%80%ED%99%98-2-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90%EC%84%9C-%EC%82%AC%EC%9A%A9-%EA%B8%B0%EC%B4%88-%EC%84%B8%ED%8C%85

    // https://mapstruct.org/documentation/stable/reference/html/#retrieving-mapper
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    UserDto fromEntity(User user);

    // https://www.baeldung.com/mapstruct-ignore-unmapped-properties
    @Mapping(target = "session", ignore = true)
    User toEntity(UserDto userDto);

    UserResponse toResponse(UserDto user);

    UserDto fromRequest(UserRequest userRequest);
}
