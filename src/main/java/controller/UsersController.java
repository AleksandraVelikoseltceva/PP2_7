package controller;


import model.User;
import service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/")
    public String show(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/")
    public String update(@ModelAttribute User user, @RequestParam("id") int id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

}