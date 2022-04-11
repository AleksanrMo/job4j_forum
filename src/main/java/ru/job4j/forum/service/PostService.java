package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.CommentsRepositoty;
import ru.job4j.forum.repository.PostRepository;
import java.util.List;


@Service
public class PostService {

    private PostRepository repository;
    private CommentsRepositoty commentsRepositoty;

    @Autowired
    public void satP(PostRepository repository) {
        this.repository = repository;
    }
    @Autowired
   public void setC(CommentsRepositoty commentsRepositoty) {
        this.commentsRepositoty = commentsRepositoty;
   }

   public void addComment(Comment comment) {
        commentsRepositoty.save(comment);
   }

    public List<Post> findAll() {
        return repository.findAll();
    }

    public void save(Post post) {
        repository.save(post);
    }

    public Post findById(int id) {
       return repository.findById(id).get();
    }

    @Override
    public String toString() {
        return "PostService{" +
                "repository=" + repository +
                '}';
    }
}
