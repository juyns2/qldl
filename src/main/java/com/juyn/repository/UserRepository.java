package com.juyn.repository;

import com.juyn.pojo.User;
import java.util.List;

/**
 *
 * @author FPT SHOP
 */
public interface UserRepository {
    boolean addUser(User user);
    List<User> getUser(String username);
}
