package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/user")
    public String userInfo() {
        return "user";
    }

    @GetMapping("/admin/users")
    public String getAllUsers(@RequestParam(value = "alluser", required = false) String userlist, Model model) {
        model.addAttribute("users", userService.findAll(userlist));
        return "users";
    }

    @GetMapping("/user_id")
    public String getUser(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("user", userService.getById(Long.parseLong(id)));
        return "show";
    }

    @GetMapping("/admin/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add_new_user";
    }

    @PostMapping("/admin/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/admin/edit_user")
    public String editUser(@RequestParam("id") String id, Model model) {
        model.addAttribute("user", userService.getById(Long.parseLong(id)));
        return "edit_user";
    }

    @PostMapping("/admin/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/admin/delete_user")
    public String deleteUser(@RequestParam("id") String id) {
        userService.deleteById(Long.parseLong(id));
        return "redirect:/users";
    }
}