package com.realestate.demo.Service;
import com.realestate.demo.Entity.SystemUsers;
import java.util.List;


public interface SystemUsersService {

     String createUser(SystemUsers systemUsers);
     String updateUser(SystemUsers systemUsers);
     String deleteUser(Integer systemUserId);
     SystemUsers getUser(Integer systemUserId);
     List<SystemUsers> getAllUsers();

}
