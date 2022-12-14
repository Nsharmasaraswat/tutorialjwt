package com.example.Tutorial.Application.service;

import com.example.Tutorial.Application.Entity.User;
import com.example.Tutorial.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        User user = userRepository.findByUserName(userName).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with username: " + userName));
        return UserDetailsImpl.build(user);
    }
}
