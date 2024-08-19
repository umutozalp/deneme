//package com.realestate.demo.Service;
//
//import com.realestate.demo.Entity.RealestateUsers;
//import com.realestate.demo.Repository.RealestateUsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class userDetailsService implements UserDetailsService {
//
//    @Autowired
//    RealestateUsersRepository realestateUsersRepository;
//
//    //Username adında bir string değer alır ve bir istisna fırlatabilir.
//    //Aldığı username'i realestateUsersRepository'de arar ve sonucu Optional olarak döner. Kullanıcı bulunduysa bunu userObj değişkenine atar ve
//    //gerekli bilgileri alarak UserDetails nesnesini oluşturur.
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<RealestateUsers> userOpt = realestateUsersRepository.findByUsername(username);
//        if (userOpt.isPresent()) {
//            var userObj = userOpt.get();
//            return User.builder()
//                    .username(userObj.getUsername())
//                    .password(userObj.getPassword())
//                    .roles(getRoles(userObj))
//                    .build();
//        } else {
//            throw new UsernameNotFoundException(username);
//        }
//    }
////  .roles metodu genelde bir dizi değerler bekler. Bu metod bir realestateUsers nesnesi alır ve rolünü konrol eder eğer rol yoksa otomatik olarak
//    // rolü USER olarak ayarlar. Eğer rol varsa da ve bu rol ADMIN,USER şeklinde de olabilir diye bunu split metodu ile bölerek atar.
//    private String[] getRoles(RealestateUsers realestateUsers) {
//       if (realestateUsers.getRole() == null) {
//           return new String[]{"USER"};
//       }return realestateUsers.getRole().split(",");
//
//    }
//
//
//
//}
