/**
 * Name - Darsh patel 
 *  Course - CSCI 1110 (Dalhousie University)
 * Date - April 6, 2023
 * Purpose - The purpose of this class is to set up an EarthGrid which represents earth and put oceans and land on
 * different indexes according to user inout. we also place bottles on the earthGrid which we will use in a later
 * problem. In this problem we print the grid with land and direcion signs and bottles and their starting points.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //inputs for number of rows and columns
        int noOfRows = in.nextInt();
        int noOfCols= in.nextInt();
        //making an earthgrid object which takes in noOfRows and noOfCols.
        EarthGrid earthGrid = new EarthGrid(noOfRows,noOfCols);
        //calling the setToOcean method to set every grid to Ocean
        earthGrid.setToOcean();

      /* We are getting the land coordinates as characters with a "," between them and we know that the coordinates are
        number character so the while loop will run and keep taking inputs until an alphabet from a to z is put in as
        input.
      */

        // reference for "[a-zA-Z]"-https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        while (in.hasNext() && !in.hasNext("[a-zA-Z]")) {
            String landCoordinates = in.next();
            // saving the index position of "," for our substrings.
            int indexOfComma = landCoordinates.indexOf(',');

            /*the row land coordinate will be the number before the comma and the column land coordinate will be the
              number after the comma. Using parseint to save the values as integers*/

            int landRow = Integer.parseInt(landCoordinates.substring(0, indexOfComma));
            int landCol = Integer.parseInt(landCoordinates.substring(indexOfComma + 1,landCoordinates.length()));

            //calling the setToLand method to save a "X" at the particular land coordinate
            earthGrid.setToLand(landRow, landCol);
        }

        // While loop will run until there is an input.
        while(in.hasNext()){
            //if the input is a number, we will break out of the loop as we know the direction coordinates are characters.
            if (in.hasNextInt()) {
                // input is a number, exit loop
                break;
            }
            String direction = in.next();
            //calling the addDirection method which checks if there is land or ocean and adds the direction to the
            // specific grid.
            earthGrid.addDirection(direction);
        }
        //no of bottles on the grid
        int noOfBottles = in.nextInt();
        //setting up a new ArrayList of the type Bottle which stores all the bottle objects
        ArrayList<Bottle> bottles = new ArrayList(noOfBottles);
        //loop will run noOfBottles amount of times
        for (int i = 0; i < noOfBottles; i++) {
            //cordinate inputs
            int bottleRow = in.nextInt();
            int bottleCol = in.nextInt();
            // Input for bottle name. Using .trim() to delete any whitespace.
            String bottleName = in.nextLine().trim();
            //message in the bottle
            String message = in.nextLine();
            //creating a bottle object which will take in all the above inputs
            Bottle bottle = new Bottle(bottleRow, bottleCol, bottleName, message);
            //adding the bottle to the ArrayList.
            bottles.add(bottle);
        }
        //printing out the full grid
        System.out.println(earthGrid.toString());

        // a bottle object which will loop through the bottle ArrayList and print the bottle information.
        for (Bottle bottle : bottles) {
            System.out.println("Bottle named \"" + bottle.getName() + "\" starting at (" +
                    bottle.getRow() + ", " + bottle.getCol() + ")");


        }


    }
}
