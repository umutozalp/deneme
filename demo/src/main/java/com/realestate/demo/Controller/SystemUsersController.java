package com.realestate.demo.Controller;
import com.realestate.demo.Entity.SystemUsers;
import com.realestate.demo.Service.SystemUsersService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")

public class SystemUsersController {

   private final PasswordEncoder passwordEncoder;
    private final SystemUsersService systemUsersService;

    public SystemUsersController(SystemUsersService systemUsersService,PasswordEncoder passwordEncoder) {
        this.systemUsersService = systemUsersService;
        this.passwordEncoder = passwordEncoder;
    }


    // Tek bir kullanıcının bilgileri
    @GetMapping("{userID}")
    public SystemUsers getUser(@PathVariable("userID") Integer userID)
    {

        return systemUsersService.getUser(userID);
    }
    // Tüm kullanıcıların bilgileri

    @GetMapping()
    public List<SystemUsers> getAllUsers()
    {
        return systemUsersService.getAllUsers();
    }

    @PostMapping("/create")
    public SystemUsers createUser(@RequestBody SystemUsers systemUsers){
        systemUsers.setPassword(passwordEncoder.encode(systemUsers.getPassword()));
        systemUsersService.createUser(systemUsers);
        return systemUsersService.getUser(systemUsers.getId());

    }
@PutMapping
    public SystemUsers updateUser(@RequestBody SystemUsers systemUsers)
{   systemUsers.setPassword(passwordEncoder.encode(systemUsers.getPassword()));
    systemUsersService.updateUser(systemUsers);
    return systemUsersService.getUser(systemUsers.getId());
}

    @DeleteMapping("{userID}")
    public String deleteUser(@PathVariable Integer userID) {

      systemUsersService.deleteUser(userID);
        return "User deleted successfully";
    }









}
