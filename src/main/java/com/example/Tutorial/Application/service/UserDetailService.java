package com.example.Tutorial.Application.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {

    UserDetails loadUserByUsername(String userName);
}
