package com.jobposts.demo.controller;

import com.jobposts.demo.entities.Users;
import com.jobposts.demo.service.UsersService;
import com.jobposts.demo.service.UsersTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UsersController {
    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("getAllTypes", usersTypeService.findAll());
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegister(@Valid Users users, Model model) {
        Optional<Users> optionalUsers = usersService.getUserByEmail(users.getEmail());
        if (optionalUsers.isPresent()) {
            model.addAttribute("error", "This email already exists, try to login or use a different email");
            model.addAttribute("getAllTypes", usersTypeService.findAll());
            model.addAttribute("user", new Users());
            return "register";
        }

        usersService.addUser(users);
        return "dashboard";
    }
}
