package com.realestate.demo.Service;

import com.realestate.demo.Entity.SystemUsers;
import com.realestate.demo.Repository.SystemUsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemUsersServiceImpl implements SystemUsersService, UserDetailsService {


    private final SystemUsersRepository systemUsersRepository;

    public SystemUsersServiceImpl(SystemUsersRepository systemUsersRepository) {
        this.systemUsersRepository = systemUsersRepository;
    }

    @Override
    public String createUser(SystemUsers systemUsers) {

        systemUsersRepository.save(systemUsers);
        return "Success";
    }

    @Override
    public String updateUser(SystemUsers systemUsers) {
        systemUsersRepository.save(systemUsers);
        return "Success";
    }

    @Override
    public String deleteUser(Integer userID) {

        systemUsersRepository.deleteById(userID);
        return "Succes";
    }

    @Override
    public SystemUsers getUser(Integer userID) {

        return systemUsersRepository.findById(userID).get();
    }

    @Override
    public List<SystemUsers> getAllUsers() {
        return systemUsersRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUsers> userOpt = systemUsersRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            var userObj = userOpt.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(userObj.getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }


}

