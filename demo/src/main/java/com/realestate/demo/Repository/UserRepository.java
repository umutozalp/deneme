package com.realestate.demo.Repository;
import com.realestate.demo.Entity.Tenant;
import com.realestate.demo.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
