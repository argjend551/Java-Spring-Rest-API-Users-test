package com.uppgift1spring.demo.Repositories;

import com.uppgift1spring.demo.Data.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class UserRepository {
ArrayList<User> UserList = new ArrayList<>();

        public String createUser(User user){
            UserList.add(user);
            return "User Created!";
        }

        public ArrayList<User> getAllUsers(){
            return UserList;
        }

        public boolean userAlreadyExist(User user){
            return UserList.stream().anyMatch((x) -> x.getName().equals(user.getName()));
        }

        public User findUser(String name){
            return UserList.stream().filter((x) -> x.getName().equals(name)).findAny()
                    .orElse(null);
        }
    public User updateUser(User user,User userToUpdate,String name){
        userToUpdate.setAge(user.getAge());
        userToUpdate.setName(user.getName());
        return user;

    }


}
