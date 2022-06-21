package ru.gb.thymeleafapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.gbapimay.security.api.AuthenticationUserGateway;
import ru.gb.gbapimay.security.api.UserGateway;
import ru.gb.gbapimay.security.dto.AuthenticationUserDto;
import ru.gb.gbapimay.security.dto.UserDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserGateway userGateway;
    private final AuthenticationUserGateway authenticationUserGateway;

    public void save(UserDto userDto) {
        if (userDto.getId() != null) {
            userGateway.handleUpdate(userDto.getId(), userDto);
        } else {
            userGateway.handlePost(userDto);
        }
    }

    public UserDto findById(Long id) {
        return userGateway.getUser(id).getBody();
    }

    public List<UserDto> findAll() {
        return userGateway.getUserList();
    }

    public void deleteById(Long id) {
        userGateway.deleteById(id);
    }

    public void login(AuthenticationUserDto authenticationUserDto){
        authenticationUserGateway.login(authenticationUserDto);
    }
}
