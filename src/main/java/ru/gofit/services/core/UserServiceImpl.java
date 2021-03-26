package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gofit.dto.PasswordRequest;
import ru.gofit.dto.UserDto;
import ru.gofit.dto.UserRequest;
import ru.gofit.entities.User;
import ru.gofit.exceptions.DataBadRequestException;
import ru.gofit.exceptions.DataNotFoundException;
import ru.gofit.mappers.UserMapper;
import ru.gofit.repositories.AuthorityRepository;
import ru.gofit.repositories.UserRepository;
import ru.gofit.security.JwtUser;
import ru.gofit.services.api.UserService;

import java.util.List;

import static ru.gofit.helpers.Messages.*;
import static ru.gofit.helpers.Roles.ROLE_USER;

/**
 * Сервис пользователей
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    // Необходимые сервисы, мапперы и репозитории
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public UserDto getDtoById(Long id) {
        return userMapper.mapEntityToDto(findById(id));
    }

    @Override
    public UserDto getDtoByAuthentication(Authentication authentication) {
        return userMapper.mapEntityToDto(findById(getUserId(authentication)));
    }

    @Override
    public JwtUser getJwtByUsername(String username) {
        return userMapper.mapEntityToJwt(findByUsername(username));
    }

    @Override
    public Long getIdByAuthentication(Authentication authentication) {
        return getUserId(authentication);
    }

    @Override
    public List<UserDto> getAllDto() {
        return userMapper.mapEntityToDto(userRepository.findAll());
    }

    @Override
    public UserDto save(UserRequest userRequest) {
        String username = userRequest.getUsername();
        if (userRepository.findByUsername(username).isPresent()) {
            throw new DataBadRequestException(String.format(USER_ALREADY_EXIST, username));
        }

        User newUser = userMapper.mapDtoToEntity(userRequest);
            newUser.getAuthorities().add(authorityRepository.findByAuthority(ROLE_USER));
        return userMapper.mapEntityToDto(userRepository.save(newUser));
    }

    @Override
    public UserDto update(UserDto userDto, Authentication authentication) {
        User user = userMapper.update(findById(getUserId(authentication)), userDto);
        return userMapper.mapEntityToDto(userRepository.save(user));
    }

    @Override
    public boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return userRepository.existsById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.mapEntityToJwt(findByUsername(username));
    }

    @Override
    public boolean updatePassword(PasswordRequest passwordRequest,
                                  Authentication authentication) {
        if (!passwordRequest.getNewPassword().equals(passwordRequest.getNewPasswordConfirm())) {
            throw new DataBadRequestException(PASSWORDS_MISMATCH);
        }

        User user = findByUsername(authentication.getName());
        if (!passwordEncoder.matches(passwordRequest.getOldPassword(), user.getPassword())) {
            throw new DataBadRequestException(OLD_PASSWORD_INVALID);
        } else {
            user.setPassword(passwordEncoder.encode(passwordRequest.getNewPassword()));
            userRepository.save(user);
            return true;
        }
    }

    /**
     * Найти пользователя по id
     */
    private User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id)));
    }

    /**
     * Найти пользователя по username
     */
    private User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_BY_USERNAME, username)));
    }

    /**
     * Получить id пользователя по данным аутентификации
     */
    private Long getUserId(Authentication authentication) {
        return ((JwtUser) authentication.getPrincipal()).getId();
    }
}
