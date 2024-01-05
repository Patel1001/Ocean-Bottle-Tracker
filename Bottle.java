/**
 * Name - Darsh patel 
 *  Course - CSCI 1110 (Dalhousie University)
 * Date - April 6, 2023
 * Purpose - The purpose of this class is being a  blueprint for a bottle object. We have instance variables and methods
 * to track the movement of the bottle throughout the grid until it reached land and methods to access the bottle
 * information such as name, message and coordinates.
 */

import java.util.ArrayList;
import java.util.HashSet;
public class Bottle {
    //variables for coordinates
    private int row;
    private int col;
    //name variable
    private String name;
    //message in the bottle
    private String message;

    //keeping the counter of the number of moves for the output
    private int numMoves;
    //the location of the bottle at an instance
    private String bottleLocation;
    //the row  and col coordinates of the location the bottle ends up at, initialized to 0.
    private int endRow=0;
    private int endCol=0;
    //variables to keep track of the previous location of the bottle before a move initialized to 0.
    private int oldRow=0;
    private int oldCol=0;
    //ArrayList for the moveBottle method
    private ArrayList<String> movements;
    // to let us know if the bottle is stuck mid-ocean or not.
    private boolean isOnLoop;
    //location of the bottle in a string form
    private String locationString;


    /**
     * Constructor for the bottle class taking in arguments and initializing the variables.
     * @param row - row coordinate
     * @param col - col coordinate
     * @param name - bottle name
     * @param message - bottle message
     */
    public Bottle(int row, int col, String name, String message) {
        this.row = row;
        this.col = col;
        this.name = name;
        this.message = message;
        bottleLocation="";
        movements = new ArrayList<>();
        isOnLoop=false;
    }

    /** Getter for the row co-ordinate
     *
     * @return - row coordinate
     */
    public int getRow() {
        return row;
    }

    /** Getter for column coordinate
     *
     * @return - col coordinate
     */
    public int getCol() {
        return col;
    }

    /** getter for Bottle name
     *
     * @return - name
     */
    public String getName() {
        return name;
    }

    /** The purpose of this method is to increment the numMoves counter.
     *  void method.
     */
    public void incrementNumMoves(){
        numMoves++;
    }

    /** Getter for the numMoves
     *
     * @return - numMoves
     */

    public int getNumMoves(){
        return  numMoves;
    }

    /** getter for the location of the bottle
     *
     * @return - bottleLocation
     */
    public String getBottleLocation(){
        return bottleLocation;
    }

    /** getter for the row the bottle ends up at
     *
     * @return - endRow
     */
    public int getEndRow(){
        return endRow;
    }

    /** Getter for column the bottle ends up at
     *
     * @return - endCol
     */
    public int getEndCol(){
        return  endCol;
    }

    /** getter for the row coordinate before moving the bottle
     *
     * @return- oldRow
     */
    public int getOldRow(){
        return oldRow;
    }

    /** getter for the clumn coordinates before moving the bottle
     *
     * @return - oldCol
     */
    public int getOldCol(){
        return  oldCol;
    }

    /** getter for the message in the bottle
     *
     * @return - message
     */
    public String getMessage() {
        return message;
    }

    /** Getter for the boolean value of the bottle is on a loop or not
     *
     * @return - isOnLoop
     */
    public boolean getIsOnLoop(){
        return isOnLoop;
    }

    /** The purpose of this method is to check if the bottle is on a land grid or not.
     *
     * @param earthGrid - the grid containing the land and ocean coordinates
     * @return - boolean value of true or false according to the condition
     */
    public boolean bottleIsOnLand(EarthGrid earthGrid){

       //saviing the coordinates in the bottleLocation String.
        String bottleLocation=earthGrid.getDirection(row,col);

        //if the string contains an "X" means that the bottle is on land and we return true, else we return false.
        if(bottleLocation.equals("X")){
            return true;
        }

        return false;

    }

    /** The purpose of this method is to make sure the move the bottle is making is valid by checking if we are not
     * moving on land.
     * @param earthGrid - earthgrid containing all the row and col coordinates
     * @return- boolean value of true or false according to the condition
     */
    public boolean isValidMove(EarthGrid earthGrid){

        //saving the coordinates in bottleLocation string.
        bottleLocation = earthGrid.getDirection(row, col);

        // if the string contains "X " means we have reached land and we return false
        if(bottleLocation.equals("X")){
            //if we have reached land, storing the row and col coordinates in new variables
            endRow=row;
            endCol=col;
            return  false;
        }
        //otherwise we return true
        return true;
    }

    /** The purpose of this method is to move the bottle according to the the direction on the grid
     *
     * @param earthGrid - earthgrid containing the row and col direction coordinates
     */
    public void moveBottle(EarthGrid earthGrid){
        //before we move the bottle, saving the row and col coordinate in new variables
        oldRow = row;
        oldCol= col;

       // storing the index content in the string bottleLocation
        bottleLocation = earthGrid.getDirection(row, col);

        /* If the direction is north we will move up a spot, W meaning moving a spot left, S meaning a spot down and
        * E meaning a spot right*/
        if (bottleLocation.equals("N")) {
            // to move up we decrement the row and col remains unchanged
            row = oldRow - 1;
            col = oldCol;
        } else if (bottleLocation.equals("W")) {
            // to move left, row remains the same and ew decrement col by 1.
            row = oldRow;
            col = oldCol - 1;
        } else if (bottleLocation.equals("S")) {
            //for moving down, inceremting row by 1 and col remains the same.
            row = oldRow + 1;
            col = oldCol;
        } else if (bottleLocation.equals("E")) {
            //for moving right, row remains the same and we increment col by 1
            row = oldRow;
            col = oldCol + 1;
        }
       //saving the old row and old col coordinates in String locationString
        locationString = oldRow+","+oldCol;

       /* Arraylist movements contains all the movements made by the bottles. here we are checking if the bottle
       * is  making is a new move or somewhere it has been before*/

        if(movements.contains(locationString)){
            //if it is a repeated spot we turn the boolean value of isOnLoop to true
            isOnLoop = true;
        }
        //else we add the locationString to the ArrayList.
        else{
            movements.add(locationString);

        }
    }

}
