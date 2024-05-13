package com.yearup.jbdcdealership.application;

import com.yearup.jbdcdealership.data.DealerDao;
import com.yearup.jbdcdealership.models.Vehicle;
import com.yearup.jbdcdealership.utilityMethods.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.yearup.jbdcdealership.utilityMethods.UtilityMethods.*;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private DealerDao dealerDao;
    private List<Vehicle> vehicles;

    public UserInterface(DealerDao dealerDao) {
        this.dealerDao = dealerDao;
    }

    /**
     * Method hold the User Display screen for them to navigate the Dealership and
     * its inventory
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        // Create a boolean flag to check if user clicked the correct choice given
        boolean exit = false;
        // If not true, continue
        while (!exit) {
            // Display menu
            // Read user command
            String choice = displayHomeScreen();

            // Process user command
            // This will keep the program running unless the user types 0
            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    processUpdateVehicleRequest();
                    break;
                case "11":
                    processRecordOfSaleOrLease();
                    break;
                case "12":
                    adminDisplay();
                    break;
                case "0":
                    System.out.println("Thanks for Visiting...");
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.print("\nInvalid choice. Please try again.\n");
                    break;
            }
        }

        // Close the scanner properly
        scanner.close();
    }

    private void processUpdateVehicleRequest() {
    }

    private void processRemoveVehicleRequest() {
    }

    private void processAddVehicleRequest() {
    }

    private void processGetAllVehiclesRequest() {
        System.out.println("\n==== All Vehicle's In Inventory ====");
        vehicles = dealerDao.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
    }

    private void processGetByMileageRequest() {
    }

    private void processGetByColorRequest() {
    }

    private void processGetByYearRequest() {
    }

    private void processGetByMakeModelRequest() {
    }

    private void processGetByPriceRequest() {
        System.out.println("\nPlease enter the price range you're interested in");
        double minPrice = validateDoubleInput(scanner, "Please enter the minimum price: ");
        double maxPrice = validateDoubleInput(scanner, "Please enter the maximum price: ");
        scanner.nextLine();
        vehicles = dealerDao.getByPrice(minPrice, maxPrice);
        // If the Arraylist values returned are true within the range, display them all
        if (!vehicles.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Price ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(vehicles);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available within the specified price range ===\n");
        }
    }


    private void adminDisplay() {
    }

    private void processRecordOfSaleOrLease() {
    }

    public String displayHomeScreen(){
        System.out.println("==== Dealership Menu ====");
        System.out.println("1. Get vehicles by price");
        System.out.println("2. Get vehicles by make and model");
        System.out.println("3. Get vehicles by year");
        System.out.println("4. Get vehicles by color");
        System.out.println("5. Get vehicles by mileage");
        System.out.println("6. Get vehicles by vehicle type");
        System.out.println("7. Get all vehicles");
        System.out.println("8. Add vehicle");
        System.out.println("9. Remove vehicle");
        System.out.println("10. Update vehicle");
        System.out.println("11. Sell or Lease a vehicle");
        System.out.println("12. Admin Portal");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextLine().trim();
    }

    /**
     * Displays the details of all vehicles in the inventory.
     * Iterates through the list of vehicles passed as a parameter.
     * Print the details of each vehicle to the console.
     *
     * @param vehicles ArrayList of vehicles to be displayed
     */
    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
