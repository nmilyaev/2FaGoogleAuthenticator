package com.example.service;

import com.example.db.UserRepository;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user){
        return repository.save(user);
    }

    public User getById(int id){
        final Optional<User> byId = repository.findById(Integer.toString(id));
        return byId.isPresent()? byId.get(): null;
    }

    public void deleteUser(User user){
        repository.delete(user);
    }
}
