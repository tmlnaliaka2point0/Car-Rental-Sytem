package carrentalsystem;

   /**
    * Rental Class: Represents a rental transaction between a customer and a car.
    Programmer: Sophy Naliaka
    * BSE-05-0183/2024
    */
   public class Rental {
       private Customer customer;  // Customer who rented the car
       private Car car;  // Car being rented

       //Constructs a new Rental transaction.        
       public Rental(Customer customer, Car car) {
           this.customer = customer;
           this.car = car;
       }

       //Gets the customer in this rental.       
       public Customer getCustomer() {
           return customer;
       }

       //Gets the car in this rental.      
       public Car getCar() {
           return car;
       }

       //Returns a string representation of the rental.        
       @Override
       public String toString() {
           return "Rental [Customer=" + customer.getName() + ", Car=" + car.getModel() + "]";
       }
   }