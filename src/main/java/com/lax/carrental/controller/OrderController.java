package com.lax.carrental.controller;

import com.lax.carrental.entity.Orders;
import com.lax.carrental.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
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
    @PostMapping("/ordercar")
    public Orders orderCar(@RequestBody String number) {
        return orderService.orderCar(number);
    }

    // Sätter en bool på bilen som är uthyrd till false.
    @PutMapping("/updateorder")
    public Orders updateOrders(@RequestBody long id){
        return orderService.updateOrder(id);
    }


}
