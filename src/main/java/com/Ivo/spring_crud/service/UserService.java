package com.Ivo.spring_crud.service;

import com.Ivo.spring_crud.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
