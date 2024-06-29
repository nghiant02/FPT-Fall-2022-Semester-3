
package maze;


public class MyMaze {
    public static void main(String[] args) {
        String filename = "maze.txt";
        Maze maze = new Maze ('E', 'M', '0', '1');
        maze.loadFromFile(filename);
        maze.print();
        maze.solve();
        if (maze.succeeded){
            System.out.println("Result path: ");
            System.out.println(maze.getPath());
        }
        else System.out.println("Failed!");
    }
    
}
