/**
 * Name - Darsh patel 
 *  Course - CSCI 1110 (Dalhousie University)
 * Date - April 6, 2023
 * Purpose - The purspose of this class is to be a blueprint for the earthgrid. We create a earthGrid object here with
 * instance variables like rows, columns and an array and store the ocean and land coordinates as well as diretion
 * coordinates. Also we have methods to access direction from the grid.
 */

public class EarthGrid {
    //variables for row and cols in the grid
    private int noOfRows;
    private int noOfCols;
    //array representing the earthgrid
    private String[][]earthGrid;

    /** Constructor for the EarthGrid class. Initializing all the variables taken in as arguments
     *
     * @param noOfRows - rows in the grid
     * @param noOfCols - columns in the grid
     */
    public EarthGrid(int noOfRows, int noOfCols){
        this.noOfRows=noOfRows;
        this.noOfCols=noOfCols;
        earthGrid= new String[noOfRows][noOfCols];

    }

    /** Setter for setting a particular index to "O" representing the ocean.
     * void method
     */
    public void setToOcean(){
     //looping through the array to set each index to O.
        for(int i=0;i<noOfRows;i++){
            for(int j=0;j<noOfCols;j++){
                earthGrid[i][j]= "O";
            }
        }
    }

    /** Setter for setting the given index to X representing land.
     *
     * @param row - the specific row index
     * @param col - the specific column index
     */
    public void setToLand( int row, int col) {

        //setting the specific index  to "X"
        earthGrid[row][col]= "X";

    }

    /** The purpose of this method is to add the direction we received as input on the grid we have created
     *
     * @param direction - the direction we received as input
     */
    public void addDirection(String direction) {
        /*setting a counter as we wnt to make sure that we add the direction to only one specific spot it is
         intended for */
        int count =0;

        /*we will loop through the array and if the index has ocean, we add the direction but once it is added,
        * we increment the counter to make sure the sem direction cannot be added to any other grid index */

        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                if (earthGrid[i][j].equals("O")) {
                    if (count == 0) {
                        earthGrid[i][j] = direction;
                        count++;
                    }
                    else{
                        count++;
                    }

                }
            }
        }
    }

    /**
     * Getter for the direction on a specific row and column co-ordinate.
     * @param row- row coordinate
     * @param col - column coordinate
     * @return 0 return the array index containing the direction.
     */
    public String getDirection(int row, int col){

        return earthGrid[row][col];

    }

    /**
     * The purpose of this methos is to return the full grid.
     * @return- String representing the grid.
     */
    public String toString() {
        String result = "";

        //looping through the array and adding each index to the String
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                result += earthGrid[i][j];
            }
            //to make sure one row has 3 columns only
            result += "\n";
        }
        //returning the final string.
        return result;
    }

}


