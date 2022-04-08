package ru.job4j.forum.model;

import java.util.*;


public class Post {

    private int id;
    private String name;
    private String description;
    private Calendar created;
    private User user;
    private List<String> list = new ArrayList<>();



    public static Post of(int id, String st, String desc) {
        Post post = new Post();
        post.name = st;
        post.id = id;
        post.description = desc;
        return post;
    }

    public void addComment(String comment) {

       list.add(comment);
    }
    public List<String> getAllComments() {
        return list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(name, post.name) && Objects.equals(description, post.description) && Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", user=" + user +
                ", map=" + list +
                '}';
    }
}
