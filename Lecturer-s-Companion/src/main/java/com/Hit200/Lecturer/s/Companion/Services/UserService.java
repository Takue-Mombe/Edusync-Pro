package com.Hit200.Lecturer.s.Companion.Services;

import com.Hit200.Lecturer.s.Companion.Models.user;
import com.Hit200.Lecturer.s.Companion.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public user registerUser(user users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersRepository.save(users);
    }

    public Optional<user> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
