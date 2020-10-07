package com.lax.carrental.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(name = "CUSTOMER")
    private String name;

    @Column(name = "CAR")
    private String car;

    private long carId;

    @Column(name = "BOOKED")
    private boolean booked;

    @Column(name = "DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date = LocalDateTime.now();

    public Orders() {
    }

    public Orders(long id, long customerId, String name, String car, long carId, boolean booked, LocalDateTime date) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.car = car;
        this.carId = carId;
        this.booked = booked;
        this.date = date;
    }

    public Orders(String name, long customerId, String car, long carId, LocalDateTime date) {
        this.name = name;
        this.customerId = customerId;
        this.car = car;
        this.carId = carId;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customer_id) {
        this.customerId = customer_id;
    }
}
