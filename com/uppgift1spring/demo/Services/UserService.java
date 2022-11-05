package com.uppgift1spring.demo.Services;

import com.uppgift1spring.demo.Data.User;
import com.uppgift1spring.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private final UserRepository _userRepository;

    public UserService(UserRepository _userRepository){
        this._userRepository = _userRepository;
    }

    public User createUser(User user){
        boolean userAlreadyExist = _userRepository.userAlreadyExist(user);
        return userAlreadyExist ? null : _userRepository.createUser(user);
    }
    public ArrayList<User> getAllUsers(){
        return _userRepository.getAllUsers();
    }
    public User findUser(String name){
        return _userRepository.findUser(name);
    }

    public User updateUser(User user,String name){
        User userToUpdate = findUser(name);
        if(userToUpdate == null) return null;
        return _userRepository.updateUser(user,userToUpdate,name);
    }
}
