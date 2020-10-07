package com.lax.carrental.dao;

import com.lax.carrental.entity.Customer;
import com.lax.carrental.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, Long> {

    Orders findById(long id);
    Orders findByCustomerId(long customer_id);


}
