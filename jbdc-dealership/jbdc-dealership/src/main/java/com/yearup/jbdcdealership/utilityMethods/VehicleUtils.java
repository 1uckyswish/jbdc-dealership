package com.yearup.jbdcdealership.utilityMethods;

import com.yearup.jbdcdealership.models.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleUtils {
    public static Vehicle resultSetToVehicle(ResultSet resultSet) throws SQLException {
        String vin = resultSet.getString(1);
        int year = resultSet.getInt(2);
        String make = resultSet.getString(3);
        String model = resultSet.getString(4);
        String type = resultSet.getString(5);
        String color = resultSet.getString(6);
        int odometer = resultSet.getInt(7);
        double price = resultSet.getDouble(8);
        String sold = resultSet.getString(9);

        return new Vehicle(vin, year, make, model, type, color, odometer, price, sold);
    }
}
