package yyf.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yyf.springboot.thymeleaf.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private List<User> userList = new ArrayList<>();
    private Long userIdCounter = 1L;

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userList);
        return "userList";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User newUser = new User(userIdCounter++, name, email);
        userList.add(newUser);
        return "redirect:/user/list";
    }
}