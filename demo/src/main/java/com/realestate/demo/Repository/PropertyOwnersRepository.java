package com.realestate.demo.Repository;

import com.realestate.demo.Entity.PropertyOwners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyOwnersRepository extends JpaRepository<PropertyOwners, Integer> {
}
