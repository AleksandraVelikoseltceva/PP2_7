package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import model.User;
import service.UserService;

@Controller
public class UserController {
    UserService userService;
    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String showAllUsers (Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "index";
    }
    @GetMapping("/{id}")
    public String showUserById (@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/create")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable ("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable ("id") Long id) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable ("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}