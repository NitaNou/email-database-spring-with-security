package com.willywonka.dao;

import com.willywonka.model.RegisterUserDto;
import com.willywonka.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
