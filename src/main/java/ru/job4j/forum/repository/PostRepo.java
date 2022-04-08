package ru.job4j.forum.repository;


import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostRepo {
    private final List<Post> posts = new ArrayList<>();


    public PostRepo() {
        posts.add(Post.of(1,"Продаю машину ладу 01.", "Здесь будет описание"));
        posts.add(Post.of(2,"Продаю машину ладу 02.", "Здесь будет описание2"));
    }

    public List<Post> getAll() {
        return posts;
    }

    public void save(Post post) {
        posts.add(post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void update(int id, Post post) {
        posts.set(id, post);
    }


}