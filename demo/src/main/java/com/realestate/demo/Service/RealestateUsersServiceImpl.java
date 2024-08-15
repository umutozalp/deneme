package com.realestate.demo.Service;

import com.realestate.demo.Entity.RealestateUsers;

import com.realestate.demo.Repository.RealestateUsersRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealestateUsersServiceImpl implements RealestateUsersService,UserDetailsService {


    RealestateUsersRepository realestateUsersRepository;


    public RealestateUsersServiceImpl(RealestateUsersRepository realestateUsersRepository) {
        this.realestateUsersRepository = realestateUsersRepository;
    }


    @Override
    public String createUser(RealestateUsers realestateUser) {

        realestateUsersRepository.save(realestateUser);
        return "Success";
    }

    @Override
    public String updateUser(RealestateUsers realestateUsers) {
        realestateUsersRepository.save(realestateUsers);
        return "Success";
    }

    @Override
    public String deleteUser(Integer userID) {

        realestateUsersRepository.deleteById(userID);
        return "Succes";
    }

    @Override
    public RealestateUsers getUser(Integer userID) {

        return realestateUsersRepository.findById(userID).get();
    }

    @Override
    public List<RealestateUsers> getAllUsers() {
        return realestateUsersRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<RealestateUsers> userOpt = realestateUsersRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            var userObj = userOpt.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
    //  .roles metodu genelde bir dizi değerler bekler. Bu metod bir realestateUsers nesnesi alır ve rolünü konrol eder eğer rol yoksa otomatik olarak
    // rolü USER olarak ayarlar. Eğer rol varsa da ve bu rol ADMIN,USER şeklinde de olabilir diye bunu split metodu ile bölerek atar.
    private String[] getRoles(RealestateUsers realestateUsers) {
        if (realestateUsers.getRole() == null) {
            return new String[]{"USER"};
        }return realestateUsers.getRole().split(",");

    }


}

