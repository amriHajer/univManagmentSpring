package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.User;
import com.example.schoolmanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).orElseThrow();
    }

    public List<User> findByRole(String role) {
        return userRepo.findByRole(role);
    }


    public void deleteUserById(Integer id) {
        userRepo.deleteById(id);
    }


}
