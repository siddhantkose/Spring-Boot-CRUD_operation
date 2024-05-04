package com.operation.CRUD.Service;

import com.operation.CRUD.Entity.User;
import com.operation.CRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void removeById(long id){
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }
}
