package carrentalsystem;

   /**
    * Customer Class: Represents a customer who can rent cars from the rental system.
    Programmer: Sophy Naliaka
    * BSE-05-0183/2024
    */
   public class Customer {
       private String customerId;  // Unique identifier for the customer
       private String name;  // Name of the customer

       //Constructs a new Customer with the specified ID and name.       
       public Customer(String customerId, String name) {
           this.customerId = customerId;
           this.name = name;
       }

      //Gets the customer's ID.
       public String getCustomerId() {
           return customerId;
       }

       //Gets the customer's name.
       public String getName() {
           return name;
       }

       //Returns a string representation of the customer.
       
       @Override
       public String toString() {
           return "Customer [ID=" + customerId + ", Name=" + name + "]";
       }
   }