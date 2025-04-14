package ru.anikeeva.security.mappers;

import org.mapstruct.Mapper;
import ru.anikeeva.security.dto.UserDTO;
import ru.anikeeva.security.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}
