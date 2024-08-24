package com.Ivo.spring_crud.service.impl;

import com.Ivo.spring_crud.entity.User;
import com.Ivo.spring_crud.repository.UserRepository;
import com.Ivo.spring_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user){
        userRepository.save(user);

    }

    @Override
    @GetMapping()
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @Override
    @GetMapping("/getuser")
    public User getUser(int id){
        return userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id "+id));
    }

    @Override

    public void updateUser(int id, User user) {
        userRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        User user= userRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id "+id));
        userRepository.delete(user);
    }
}
