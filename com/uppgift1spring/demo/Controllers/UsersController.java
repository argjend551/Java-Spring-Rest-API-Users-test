package com.uppgift1spring.demo.Controllers;

import com.uppgift1spring.demo.Data.User;
import com.uppgift1spring.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UsersController {
    @Autowired
   private UserService _userService;

    @GetMapping("/")
    public ArrayList<User> getAllUsers(){
        return _userService.getAllUsers();
    }
    @GetMapping("/getUser/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name){
        User findUser = _userService.findUser(name);
        if(findUser == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(findUser);
    }

    @PostMapping("/addUser")
    public String addUsers(@RequestBody User user){
        return _userService.createUser(user);
    }
    @PutMapping("/updateUser/{name}")
    public ResponseEntity<User> updateUser(@PathVariable String name, @RequestBody User user){
        User userToUpdate = _userService.updateUser(user,name);
        if(userToUpdate == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(userToUpdate);
    }


}
