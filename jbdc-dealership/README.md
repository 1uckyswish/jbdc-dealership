# Advanced Java Car Dealership with MySQL Integration

## Project Overview

Welcome to the Advanced Java Car Dealership project! This project is aimed at streamlining the management of a car dealership through a Java-based application. With the recent integration of MySQL, the application now offers enhanced data management capabilities and scalability.

## Project Setup

1. **Maven Project Initialization**:
   - Created a new Maven project in IntelliJ IDEA.
   - Added dependencies including MySQL Driver and `BasicDataSource` in the `pom.xml` file.

2. **Database Configuration**:
   - Installed and configured MySQL on my system.
   - Created a MySQL database named `CarDealership`.
   - Executed the provided database script to set up required tables (`vehicles`, `sales_contracts`, `lease_contracts`).

3. **Model Modifications**:
   - Modified existing models (Dealership, Vehicle, SalesContract, LeaseContract) to include an `id` field for database compatibility.

## Persistence Logic

- Replaced FileManager class with DataManager classes for CRUD operations interacting with MySQL.
- Organized DataManager or DAO classes for each database table (vehicles, sales_contracts, lease_contracts) for better modularity.

## Application Flow

- Ensured continuity in application flow from Workshop 5, now interacting with MySQL instead of CSV files.
- All functionalities on the dealership home screen fetch or update data from MySQL.

## Sale vs Lease

- Implemented logic to store sales contract data in `sales_contracts` table and lease contract data in `lease_contracts` table.

## Phases of Development

### Phase 1: Vehicle Search Functionality

- Created VehicleDao and implemented methods to search the database for vehicles based on various criteria.

### Phase 2: Add/Remove Vehicles

- Successfully implemented functionality to add and remove vehicles from the database.

### Phase 3: Sales and Lease Management

- Developed SalesDao and LeaseDao classes.
- Updated dealership logic to save sales/lease information to the respective database tables.

## Cleanup

- Removed all .csv files from the project.
- Verified project functionality after transitioning to MySQL.

## Bonus Ideas

- Explored enhancing the AdminUser interface to retrieve sales and lease information from the database for comprehensive reporting and management capabilities.

## Conclusion

That's the current state of my project! Excited about the progress made and looking forward to further improvements and feature additions in the future!
