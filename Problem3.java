/**
 * Name - Darsh patel (B00940382)
 *  Course - CSCI 1110 Assignment 5
 * Date - April 6, 2023
 * Purpose - The purpose of this problem is to take in inputs to set up the grid and the bottle information and track
 *   the bottle movement throughout the ocean until it reaches land. This problem builds on problem2 and prints out the
 *   starting location of the bottles as well as their each move through the grid as well as tracks if the bottle is
 *   moving in a loop and is stuck in the Ocean.
 */

import java.util.ArrayList;
import java.util.Scanner;


public class Problem3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //inputs for number of rows and columns
        int noOfRows = in.nextInt();
        int noOfCols = in.nextInt();
        //making an earthgrid object which takes in noOfRows and noOfCols.
        EarthGrid earthGrid = new EarthGrid(noOfRows, noOfCols);
        //calling the setToOcean method to set every grid to Ocean
        earthGrid.setToOcean();

        /* We are getting the land coordinates as characters with a "," between them and we know that the coordinates
         are number character so the while loop will run and keep taking inputs until an alphabet from a to z is put in
          as input.
        */

        // reference for "[a-zA-Z]"-https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

        while (in.hasNext() && !in.hasNext("[a-zA-Z]")) {

            String input = in.next();
            // saving the index position of "," for our substrings.
            int commaIndex = input.indexOf(',');
            /*the row land coordinate will be the number before the comma and the column land coordinate will be the
              number after the comma. Using parseint to save the values as integers*/

            int landRow = Integer.parseInt(input.substring(0, commaIndex));
            int landCol = Integer.parseInt(input.substring(commaIndex + 1));
            //calling the setToLand method to save a "X" at the particular land coordinate
            earthGrid.setToLand(landRow, landCol);
        }
        // While loop will run until there is an input.
        while (in.hasNext()) {
            //if the input is a number, we will break out of the loop as we know the direction coordinates are
            // characters.
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
            //coordinate inputs
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
          /* A bottle object will loop through the bottle ArrayList and Prints out the counter,the
            name of the bottle and the starting coordinates.
          */

        for (Bottle bottle : bottles) {
            System.out.println( bottle.getName() +": "+ "Starting at (" +
                    bottle.getRow() + ", " + bottle.getCol() + ")");
        }
        /*we will run the while loop until the ArrayList is not empty*/
        while (!bottles.isEmpty()) {
            //looping through the ArrayList and assigning the object to bottle for  futhur condition review
            for (int i = 0; i < bottles.size(); i++) {
                //assigning the bottle object
                Bottle bottle = bottles.get(i);

                /*we will check if the bottle can do a valid move using the isValidMove method and passing in
                the earthgrid */

                if (bottle.isValidMove(earthGrid)) {
                    //if the move is valid, we will call the moveBottle method to move the bottle and pass the earthgrid

                    bottle.moveBottle(earthGrid);

                  /*calling the getIsOnLoop method to check if the bottle is in a loop meaing it has moved
                     to a location where it has already  been before*/

                    if(bottle.getIsOnLoop()){
                      /*If the bottle is in a loop we print out a message with the conyer, bottle name and the
                       bottle coordinates with the message STUCK!*/

                        System.out.println(bottle.getNumMoves()+": "+bottle.getName()+" "+"at "+ "(" +
                                bottle.getOldRow() + ", " + bottle.getOldCol() + ")" +":"
                                +" "+"<<NOW STUCK IN MID-OCEAN GYRE!>>");
                        //if the bottle is stuck we remove that bottle from the ArrayList and decrement the counter.
                        bottles.remove(i);
                        i--;
                    }
                    // else we output the counter the bottle name and the directions of the movement  and the direction
                    else {


                        System.out.println(bottle.getNumMoves() + ": " + bottle.getName() + " " + "at " + " (" +
                                bottle.getOldRow() + ", " + bottle.getOldCol() + ")"  + ":" + " "
                                + "In Ocean, current taking it  "+ bottle.getBottleLocation() + ".");

                        //incrementing the counter for the output on each turn
                        bottle.incrementNumMoves();
                    }
                }

              /*if it is not a valid move, meaning the bottle is on land and not in the ocean we
                 print out a message with the counter, bottle name and the cordinates with the message LANDED!*/

                else if(!bottle.isValidMove(earthGrid)){

                    System.out.println(bottle.getNumMoves()+": "+bottle.getName()+" "+"at "+ "(" +
                            bottle.getEndRow() + ", " + bottle.getEndCol() + ")" + ":" +" "+"LANDED!");
                    System.out.println("<<MESSAGE RECEIVED: "+bottle.getMessage()+">>");

                    //if a bottle has landed, we remove that bottle from the ArrayList
                    bottles.remove(i);
                    //decrementing the loop counter if we remove a bottle.
                    i--;
                }

            }
        }

    }
}
