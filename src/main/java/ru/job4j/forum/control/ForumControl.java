package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepo;


@Controller
public class ForumControl {

    private PostRepo postService;
    private int id;
    public ForumControl(PostRepo postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String create() {
       return "post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam ("empId") int ids, Model model) {
        this.id = ids;
        model.addAttribute("attribute", postService.findById(ids));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("attribute") Post post) {
        postService.update(id, post);
        return "redirect:/";
    }


    @GetMapping("/comments")
    public String comments(@RequestParam ("id") int ids, Model model) {
        id = ids;
        model.addAttribute("attribute", postService.findById(ids));
        model.addAttribute("attribute2", postService.findById(ids).getAllComments());
        return "comments";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("imp") String string) {
       Post post = postService.findById(id);
        post.addComment(string);
        return "redirect:comments?id=" + id;
    }

}
