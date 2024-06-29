package sp_dijkstra_algorithm;

import java.io.PrintWriter;
import java.util.LinkedList;

public class DJ_Finder {

    public static final int INF = Integer.MAX_VALUE; //infinity
    Graph_Matrix g;
    int startV = -1; //start vertex of DJ algorithm
    boolean[] flags; //array of flags
    int[] costs; //array of costs from startV to each vertex
    int[] predecessors; //array of predecessors of each vertex
    int n; //number of vertex
    boolean finished = false; //whether DJ algorithm finished or not

    public DJ_Finder(Graph_Matrix g) {
        this.g = g;
        //create array of marks, costs and predecessors
        n = g.nVertices;
        flags = new boolean[n];
        costs = new int[n];
        predecessors = new int[n];
    }

    //Preparing before finding shortest path from a given vertex
    public void prepare(int startV) {
        for (int i = 0; i < n; i++) {
            flags[i] = false; // this vertex is not examined yet
            costs[i] = INF; //infinity
            predecessors[i] = -1; //predecessors = null
        }
        //Initiate data of the vertex startV
        flags[startV] = true;
        costs[startV] = 0;
        finished = false;
    }

    //Getting the current vertex having minimum cost
    private int getMinCostVertex() {
        int minVertex = -1;
        for (int i = 0; i < n; i++) {
            if (flags[i] == false) {
                if (minVertex == -1) {
                    minVertex = i;
                } else if (costs[i] < costs[minVertex]) {
                    minVertex = i;
                }
            }
        }
        return minVertex;
    }

    //Run the SP DJ algorithm from the start vertex
    public void DJ(int startV) {
        this.startV = startV;
        finished = false;
        prepare(startV); //prepartions
        int v = startV;
        int newCostToU, weightVU;
        while (v != -1) { //when not completed yet
            flags[v] = true;
            //examine non-marked adjacency of v
            for (int u = 0; u < n; u++) {
                weightVU = g.adjMatrix[v][u];
                if (weightVU < INF && flags[u] == false) {
                    newCostToU = costs[v] + weightVU;
                    if (newCostToU < costs[u]) {
                        costs[u] = newCostToU;
                        predecessors[u] = v;
                    }
                }
            }
            v = getMinCostVertex(); //get the next vertex
        }
        finished = true;
    }

    //Get the edge u --> v, using the format: "[u,v,8]"
    private String getEdgeStr(int v, int u) {
        return "[" + g.vSet[v] + "," + g.vSet[u] + "," + g.adjMatrix[v][u] + "]";
    }

    //get a shortest path from startV to the vertex u
    private String getShortestPath(int u) {
        LinkedList<String> path = new LinkedList<>();
        int dest = u;
        int src = predecessors[dest];
        while (src != -1) {
            path.addFirst(getEdgeStr(src, dest));
            dest = src;
            src = predecessors[dest];
        }
        String result = "** SP " + g.vSet[startV] + " -> "
                + g.vSet[u] + ", len =" + costs[u] + " : " + path;
        return result;
    }

    //Convert shortest paths to String
    public String spsToString() {
        String result = null;
        if (finished) {
            result = "";
            for (int i = 0; i < n; i++) {
                result += getShortestPath(i) + "\r\n";
            }
        }
        return result;
    }

    //Print all shortest paths to file
    public boolean printSPsToFile(String filename) throws Exception {
        if (!finished) {
            return false;
        }
        PrintWriter pw = new PrintWriter(filename);
        pw.print(this.spsToString());
        pw.close();
        return true;
    }
}
