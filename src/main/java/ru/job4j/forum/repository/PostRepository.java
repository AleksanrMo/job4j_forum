package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT DISTINCT p FROM Post p "
            + "LEFT JOIN FETCH p.list "
            + "ORDER BY p.id")

    List<Post> findAll();

    @Query("SELECT DISTINCT p FROM Post p "
            + "LEFT JOIN FETCH p.list r "
            + " WHERE p.id = ?1")
    Optional<Post> findById(Integer integer);
}
