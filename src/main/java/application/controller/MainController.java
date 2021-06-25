package application.controller;

import application.entity.User;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class MainController {

    @Autowired
    private UserService service;


    @GetMapping()
    public String userListView (Model model) {
        model.addAttribute("userListForYou", service.getUserList());
        return "users";
    }

    @GetMapping("/new")
    public String newUser (Model model) {
        model.addAttribute("userElement", new User());
        return "users/new";
    }

    @PostMapping("signup")
    public String create(@ModelAttribute ("newUser") User user){
        boolean added = service.save(user);
        if (!added){
            return "users/errorMessage";
        }
        return "redirect:/users";
    }

    @GetMapping("/edit/id{id}")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("userEdition", service.getUserByID(id));
        return "users/edit";
    }

    @PostMapping("/save/{id}")
    public String update (@ModelAttribute("userEdition") User user, @PathVariable("id") int id) {
        if (!service.update(user)) {
            return "users/errorMessage";
        }
        return "redirect:/users";
    }

    @PostMapping("/delete/id{id}")
    public String delete (@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/users";
    }
}
