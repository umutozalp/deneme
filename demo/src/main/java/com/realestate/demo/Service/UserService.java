package com.realestate.demo.Service;
import com.realestate.demo.Entity.User;

import java.util.List;


public interface UserService {

    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(Integer userID);
    public User getUser(Integer userID);
    public List<User> getAllUsers();

}
