package controller;


import model.User;
import service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "index";
    }

    @GetMapping("/")
    public String show(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", usersService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute User user) {
        usersService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", usersService.show(id));
        return "edit";
    }

    @PatchMapping("/")
    public String update(@ModelAttribute User user, @RequestParam("id") int id) {
        usersService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/")
    public String delete(@RequestParam("id") int id) {
        usersService.delete(id);
        return "redirect:/users";
    }

}