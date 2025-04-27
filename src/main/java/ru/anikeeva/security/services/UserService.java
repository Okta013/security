package ru.anikeeva.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.anikeeva.security.dto.UserDTO;
import ru.anikeeva.security.dto.UserLoginRequest;
import ru.anikeeva.security.mappers.UserMapper;
import ru.anikeeva.security.models.User;
import ru.anikeeva.security.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User(userDTO.username(), bCryptPasswordEncoder.encode(userDTO.password()));
        return userMapper.userToUserDTO(userRepository.save(user));
    }

    public String verify(UserLoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            request.username(), request.password()
            ));
        if (authentication.isAuthenticated()) return jwtService.generateToken(request.username());
        return "Failure";
    }
}
