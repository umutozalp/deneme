package com.realestate.demo.Service;

import com.realestate.demo.Entity.User;
import com.realestate.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    UserServiceImpl implements UserService {


    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String deleteUser(Integer userID) {

        userRepository.deleteById(userID);
        return "Succes";
    }

    @Override
    public User getUser(Integer userID) {

        return userRepository.findById(userID).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
