package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepo;
import ru.job4j.forum.service.PostService;

import java.util.Calendar;


@Controller
public class ForumControl {

    private PostService service;
    private int id;

    @Autowired
    public ForumControl(PostService service) {

        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
       return "post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        service.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam ("empId") int ids, Model model) {
        this.id = ids;
        model.addAttribute("attribute", service.findById(ids));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("attribute") Post post) {
        post.setId(id);
        service.save(post);
        return "redirect:/";
    }


    @GetMapping("/comments")
    public String comments(@RequestParam ("id") int ids, Model model) {
        id = ids;
        model.addAttribute("attribute", service.findById(ids));
        model.addAttribute("attribute2", service.findById(ids).getAllComments());
        return "comments";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("imp") String string) {
       Post post = service.findById(id);
       Comment comment = new Comment();
       comment.setText(string);
       comment.setDate(Calendar.getInstance());
       comment.setUser(post.getUser());
       post.addComment(comment);
       comment.setPost(post);
       service.addComment(comment);
        return "redirect:comments?id=" + id;
    }

}
