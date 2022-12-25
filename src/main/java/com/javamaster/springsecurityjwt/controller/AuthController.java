package com.javamaster.springsecurityjwt.controller;

import com.javamaster.springsecurityjwt.config.jwt.JwtProvider;
import com.javamaster.springsecurityjwt.entity.RoleEntity;
import com.javamaster.springsecurityjwt.entity.UserEntity;
import com.javamaster.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/")
    public String getUsr() {
        return "Hello. This is JWT Rest API " +
                "<br/> to test it:<br/>" +
                "<br/>1) Register user POST request: https://restc.herokuapp.com/register <br/>" +
                "body json raw: <br/>" +
                "{\n<br/>" +
                "    \"login\":\"test\",\n<br/>" +
                "    \"password\":\"test\"\n<br/>" +
                "}<br/>" +
                "<br/>2) Auth: https://restc.herokuapp.com/auth <br/>"+
                "body json raw: <br/>" +
                "{\n<br/>" +
                "    \"login\":\"test\",\n<br/>" +
                "    \"password\":\"test\"\n<br/>" +
                "}<br/>" +
                "Get token in response<br/>" +
                "<br/>3) Auth with token https://restc.herokuapp.com/user/get";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);

        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }
}
