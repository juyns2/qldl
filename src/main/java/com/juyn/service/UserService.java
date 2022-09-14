package com.juyn.service;

import com.juyn.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author FPT SHOP
 */
public interface UserService extends UserDetailsService{
    boolean addUser(User user);
    List<User> getUser(String username);
}
