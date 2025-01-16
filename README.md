# FlareGamesv2

## Overview
FlareGamesv2 is a Java-based GUI application designed for managing a video game store's inventory, orders, and customer interactions. The project features an intuitive graphical interface built using `javax.swing` with multiple `JFrame` windows for streamlined user interaction.

## Features
- `AddFrame`: Add new products to the store inventory.
- `OrderFrame`: Process customer orders dynamically.
- Dynamic updates to inventory and order details.
- Different product categories: Games, Consoles, and Accessories.
- Supports product rental and second-hand product tracking.

## Technologies Used
- **Programming Language**: Java
- **GUI Framework**: Swing
- **UML Design**: Comprehensive structure designed and implemented based on the provided UML diagram.


## Architecture
### Parent and Child Classes
The application follows an **object-oriented architecture** with clear separation of responsibilities:
- **Parent Class: `Product`**
  - Represents a generic product with common attributes like ID, name, price, and quantity.
- **Child Classes:**
  - `GameProduct`: Represents video games with additional attributes specific to games.
  - `ConsoleProduct`: Represents gaming consoles with relevant details.
  - `AccessoryProduct`: Represents gaming accessories with tailored attributes.

### System Class
- **`FlareSys`**: Acts as the central system for managing the store's operations.
  - Handles product inventory, customer orders, and system-wide operations.
  - Provides utility methods for finding, adding, and removing products, as well as managing orders.
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

### DisplayFrame
  - Used for displaying all products in stock or all orders made by customers.
  - Search field is used to search products according to their product id.

## How to Run
### Download the Application
  1. Ensure you have Java installed (JDK 8 or later).
  2. Run FlareMain.java

## License
  - This project is open source. 

