# FlareGamesv2

## Overview
FlareGamesv2 is a Java-based GUI application designed for managing a video game store's inventory, orders, and customer interactions. The project features an intuitive graphical interface built using `javax.swing` with multiple `JFrame` windows for streamlined user interaction.

## Features
- **AddFrame**: Add new products to the store inventory.
- **OrderFrame**: Process customer orders dynamically.
- Dynamic updates to inventory and order details.
- Different product categories: Games, Consoles, and Accessories.
- Supports product rental and second-hand product tracking.

## Technologies Used
- **Programming Language**: Java
- **GUI Framework**: Swing
- **UML Design**: Comprehensive structure designed and implemented based on the provided UML diagram.

## GUI Windows
### AddFrame
- Used for adding products to the inventory.
- Components:
  - Text fields for product name and price.
  - A spinner for quantity selection.
  - Radio buttons to select product type (Game, Console, Accessory).
  - Checkboxes for product conditions (Second-hand, Rentable).
  - Dynamic child frames to add details based on product type.

### OrderFrame
- Used for managing customer orders.
- Components:
  - Text fields for customer name and address.
  - Radio buttons for product type (Game, Console, Accessory).
  - A combo box for selecting products dynamically based on inventory.
  - A checkbox for rental preferences.
  - Dynamic inventory update after each order.

## How to Run
### Download the Application
1. Visit the [Releases](https://github.com/username/FlareGamesv2/releases) page.
2. Download the latest `.jar` file.

### Run the Application
1. Ensure you have Java installed (JDK 8 or later).
2. Open a terminal and navigate to the directory containing the `.jar` file.
3. Run the application using:
   ```bash
   java -jar FlareGamesv2.jar
