package com.realestate.demo.Repository;
import com.realestate.demo.Entity.RealestateUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RealestateUsersRepository extends JpaRepository<RealestateUsers, Integer> {
   Optional<RealestateUsers> findByUsername(String username);
}
