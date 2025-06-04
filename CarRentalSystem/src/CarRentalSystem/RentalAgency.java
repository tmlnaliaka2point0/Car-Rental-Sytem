package carrentalsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the rental process, including car and customer management, and rental transactions.
 Programmer: Sophy Naliaka
    * BSE-05-0183/2024
 */
public class RentalAgency {
    private List<Car> availableCars;  // List of cars available for rent
    private List<Car> rentedCars;     // List of cars currently rented
    private List<Customer> customers; // List of registered customers
    private List<RentalTransaction> transactions; // List of rental transactions

    //Constructs a new RentalAgency with empty lists.  
    public RentalAgency() {
        availableCars = new ArrayList<>();
        rentedCars = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Adds a car to the agency.
    public void addCar(Car car) {
        availableCars.add(car);
    }
    
    //Adds a customer to the agency.
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    //Rents a car to a customer and records the transaction.
    public boolean rentCar(String customerId, String carId, int rentalDuration) {
        Customer customer = findCustomer(customerId);
        Car car = findCar(carId);
        if (customer != null && car != null && !car.isRented()) {
            car.setRented(true);
            availableCars.remove(car);
            rentedCars.add(car);
            double rentalCost = calculateRentalCost(car, rentalDuration);
            RentalTransaction transaction = new RentalTransaction(customer, car, rentalDuration, rentalCost);
            transactions.add(transaction);
            System.out.println("Car rented successfully to " + customer.getName() + ". Cost: Ksh " + rentalCost);
            return true;
        } else {
            System.out.println("Rental failed: Check customer, car availability, or car status.");
            return false;
        }
    }

    //Returns a rented car and updates the transaction status.
    public boolean returnCar(String carId) {
        Car car = findCarInRented(carId);
        if (car != null && car.isRented()) {
            car.setRented(false);
            rentedCars.remove(car);
            availableCars.add(car);
            RentalTransaction transaction = findTransactionByCarId(carId);
            if (transaction != null) {
                transaction.setReturned(true);
                System.out.println("Car " + car.getModel() + " returned successfully. Transaction completed.");
            }
            return true;
        } else {
            System.out.println("Return failed: Car not rented or not found.");
            return false;
        }
    }

    //Calculates the rental cost based on the car's rate and duration.
    private double calculateRentalCost(Car car, int rentalDuration) {
        //The assumption I am going to use is Ksh 2500 per day.
        double baseRate = 2500.0; //Set for all cars in the system
        return baseRate * rentalDuration;
    }

    //Finds a customer by ID.
    private Customer findCustomer(String customerId) {
        return customers.stream().filter(c -> c.getCustomerId().equals(customerId)).findFirst().orElse(null);
    }

    //Finds a car by ID in the available cars list.
    private Car findCar(String carId) {
        return availableCars.stream().filter(c -> c.getCarId().equals(carId)).findFirst().orElse(null);
    }

    //Finds a car by ID in the rented cars list.
    private Car findCarInRented(String carId) {
        return rentedCars.stream().filter(c -> c.getCarId().equals(carId)).findFirst().orElse(null);
    }

    //Finds a transaction by car ID.
    private RentalTransaction findTransactionByCarId(String carId) {
        return transactions.stream().filter(t -> t.getCar().getCarId().equals(carId) && !t.isReturned()).findFirst().orElse(null);
    }

    //Displays all rental transactions.
    public void displayTransactions() {
        System.out.println("Rental Transactions:");
        for (RentalTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    @Override
    public String toString() {
        return "RentalAgency [Available Cars=" + availableCars.size() + ", Rented Cars=" + rentedCars.size() 
               + ", Customers=" + customers.size() + ", Transactions=" + transactions.size() + "]";
    }
}

/**
 * Represents a rental transaction between a customer and a car.
 */
class RentalTransaction {
    private Customer customer;
    private Car car;
    private int rentalDuration;
    private double cost;
    private boolean returned;

    public RentalTransaction(Customer customer, Car car, int rentalDuration, double cost) {
        this.customer = customer;
        this.car = car;
        this.rentalDuration = rentalDuration;
        this.cost = cost;
        this.returned = false;
    }

    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public int getRentalDuration() { return rentalDuration; }
    public double getCost() { return cost; }
    public boolean isReturned() { return returned; }
    public void setReturned(boolean returned) { this.returned = returned; }

    @Override
    public String toString() {
        return "Transaction [Customer=" + customer.getName() + ", Car=" + car.getModel() 
               + ", Duration=" + rentalDuration + " days, Cost=Ksh " + cost + ", Returned=" + returned + "]";
    }
}