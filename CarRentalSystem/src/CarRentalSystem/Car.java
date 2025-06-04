package carrentalsystem;

   /**
    * Car Class: Represents a car available for rent in the rental system.
    Programmer: Sophy Naliaka
    * BSE-05-0183/2024
    */
   public class Car {
       private String carId;  // Unique identifier for the car
       private String model;  // Car model (e.g., Toyota Camry)
       private boolean isRented;  // Rental status of the car

       //Constructs a new Car with the specified ID and model.
       public Car(String carId, String model) {
           this.carId = carId;
           this.model = model;
           this.isRented = false;  // Car is not rented initially
       }

       //Gets the car's ID
       public String getCarId() {
           return carId;
       }

       //Gets the car's model.     
       public String getModel() {
           return model;
       }

       //Checks if the car is rented.
       public boolean isRented() {
           return isRented;
       }

       //Sets the rental status of the car.
       public void setRented(boolean rented) {
           this.isRented = rented;
       }

       //Returns a string representation of the car.
       @Override
       public String toString() {
           return "Car [ID=" + carId + ", Model=" + model + ", Rented=" + isRented + "]";
       }
   }