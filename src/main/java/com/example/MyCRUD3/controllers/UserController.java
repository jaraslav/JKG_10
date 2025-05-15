package com.example.MyCRUD3.controllers;

import com.example.MyCRUD3.model.User;
import com.example.MyCRUD3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService carService) {
        this.userService = carService;
    }

    @GetMapping()
    public String showUsers(@RequestParam(value = "id", defaultValue = "0") int id, ModelMap model) {
        if (id != 0) {
            model.addAttribute("user", userService.getUser(id));
            return "user";
        }
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("save")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", defaultValue = "0") int id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("update")
    public String update(@RequestParam(value = "id", defaultValue = "0") int id, User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("delete")
    public String delete(@RequestParam(value = "id", defaultValue = "0") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}