package ru.job4j.forum.repository;



import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {

    private List<User>  list = new ArrayList<>();

    public UserRepo( ) {
        list.add(User.of("user", "user"));
        list.add(User.of("test", "test"));
    }

    public void save(User user) {
        list.add(user);
    }

    public List<User> get() {
        return list;
    }

}
