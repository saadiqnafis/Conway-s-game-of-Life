import java.util.ArrayList;

public class Cell {

    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {

        alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        alive = status;

    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return alive;
    
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        alive = status;

    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        //boolean cellCondition = Cell.getAlive();
        int aliveNeighbors = 0;
        if (alive == false) {
            for (int i=0; i< neighbors.size(); i++) {
                if (neighbors.get(i).getAlive() == true) {
                    aliveNeighbors +=1;
                }
            }
            if (aliveNeighbors == 3) {

                alive = true;
            }

        }
        else if (alive == true) {
            for (int i=0; i< neighbors.size(); i++) {
                if (neighbors.get(i).getAlive() == true) {
                    aliveNeighbors +=1;
                }
            }
            if (aliveNeighbors == 3 || aliveNeighbors == 2) {

                alive = true;
            }  
            else {
                alive = false;
            }
        }     
    }

    /**
     * This method is a part of our extension. It also updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 3 or 4 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */

    public void modifiedUpdateState(ArrayList<Cell> neighbors) {
    
        
        int aliveNeighbors = 0;
        if (alive == false) {
            for (int i=0; i< neighbors.size(); i++) {
                if (neighbors.get(i).getAlive() == true) {
                    aliveNeighbors +=1;
                }
            }
            if (aliveNeighbors == 3) {

                alive = true;
            }

        }
        else if (alive == true) {
            for (int i=0; i< neighbors.size(); i++) {
                if (neighbors.get(i).getAlive() == true) {
                    aliveNeighbors +=1;
                }
            }
            if (aliveNeighbors == 3 || aliveNeighbors == 4) {

                alive = true;
            }  
            else {
                alive = false;
            }
        }     
    
    }


    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        if (alive == true) {
            return "" + 1;
        }
        else {
            return "" + 0;
        }
    }
}

