package com.example.MyCRUD3.service;

import com.example.MyCRUD3.model.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(int id);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}
