package com.realestate.demo.Service;
import com.realestate.demo.Entity.RealestateUsers;

import java.util.List;


public interface RealestateUsersService {

    public String createUser(RealestateUsers realestateUsers);
    public String updateUser(RealestateUsers realestateUsers);
    public String deleteUser(Integer realestateUserId);
    public RealestateUsers getUser(Integer realestateUserId);
    public List<RealestateUsers> getAllUsers();

}
