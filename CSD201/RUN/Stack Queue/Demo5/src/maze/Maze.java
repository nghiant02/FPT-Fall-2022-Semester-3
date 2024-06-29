
package maze;
import java.io.File;
import java.io.FileReader; // for reading characters
import java.io.BufferedReader; // for reading lines
import java.util.LinkedList;// for a stack
import java.util.ArrayList;// for storing adjacent cells

public class Maze {
    char entryChar = 'E', destChar = 'M';
    char emptyChar = '0', blockedChar = '1';
    int rows = 0, cols=0; //size of the maze
    Cell[][] cells = null; // map of the maze
    Cell entryCell = null; // entry position of the maze
    Cell destCell = null;// exit cell or destination cell
    boolean completed = false;// solving completed or not
    boolean succeeded = false; //colving succeeded or not
    
    //Constructor using default characters
    public Maze(){
    }
    
    //Constructor using specified characters
    public Maze(char entryChar, char destChar, 
            char emptyChar, char blockedChar){
        this.entryCell = entryCell;
        this.destChar = destChar;
        this.emptyChar = emptyChar;
        this.blockedChar = blockedChar;
    }
    
    //print the maze
    public void print(){
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                System.out.println(cells[i][j].value);
            }
            System.out.println();
        }
    }
    
    //testing whether a position is valid or not
    private boolean isValid (int row, int col){
        return row >= 0 && row < rows && // it is in the board
               col >= 0 && col < cols && // and the cell at this position
               cells[row][col].canBeVistited(); // can be moved to
    }
    
    // getting 4 adjacency cells of the current cell
    private ArrayList<Cell> getAdjs(Cell curCell){
        ArrayList<Cell> adjs = new ArrayList();
        int row = curCell.row, col = curCell.col;
        
        // testing 4 adjacency cells of the current cell
        if (isValid(row-1, col)) { //upper adjacency cell
            cells[row-1][col].previous = curCell;
            adjs.add(cells[row-1][col]);
        }
        if (isValid(row+1, col)) { //lower adjacency cell
            cells[row+1][col].previous = curCell;
            adjs.add(cells[row+1][col]);
        }
        if (isValid(row, col-1)) { //left adjacency cell
            cells[row][col-1].previous = curCell;
            adjs.add(cells[row][col-1]);
        }
         if (isValid(row, col+1)) { //right adjacency cell
            cells[row][col+1].previous = curCell;
            adjs.add(cells[row][col+1]);
        }
        return adjs;
    }
    
    // load a maze from a text file
    public boolean loadFromFile (String filename){
        File f = new File(filename);
        if (!f.exists()){
            System.out.println("The file " + filename + "doesn't existed!");
            System.out.println(0);
        }
        try {
            FileReader fr = new FileReader(f);// reading characters
            BufferedReader bf = new BufferedReader(fr);// reading lines
            ArrayList<String> list = new ArrayList();// file --> String list
            String line;
            // loading all lines in the file to list
            while ((line = bf.readLine())!=null){
                line = line.trim();// normalizing each line
                if (line.length()>0){
                    list.add(line.toUpperCase());
                }
            }
            bf.close();
            fr.close();
            
            // creating the matrix from the list
            this.rows = list.size();// determine number of rows
            this.cols = list.get(0).length(); // determine number of columns
            this.cells = new Cell[rows][cols];// allocating memory of matrix
            for (int i=0; i< list.size(); i++){ //creating cells
                line = list.get(i); // getting a line: 101M1010101
                for (int j=0; j<cols; j++){ // creating cell in the row i 
                    char ch = line.charAt(j); // 101M1010101
                    cells[i][j] = new Cell(i,j,ch);
                    if (ch == blockedChar)cells[i][j].setBlock();
                    // determining the entry and destination of the maze
                    else if (ch==entryChar) this.entryCell = cells[i][j];
                    else if (ch== destChar) this.destCell = cells[i][j];
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
        return true;
    }
    
    //Solving the maze
    public boolean solve(){
        LinkedList<Cell> stack = new LinkedList(); // initating a stack
        Cell curCell = this.entryCell; // strating at the entry of the maze
        while (!completed){ // finding a solution
            curCell.visited = true; // making curCell as visited
            if(curCell == this.destCell)// succeeded
                completed = succeeded = true;
            else {
                ArrayList<Cell> adjs = getAdjs(curCell);// adjacency cells
                // if there are adjacency cells to move to
                if (adjs.size()>0){
                    curCell = adjs.get(0);
                    for (int i=1; i<adjs.size(); i++)//save others to stack
                        stack.addFirst(adjs.get(i));
                }
                //else if stack contains a cell which can try
                else if (!stack.isEmpty())//if having a cell can be examined
                    curCell = stack.removeFirst(); // popping a cell from stack
                
                else {// stack is empty --> NO solutions
                    completed = true;
                    succeeded = false;
                }
            }
        }
        return completed;
    }
    // get the path of solution
    public LinkedList<Cell> getPath(){
        if (!succeeded) return null;
        LinkedList<Cell> path = new LinkedList();
        // reverse traversing to get the result path
        Cell cell = this.destCell;
        while (cell!=null){
            path.addFirst(cell);
            cell = cell.previous;
        }
        return path;
    }
}
