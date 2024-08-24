package com.Ivo.spring_crud.controller;

import com.Ivo.spring_crud.entity.User;
import com.Ivo.spring_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "success add user";
    }

    @GetMapping()
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/getuser")
    public User getUser(int id){
        return userService.getUser(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable int id,@RequestBody User user){
        userService.updateUser(id,user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
