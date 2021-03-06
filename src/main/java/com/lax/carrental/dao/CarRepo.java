package com.lax.carrental.dao;

import com.lax.carrental.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Cars, Long> {

        Cars findById(long id);
        Cars deleteById(long id);
        Cars findByName(String name);
        Cars findByType(String type);
        Cars findByPrice(int price);

        @Query("select c from Cars c where c.type= :type AND c.booked= :isbooked")
        List<Cars> findWhere(String type, Boolean isbooked);
}
