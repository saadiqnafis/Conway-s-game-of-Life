import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;


public class Landscape {

    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;
    private ArrayList<Cell> list;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        
        landscape = new Cell[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                landscape[r][c] = new Cell();
                
            }
        }
        reset();
        
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        Random ran = new Random();
        initialChance = chance;
        landscape = new Cell[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                landscape[r][c] = new Cell(ran.nextDouble(1) <= initialChance);

            }

        }
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        //Landscape(int rows, int columns, double chance);
        Random ran = new Random();
        //initialChance = chance;
        landscape = new Cell[getRows()][getCols()];
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                landscape[r][c] = new Cell(ran.nextDouble(1) <= initialChance);

            }

        }
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        String result = "";

		for (int r = 0; r < landscape.length; r++) {

			for (int c = 0; c < landscape[r].length; c++) {

				result += "" + landscape[r][c] + " ";
			}
			result += "\n";
		}
		
		return result;
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        list = new ArrayList<Cell>();
        for (int r = row - 1; r < row + 2; r++) {

			for (int c = col -1; c < col + 2; c++) {

				if (r > -1 && c > -1 && r < landscape.length && c < landscape[0].length && (r != row || c != col)) {
                    list.add(landscape[r][c]);
                }
                
			}
		}
        return list;
    }

    /**
     * Advances the current Landscape by one step. 
     */
    public void advance() {
        Cell[][] grid = new Cell[getRows()][getCols()];
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                grid[r][c] = new Cell(this.getCell(r, c).getAlive());
            }
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c].updateState(this.getNeighbors(r, c));
            }
        }
        landscape = grid;

    }
    /**
     * It also advances the current Landscape by one step. It's a part of our extension. It calls the modifiedUpdateState from the Cell method.
     */

    public void modifiedAdvance() {
        Cell[][] grid = new Cell[getRows()][getCols()];
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                grid[r][c] = new Cell(this.getCell(r, c).getAlive());
            }
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c].modifiedUpdateState(this.getNeighbors(r, c));
            }
        }
        landscape = grid;

    }

    public Cell[][] returnCopy() {
        Cell[][] grid = new Cell[getRows()][getCols()];
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                grid[r][c] = new Cell(this.getCell(r, c).getAlive());
            }
        }
        return grid;

    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public static void main(String[] args) {
        Landscape landscape = new Landscape(6, 7, 0.25);
        System.out.println(landscape.toString());
        landscape.advance();
        System.out.println(landscape.toString());
    }

}