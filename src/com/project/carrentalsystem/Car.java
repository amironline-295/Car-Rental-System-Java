package com.project.carrentalsystem;

public class Car {
    private String id;
    private String model;
    private String brand;
    private double basePricePerDay;
    private boolean isAvaliable;

    public Car(String id, String model, String brand, double basePricePerDay){
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.basePricePerDay = basePricePerDay;
        this.isAvaliable = true;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }
    public double calculatePrice(int rentalsDays){
        return basePricePerDay * rentalsDays;
    }
    public void rent(){
        isAvaliable = false;
    }
    public void returnCar(){
        isAvaliable = true;
    }

}
