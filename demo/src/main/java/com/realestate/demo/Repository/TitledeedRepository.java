package com.realestate.demo.Repository;
import com.realestate.demo.Entity.Titledeed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitledeedRepository extends JpaRepository<Titledeed, Integer> {


}
