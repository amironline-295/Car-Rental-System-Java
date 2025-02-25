package com.project.carrentalsystem;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CarRentalSystem {
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car, Customer customer, int days){
        if(car.isAvaliable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }
        else{
            System.out.println("Car is not available");
        }
    }
    public void returnCar(Car car){
        Rental rentalToRemove = null;
        for(Rental rental : rentals){
            if(rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }
        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
            car.returnCar();
            System.out.println("Car returned successfully\n");
        }
        else{
            System.out.println("Car was not rented\n");
        }
    }
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("*** Welcome to Rental Car Services ****");
            System.out.println("Rent a car");
            System.out.println("Return a car");
            System.out.println("Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                System.out.println("\n*** Rent a car **\n");
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();

                System.out.println("\n*** Available Cars ***");
                for(Car car : cars){
                    if(car.isAvaliable()){
                        System.out.println(car.getId() + " - " + car.getModel() + " " + car.getBrand());
                    }
                }
                System.out.print("Enter the car ID you want to rent: ");
                String carID = scanner.nextLine();

                System.out.print("Enter the number of days you want to rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car : cars){
                    if(car.getId().equals(carID) && car.isAvaliable()){
                        selectedCar = car;
                        break;
                    }
                }
                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n*** Rental Information ***\n");
                    System.out.println("Customer ID: " + newCustomer.getId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getModel() + " " + selectedCar.getBrand());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n",  totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar rented successfully.");
                    }
                    else{
                        System.out.println("\nRental cancelled.");
                    }

                }
                else{
                    System.out.println("Invalid car selection or car is not available for rent.");
                }
            }
            else if(choice == 2){
                System.out.println("\n*** Return Car ***\n");
                System.out.print("Enter the car ID which you want to return: ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for(Car car : cars){
                    if(car.getId().equals(carId) && !car.isAvaliable()){
                        carToReturn = car;
                        break;
                    }
                }
                if(carToReturn != null){
                    Customer customer = null;
                    for(Rental rental : rentals){
                        if(rental.getCar() == carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if(customer != null){
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getName());
                    }
                    else{
                        System.out.println("car was not returned or information is missing. ");
                    }
                }
                else{
                    System.out.println("car ID was incorrect or car is not rented. ");
                }
            }
            else if(choice == 3){
                break;
            }
            else{
                System.out.println("Please enter the correct choice.");
            }
        }
        System.out.println("\nThank you for using our Car Rental Services!");
    }
}
