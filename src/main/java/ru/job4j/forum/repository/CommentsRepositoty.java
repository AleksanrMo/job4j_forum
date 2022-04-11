package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.forum.model.Comment;

public interface CommentsRepositoty extends JpaRepository<Comment, Integer> {
}
