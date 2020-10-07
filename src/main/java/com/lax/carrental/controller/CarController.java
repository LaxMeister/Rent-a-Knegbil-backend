package com.lax.carrental.controller;

import com.lax.carrental.entity.Cars;
import com.lax.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    CarService carService;

    // Listar alla bilar
    @GetMapping("/cars")
    public List<Cars> cars(){
     return carService.cars();
    }

    // Listar en specifik bil
    @GetMapping("/cars/{id}")
    public Cars getCar(@PathVariable long id){
        return carService.findCarById(id);
    }

    // Lägger till en ny bil
    @PostMapping("/addcar")
    public Cars addCar(@RequestBody Cars car){
        return carService.addCar(car);
    }

    // Tar bort en bil från databasen. (Som är sagt tidigare så ska man aldrig ta bort något från en databas)
    @DeleteMapping("/deletecar")
    public String deleteCar(@RequestBody Cars car){
        return carService.deleteCar(car);
    }

    // Uppdaterar information på befintlig bil
    @PutMapping("/updatecar")
    public Cars updateCar(@RequestBody Cars car){
        return carService.updateCar(car);
    }
}
