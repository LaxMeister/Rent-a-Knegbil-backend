package com.lax.carrental.service;

import com.lax.carrental.dao.CarRepo;
import com.lax.carrental.dao.CustomerRepo;
import com.lax.carrental.dao.OrderRepo;
import com.lax.carrental.entity.Cars;
import com.lax.carrental.entity.Customer;
import com.lax.carrental.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CarRepo carRepo;

    public List<Orders> myOrders() {
      return orderRepo.findAll();
    }

    public List<Orders> oneCustomersOrders(long customerId) {
        return (List<Orders>) orderRepo.findByCustomerId(customerId);
    }

    public Orders orderCar(String number){
        String customerString = number.substring(0,1);
        String carString = number.substring(1,2);
        long customerId = Long.parseLong(customerString);
        long carId = Long.parseLong(carString);
        Customer customer = customerRepo.findById(customerId);
        Cars car = carRepo.findById(carId);

        Orders newOrder = new Orders(customer.getName(), customer.getId(), car.getName() + " " + car.getModel(), car.getId(), LocalDateTime.now());
        car.setBooked(true);
        newOrder.setBooked(true);
        orderRepo.findAll().add(newOrder);
        orderRepo.save(newOrder);
        return newOrder;
    }

    public Orders updateOrder(long id){
        Orders order = orderRepo.findById(id);
        Cars car = carRepo.findById(order.getCarId());
        car.setBooked(false);
        order.setBooked(false);
        carRepo.save(car);
        orderRepo.save(order);
        return order;

    }

}
