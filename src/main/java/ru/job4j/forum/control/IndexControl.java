package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.repository.PostRepo;


@Controller
public class IndexControl {

   private PostRepo posts;

    @Autowired
    public IndexControl (PostRepo posts) {
        this.posts = posts;
    }

    @GetMapping({"/"})
    public String index(Model model) {
        model.addAttribute("posts", posts.getAll());
        return "index";
    }
}
