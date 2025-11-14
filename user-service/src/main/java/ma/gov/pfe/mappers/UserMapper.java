package ma.gov.pfe.mappers;

import ma.gov.pfe.dtos.UserDto;
import ma.gov.pfe.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto userDto);
    UserDto toDto(UserEntity userEntity);
}