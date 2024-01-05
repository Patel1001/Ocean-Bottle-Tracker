# Ocean-Bottle-Tracker

This Java project simulates the movement of bottles across an ocean grid until they reach land. It employs a custom-designed algorithm to navigate bottles through the ocean, detecting looping conditions and bottlenecks.

## Concepts Utilized


Object-Oriented Programming (OOP): The project leverages OOP principles extensively, employing classes such as EarthGrid and Bottle to encapsulate behavior and data related to grid management and bottle movement.

Input/Output Handling: Utilizes Java's Scanner class for efficient input acquisition from users, processing grid setup, bottle placements, and movement directions.
Conditional Statements and Loops: Uses if-else conditions and iterative loops to control the bottle movement, check conditions for bottlenecks or looping in the ocean, and manage simulation progression.

Array and ArrayList Usage: Implements Java arrays for managing the EarthGrid layout and uses ArrayLists to store and manage bottle movements, efficiently recording paths and detecting looping conditions.

## Data Structures

2D Array (String[][]): Represents the EarthGrid, storing ocean and land coordinates as strings ("O" for ocean and "X" for land).

ArrayList<String>: Tracks bottle movements, storing the history of coordinates to detect looping conditions during simulation.

Scanner: Handles user input for defining grid dimensions, setting land coordinates, assigning directions, placing bottles, and providing messages for each bottle.

## Running the Program

Compile the Problem3.java file.

Execute the compiled file to start the bottle tracking simulation.

Provide inputs for grid setup, bottle placements, and directions for movement.

## Key Classes
Problem3: Orchestrates the simulation, managing input, bottle movements, and output display.

EarthGrid: Represents the grid layout, setting up ocean and land coordinates, and storing direction inputs.

Bottle: Represents individual bottles, tracks their movements, and detects looping conditions.

## How to Use
Enter the number of rows and columns for the ocean grid.

Define land coordinates and direction assignments.

Input the number of bottles and their initial positions, along with messages.

Run the simulation to observe bottle movements and track their progress until they reach land or enter looping conditions.
## Notes
Ensure inputs adhere to the specified format to facilitate accurate simulation.
