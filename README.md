# EMobility Rental Simulation

## Overview

EMobility is an e-mobility company specializing in renting electric cars, bicycles, and scooters within and around the city of Java. The primary goal of this project is to develop a program that simulates the usage of these vehicles based on predefined data, generates detailed financial calculations, statistics, and monitors the status of all vehicles in operation.

## Features

### Vehicle Data Management
- **Electric Cars**: Stores data such as ID, purchase date, purchase price, manufacturer, model, description, and current battery level.
- **Electric Bicycles**: Stores data including ID, manufacturer, model, purchase price, current battery level, and range per charge.
- **Electric Scooters**: Stores data including ID, manufacturer, model, current battery level, purchase price, and maximum speed.

### Vehicle Operations
- All vehicles can:
  - Experience breakdowns, which are recorded with a reason and timestamp.
  - Be recharged, increasing the current battery level.
  - Deplete battery during movement.
- Cars have additional functionality to transport multiple passengers.

### Rental Process
- During rentals, the following information is recorded:
  - Date and time of rental.
  - User's name.
  - Pickup and drop-off locations.
  - Duration of use (in seconds).
- Additional requirements for car rentals:
  - Identification document (passport for foreign nationals, ID for locals).
  - Driver's license (number).
- Rental pricing is based on:
  - Duration of usage.
  - Additional factors such as location (narrow or wide city areas), breakdowns, discounts, and promotions.

### Billing
- Generates detailed invoices as `.txt` files, including:
  - Base price calculation.
  - Adjustments for distance, breakdowns, discounts, and promotions.
  - Total amount payable.
  - If a breakdown occurs, the total cost is set to 0.

### Simulation
- Reads rental data sorted by time from files.
- Each rental is simulated on a 20x20 grid map in real-time, with:
  - Yellow cells representing the wider city area.
  - Green cells representing the narrow city area.
- Vehicles move along straight paths between defined start and end points.
- Displays the vehicle's identifier and battery level on the map during simulation.
- Simulations are executed in separate threads, each representing a single rental.
- Includes a 5-second pause between rental simulations for different timestamps.

### Reports
- **Summary Report**:
  1. Total revenue.
  2. Total discounts.
  3. Total promotions.
  4. Total earnings from narrow and wide city areas.
  5. Total maintenance costs (20% of revenue).
  6. Total repair costs (based on predefined coefficients per vehicle type).
  7. Total company expenses (20% of revenue).
  8. Total tax (calculated as 10% of net revenue after deducting expenses and maintenance).
- **Daily Report**:
  - Displays grouped data by date for items 1-6.
  - Includes a tabular view of all available dates.

### Additional Functionality
Based on specific requirements (determined by index number modulo operation), implement one of the following:
1. Find vehicles generating the highest revenue for each type.
2. Find vehicles causing the highest losses for each type.
3. Identify vehicles with breakdowns and repair costs.

These results are serialized into binary files, saving objects with all relevant fields and costs in a designated folder. The program also includes a GUI for deserializing and displaying these records.

## Graphical User Interfaces (GUI)
1. **Main Screen**: Displays the map.
2. **Vehicle Overview**: Tables displaying all vehicle information (three separate tables for cars, bicycles, and scooters).
3. **Breakdown Overview**: A table showing the type of vehicle, ID, timestamp, and breakdown description.
4. **Business Results**: Displays financial results and statistics.

## Technical Details
- Vehicle and rental data are stored in external properties files.
- Supports JavaFX or Swing for GUI implementation.
- Uses a shared map for multi-threaded simulations, with synchronized updates.
- Invoices and reports are stored in directories specified in properties files.

## Installation and Setup
1. Clone the repository.
2. Ensure Java 11 or higher is installed.
3. Set up properties files with vehicle and rental data.
4. Run the program using the provided build script or IDE.
