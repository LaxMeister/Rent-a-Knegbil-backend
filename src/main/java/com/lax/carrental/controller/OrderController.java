package com.lax.carrental.controller;

import com.lax.carrental.entity.Cars;
import com.lax.carrental.entity.Orders;
import com.lax.carrental.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:5001","http://localhost:5002"}, allowCredentials = "true")
public class OrderController {

    @Autowired
    OrderService orderService;

    // Visar alla kunders nuvarande och tidigare ordrar.
    @GetMapping("/myorders")
    public List<Orders> myOrders() {
        return orderService.myOrders();
    }

    // Visar en specifik kunds alla tidigare och nuvarande ordrar.
    @GetMapping("/onecustomersorders/{customerId}")
    public List<Orders> oneCustomersOrders(@PathVariable long customerId){
        return orderService.oneCustomersOrders(customerId);
    }

    // I postman skriv bara 2st siffror.
    // Första siffran är kund ID och andra siffran är Bil ID. Exempel: 23
    @PostMapping("/ordercar/{number}")
    public Orders orderCar(@PathVariable String number, @RequestBody String date) {
        return orderService.orderCar(number, date);
    }

    // Sätter en bool på bilen som är uthyrd till false.
    @PutMapping("/updateorder")
    public Orders updateOrders(@RequestBody long id){
        return orderService.updateOrder(id);
    }

    @GetMapping("/orders/{id}")
    public Orders getOneOrder(@PathVariable long id){
        return orderService.findOrderById(id);
    }

}
