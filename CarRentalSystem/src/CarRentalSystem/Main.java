package carrentalsystem;

/**
 Assignment 1 OOP2 Question 1: The Main Car Rental System that demonstrates the functionality.
 Programmer: Sophy Naliaka
    * BSE-05-0183/2024
 */
public class Main {
    //Main method to run the car rental system.
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Add cars (samples)
        agency.addCar(new Car("Cr001", "Lexus LX 570"));
        agency.addCar(new Car("Cr002", "Mercedes-Benz Maybach GLS 600"));
        agency.addCar(new Car("Cr003", "Audi Q5"));

        // Add customers
        agency.addCustomer(new Customer("Cs001", "Sebastian Mureithi"));
        agency.addCustomer(new Customer("Cs002", "Jasmine Nekesa"));
        agency.addCustomer(new Customer("Cs003", "Trevor Odhiambo"));
        agency.addCustomer(new Customer("Cs004", "Caleb Korir"));
        agency.addCustomer(new Customer("Cs005", "Agnes Wambui"));
        
        // Perform rental transactions
        agency.rentCar("Cs001", "Cr001", 3); // Rent for 3 days
        agency.rentCar("Cs002", "Cr001", 2); // Should fail because the car is already rented
        agency.returnCar("Cr001");          // Return the car that was rented out into the agency and thesystem 
        agency.rentCar("Cs002", "Cr001", 5); // Should now be successful since the car is returned into the system.
        agency.rentCar("Cs005", "Cr003", 1); // Rent for 1 days
        agency.rentCar("Cs004", "Cr002", 7); // Rent for 7 days
        agency.returnCar("Cr003");           // Return the car that was rented out into the agency and thesystem
        agency.returnCar("Cr002");           // Return the car that was rented out into the agency and thesystem
        
        // Display agency status and transactions
        System.out.println(agency);
        agency.displayTransactions();
    }
}
