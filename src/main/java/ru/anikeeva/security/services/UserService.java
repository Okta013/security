package ru.anikeeva.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.anikeeva.security.dto.UserDTO;
import ru.anikeeva.security.mappers.UserMapper;
import ru.anikeeva.security.models.User;
import ru.anikeeva.security.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User(userDTO.username(), bCryptPasswordEncoder.encode(userDTO.password()));
        return userMapper.userToUserDTO(userRepository.save(user));
    }
}
