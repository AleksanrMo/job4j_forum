package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepo;

@Controller
public class RegControl {


    private UserRepo userRepo;

    public RegControl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

@GetMapping("/reg")
    public String reg(){
    return "reg";
}
    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/login";
    }

}
