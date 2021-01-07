package com.lax.carrental.service;

import com.lax.carrental.dao.CarRepo;
import com.lax.carrental.dao.OrderRepo;
import com.lax.carrental.entity.Cars;
import com.lax.carrental.entity.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);
    @Autowired
    CarRepo carRepo;

    @Autowired
    OrderRepo orderRepo;

    public List<Cars> cars() {
        return carRepo.findAll();
    }

    public Cars findCarById(long id) {
        Cars car = carRepo.findById(id);
        return car;
    }

    public Cars addCar(Cars cars) {
        carRepo.findAll().add(cars);
        carRepo.save(cars);
        logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " -------->  " + cars.getName() + " " + cars.getModel() + " was created by admin");
        return cars;
    }

    public Cars updateCar(Cars car) {
        Cars updatedCar = new Cars();
        updatedCar.setId(car.getId());
        updatedCar.setPrice(car.getPrice());
        updatedCar.setName(car.getName());
        updatedCar.setModel(car.getModel());
        updatedCar.setDate(car.getDate());
        updatedCar.setBooked(car.isBooked());
        updatedCar.setDetails(car.getDetails());
        updatedCar.setType(car.getType());
        carRepo.save(updatedCar);
        logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " -------->  " + car.getName() + " " + car.getModel() + " was updated by admin");
        return updatedCar;
    }

    public String deleteCar(Cars car) {
        Cars carInfo = carRepo.findById(car.getId());
        Cars carDelete = carRepo.deleteById(car.getId());
        List<Cars> newCar = carRepo.findWhere(carInfo.getType(),false);
        if(carInfo.isBooked() == true){
            Orders order = orderRepo.findByCarId(carInfo.getId());
            order.setCar(newCar.get(0).getName() + " " + newCar.get(0).getModel());
            order.setCarId(newCar.get(0).getId());
            newCar.get(0).setBooked(true);
            orderRepo.save(order);
            carRepo.save(newCar.get(0));
        }


        logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " -------->  " + carInfo.getName() + " " + carInfo.getModel() + " was deleted by admin");
        return carInfo.getName() + " " + carInfo.getModel() + " was deleted";
    }

//    public List<Cars> deleteCarById(Cars car){
//       return carRepo.deleteById(car.getId());
//
//    }
}
