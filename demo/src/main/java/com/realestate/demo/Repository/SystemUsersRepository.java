package com.realestate.demo.Repository;
import com.realestate.demo.Entity.SystemUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface SystemUsersRepository extends JpaRepository<SystemUsers, Integer> {
   Optional<SystemUsers> findByUsername(String username);
}
