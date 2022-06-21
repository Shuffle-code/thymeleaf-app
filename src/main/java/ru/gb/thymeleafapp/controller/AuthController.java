package ru.gb.thymeleafapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.gbapimay.security.dto.AuthenticationUserDto;
import ru.gb.gbapimay.security.dto.UserDto;
import ru.gb.thymeleafapp.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @GetMapping("/reg")
    public String registrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration-form";
    }

    @PostMapping("/addNewUser")
    public String saveUser(UserDto userDto) {
        userService.save(userDto);
        return "access-allowed";
    }

}
