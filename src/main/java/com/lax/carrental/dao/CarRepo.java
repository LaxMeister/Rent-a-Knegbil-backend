package com.lax.carrental.dao;

import com.lax.carrental.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Cars, Long> {

        Cars findById(long id);
        Cars deleteById(long id);
        Cars findByName(String name);
}
