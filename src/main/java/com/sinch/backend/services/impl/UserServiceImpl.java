package com.sinch.backend.services.impl;

import com.sinch.backend.model.User;
import com.sinch.backend.repository.UserRepository;
import com.sinch.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getTopUsers() {
        return userRepository.findAll();
    }

}
