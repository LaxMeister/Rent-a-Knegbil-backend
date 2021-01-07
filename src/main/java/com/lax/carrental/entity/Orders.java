package com.lax.carrental.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.SQLOutput;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(name = "CUSTOMER_FIRSTNAME")
    private String firstname;

    @Column(name = "CUSTOMER_LASTNAME")
    private String lastname;

    @Column(name = "CAR")
    private String car;

    private long carId;

    @Column(name = "BOOKED")
    private boolean booked;

    @Column(name = "RENT_DATE")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime date = LocalDateTime.now();
    private String rentDate;

    @Column(name = "RETURN_DATE")
    private String returnDate;

    public Orders() {
    }

    //    public Orders(long id, long customerId, String name, String car, long carId, boolean booked, LocalDateTime date) {
//        this.id = id;
//        this.customerId = customerId;
//        this.name = name;
//        this.car = car;
//        this.carId = carId;
//        this.booked = booked;
//        this.date = date;
//    }


//    public Orders(long id, long customerId, String name, String car, long carId, boolean booked, String date) {
//        this.id = id;
//        this.customerId = customerId;
//        this.name = name;
//        this.car = car;
//        this.carId = carId;
//        this.booked = booked;
//        this.date = date;
//    }

//    public Orders(String name, long customerId, String car, long carId, LocalDateTime date) {
//        this.name = name;
//        this.customerId = customerId;
//        this.car = car;
//        this.carId = carId;
//        this.date = date;
//    }


    public Orders( String firstname, String lastname, long customerId, String car, long carId, String rentDate, String returnDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerId = customerId;
        this.car = car;
        this.carId = carId;
        this.setRentDate(rentDate);
        this.setReturnDate(returnDate);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }

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

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String date) {
        this.rentDate = date;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
