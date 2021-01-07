package com.lax.carrental.dao;

import com.lax.carrental.entity.Customer;
import com.lax.carrental.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Orders, Long> {

    Orders findById(long id);
    Orders findByCarId(long id);
    List<Orders> findAllByCustomerId(long customerId);


}
