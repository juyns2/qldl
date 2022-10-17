package com.juyn.service;

import com.juyn.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    boolean addUser(User user);
    List<User> getUser(String username);
    User getUserById(int userId);
}
