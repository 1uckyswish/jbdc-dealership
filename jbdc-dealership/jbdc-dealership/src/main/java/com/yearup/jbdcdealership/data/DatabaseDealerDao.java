package com.yearup.jbdcdealership.data;


import com.yearup.jbdcdealership.models.Vehicle;
import com.yearup.jbdcdealership.utilityMethods.VehicleUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDealerDao implements DealerDao {
    private DataSource dataSource;

    public DatabaseDealerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Vehicle> getByPrice(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE price BETWEEN ? AND ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicles found between the price of " + minPrice + " and " + maxPrice);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE make = ? AND model = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the make of " + make + " and model of " + model);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByYear(int year) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE year = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, year);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the year of " + year);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByColor(String carColor) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE color = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, carColor);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the color of " + carColor);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByMileage(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE odometer BETWEEN ? AND ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicles found with the odometer reading between " + min + " and " + max);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByType(String carType) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE type = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, carType);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);

                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the type of " + carType);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }


        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);

                // Add the Vehicle object to the list
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public Vehicle getByVin(String vin) {
        Vehicle vehicle = null;
        String sqlQuery = "SELECT * FROM vehicle WHERE vin = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, Integer.parseInt(vin));
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the VIN of " + vin);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }


        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicle;
    }

    @Override
    public void create(Vehicle vehicle) {
        String sqlQuery = "INSERT INTO vehicle (vin, year, make, model, type, color, odometer, price, sold) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, vehicle.getVin());
            preparedStatement.setInt(2, vehicle.getYear());
            preparedStatement.setString(3, vehicle.getMake());
            preparedStatement.setString(4, vehicle.getModel());
            preparedStatement.setString(5, vehicle.getType());
            preparedStatement.setString(6, vehicle.getColor());
            preparedStatement.setInt(7, vehicle.getOdometer());
            preparedStatement.setDouble(8, vehicle.getPrice());
            preparedStatement.setString(9, vehicle.getSold());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Vehicle inserted successfully.");
            } else {
                System.err.println("Error: Failed to insert vehicle.");
            }

        } catch (Exception e) {
            System.err.println("Error inserting vehicle: " + e.getMessage());
        }
    }

    @Override
    public void update(String vin, Vehicle vehicle) {
        String sqlQuery = "UPDATE vehicle SET year = ?, make = ?, model = ?, type = ?, color = ?, odometer = ?, price = ?, sold = ? " +
                "WHERE vin = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, vehicle.getYear());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setString(4, vehicle.getType());
            preparedStatement.setString(5, vehicle.getColor());
            preparedStatement.setInt(6, vehicle.getOdometer());
            preparedStatement.setDouble(7, vehicle.getPrice());
            preparedStatement.setString(8, vehicle.getSold());
            preparedStatement.setString(9, vin);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Vehicle updated successfully.");
            } else {
                System.err.println("Error: Failed to update vehicle. Vehicle with VIN " + vin + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error updating vehicle: " + e.getMessage());
        }
    }


    @Override
    public boolean delete(String vin) {
        try (Connection connection = dataSource.getConnection()) {
            // Check if there are associated records in the inventory table
            String checkInventoryQuery = "SELECT COUNT(*) FROM inventory WHERE vin = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkInventoryQuery)) {
                checkStatement.setString(1, vin);
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        // There are associated records in the inventory table, delete them first
                        String deleteInventoryQuery = "DELETE FROM inventory WHERE vin = ?";
                        try (PreparedStatement deleteInventoryStatement = connection.prepareStatement(deleteInventoryQuery)) {
                            deleteInventoryStatement.setString(1, vin);
                            deleteInventoryStatement.executeUpdate();
                        }
                    }
                }
            }

            // Delete the vehicle from the vehicle table
            String deleteVehicleQuery = "DELETE FROM vehicle WHERE vin = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteVehicleQuery)) {
                preparedStatement.setString(1, vin);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("Vehicle with VIN " + vin + " deleted successfully.");
                    return true; // Return true indicating successful deletion
                } else {
                    System.err.println("Error: Failed to delete vehicle. Vehicle with VIN " + vin + " not found.");
                    return false; // Return false indicating failure to delete (vehicle not found)
                }
            }
        } catch (Exception e) {
            System.err.println("Error deleting vehicle: " + e.getMessage());
            return false; // Return false indicating failure to delete (due to exception)
        }
    }

}

