
package maze;

public class Cell {
    int row, col;// cell's posotion
    char value; // character in the cell
    boolean blocked = false; // whether this cell is in the wall
    boolean visited = false;// a cell is visited only one time
    Cell previous = null;// for getting the path
    
    //Initiate a cell
    public Cell (int row, int col, char value){
        this.row = row;
        this.col = col;
        this.value = value;
    }
    
    // Blocking the cell - this cell is in the wall
    public void setBlock(){
        this.blocked = true;
    }
    
    // testing whther the cell can be visited
    public boolean canBeVistited(){
        return !blocked && !visited;
    }

    @Override
    public String toString() {
        return "{" + row + ", " + col + ", " + value + ")";
    }
    
    
   
}
