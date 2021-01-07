package com.lax.carrental.service;

import com.lax.carrental.dao.CarRepo;
import com.lax.carrental.dao.CustomerRepo;
import com.lax.carrental.dao.OrderRepo;
import com.lax.carrental.entity.Cars;
import com.lax.carrental.entity.Customer;
import com.lax.carrental.entity.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);

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
        return orderRepo.findAllByCustomerId(customerId);
    }

//    public Orders orderCar(String number){
//        String customerString = number.substring(0,1);
//        String carString = number.substring(1,2);
//        long customerId = Long.parseLong(customerString);
//        long carId = Long.parseLong(carString);
//        Customer customer = customerRepo.findById(customerId);
//        Cars car = carRepo.findById(carId);
//
//        Orders newOrder = new Orders(customer.getName(), customer.getId(), car.getName() + " " + car.getModel(), car.getId(), LocalDateTime.now());
//        car.setBooked(true);
//        newOrder.setBooked(true);
//        orderRepo.findAll().add(newOrder);
//        orderRepo.save(newOrder);
//        logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " -------->  " + "Customer " + newOrder.getName() + " booked " + newOrder.getCar());
//        return newOrder;
//    }

    public Orders orderCar(String number, String date){
        String customerString = number.substring(0,1);
        String carString = number.substring(1,2);
        long customerId = Long.parseLong(customerString);
        long carId = Long.parseLong(carString);
        Customer customer = customerRepo.findById(customerId);
        Cars car = carRepo.findById(carId);
        String rentDate = date.substring(0,10);
        String returnDate = date.substring(10,20);
        int rentInt = customer.getRentTimes();
        rentInt++;

        Orders newOrder = new Orders(customer.getFirstname(), customer.getLastname(), customer.getId(), car.getName() + " " + car.getModel(), car.getId(), rentDate,returnDate);
        car.setBooked(true);
        newOrder.setBooked(true);
        customer.setRentTimes(rentInt);
        customerRepo.save(customer);
        orderRepo.findAll().add(newOrder);
        orderRepo.save(newOrder);
        logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " -------->  " + "Customer " + newOrder.getFirstname() + " " + newOrder.getLastname() + " booked " + newOrder.getCar() + " WITH THE ORDER DATE OF: " + date);
        return newOrder;
    }

    public Orders updateOrder(long id){
        Orders order = orderRepo.findById(id);
        Cars car = carRepo.findById(order.getCarId());
        car.setBooked(false);
        order.setBooked(false);
        carRepo.save(car);
        orderRepo.save(order);
        logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " -------->  " + "Customer " + order.getFirstname() + " " + order.getLastname() + " unbooked " + order.getCar());
        return order;

    }

    public Orders findOrderById(long id) {
        Orders order = orderRepo.findById(id);
        return order;
    }

}
