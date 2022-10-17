package com.juyn.repository;

import com.juyn.pojo.User;
import java.util.List;

public interface UserRepository {
    boolean addUser(User user);
    List<User> getUser(String username);
    User getUserById(int userId);
}
