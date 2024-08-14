package com.realestate.demo.Controller;
import com.realestate.demo.Entity.RealestateUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.realestate.demo.Service.RealestateUsersService;

import java.util.List;

@RestController
@RequestMapping("/users")

public class RealestateUsersController {
    // Spring konteyneri, PasswordEncoder ve RealestateUsersService bean'lerini bulur ve bu bean'leri ilgili alanlara atar. Bu,
    // bağımlılıkların manuel olarak yönetilmesini ortadan kaldırır ve sınıflar arasındaki bağımlılıkları daha yönetilebilir
    // hale getirir.
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RealestateUsersService realestateUsersService;


    public RealestateUsersController(RealestateUsersService realestateUsersService,PasswordEncoder passwordEncoder) {
        this.realestateUsersService = realestateUsersService;
        this.passwordEncoder = passwordEncoder;
    }


    // Tek bir kullanıcının bilgileri
    @GetMapping("{userID}")
    public RealestateUsers getUser(@PathVariable("userID") Integer userID)
    {

        return realestateUsersService.getUser(userID);
    }
    // Tüm kullanıcıların bilgileri

    @GetMapping()
    public List<RealestateUsers> getAllUsers()
    {
        return realestateUsersService.getAllUsers();
    }

    @PostMapping("/create")
    public RealestateUsers createUser(@RequestBody RealestateUsers realestateUsers){
        realestateUsers.setPassword(passwordEncoder.encode(realestateUsers.getPassword()));
        realestateUsersService.createUser(realestateUsers);
        return realestateUsersService.getUser(realestateUsers.getId());

    }
@PutMapping
    public String updateUser(@RequestBody RealestateUsers realestateUsers)
{
    realestateUsersService.updateUser(realestateUsers);
    return "User updated successfully";
}

    @DeleteMapping("{userID}")
    public String deleteUser(@PathVariable Integer userID) {

      realestateUsersService.deleteUser(userID);
        return "User deleted successfully";
    }









}
