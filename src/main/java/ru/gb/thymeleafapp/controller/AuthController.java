package ru.gb.thymeleafapp.controller;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.security.api.AuthenticationUserGateway;
import ru.gb.gbapimay.security.dto.AuthenticationUserDto;
import ru.gb.gbapimay.security.dto.UserDto;
import ru.gb.thymeleafapp.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationUserGateway authenticationUserGateway;

    @GetMapping("/reg")
    public String registrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration-form";
    }

    @PostMapping("/addNewUser")
    public String saveUser(@Validated @RequestBody UserDto userDto) {
        userService.save(userDto);
        return "access-allowed";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("authenticationUserDto", new AuthenticationUserDto());
        return "authentication-form";
    }

    @PostMapping("/login")
    public String sendAuth(@Validated @RequestBody AuthenticationUserDto authenticationUserDto) {
        userService.login(authenticationUserDto);

        return "access-allowed";
//        return "redirect:/product/all";

    }

}
