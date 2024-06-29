/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {
    int size = 20;
    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) {  //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
//        System.out.println(v[k] + " ");
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void depth2(boolean[] visited, int k, ArrayList<Integer> list) throws Exception {
        list.add(k);
        visited[k] = true;
        
        for (int i = 0; i < 20; i++)
            if (!visited[i] && a[k][i] > 0)
                depth2(visited, i, list);
            
    }

    void depth2(int k, ArrayList<Integer> list) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < 20; i++)
            visited[i] = false;
        
        depth2(visited, k, list);
    }
    
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(0, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        ArrayList<Integer> list = new ArrayList<>();
        depth2(0, list);
        
        for (int i = 1; i < list.size(); ++i) {
            if (i > 4) 
                break;
            
            fvisit(list.get(i), f);
        }
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=================================================================
    final int INF = 99 * size + 1;
    private class Pair implements Comparable<Pair>{
        Integer pos;
        Integer weight;
        
        Pair(int x, int y) {
            pos = x;
            weight = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (weight.equals(o.weight))
                return pos.compareTo(o.pos);
            
            return weight.compareTo(o.weight);
        }  
    }
    
    ArrayList<Integer>[] dijkstra(int pos, int des) {
        int[] w = new int[size + 1];
        ArrayList<Integer>[] arr = new ArrayList[2];
        
        for (int i = 0; i < 2; ++i)
            arr[i] = new ArrayList<>();
        
        for (int i = 0; i < size; ++i) w[i] = INF;
        
        TreeSet<Pair> set = new TreeSet<>();
        set.add(new Pair(pos, 0));
        w[pos] = 0;
        
        while (!set.isEmpty()) {
            int x = set.first().pos;
            int d = set.first().weight;
            set.remove(new Pair(x, d));
            
            arr[0].add(x);
            if (arr[0].size() > 3)
                arr[0].remove(0);
                
            if (x == des)
                break;
            for (int i = 0; i < size; ++i)
                if (a[x][i] > 0) 
                    if (d + a[x][i] < w[i]) {
                        if (set.contains(new Pair(i, w[i])))
                            set.remove(new Pair(i, w[i]));
                        
                        set.add(new Pair(i, d + a[x][i]));
                        w[i] = d + a[x][i];
                    }
        }
        
        if (w[des] < INF) {
            int x = des;
            arr[1].add(x);
            while (x != pos)
                for (int i = 0; i < size; ++i)
                    if (w[i] + a[i][x] == w[x] && a[i][x] > 0) {
                        x = i;
                        arr[1].add(0, x);
                        break;
                    }
        }
        
        return arr;
    }
    
    void write(RandomAccessFile f, ArrayList<Integer> arr) throws Exception{
        for (int i = 0; i < arr.size(); ++i)
            fvisit(arr.get(i), f);
        f.writeBytes("\r\n");
        
    } 
    
    void f2() throws Exception {
        loadData(13);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f2.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
        ArrayList<Integer>[] arr;
        size = v.length;
        arr = dijkstra(0, 6);
        write(f, arr[1]);
        write(f, arr[0]);
        
        arr = dijkstra(2, 5);
        write(f, arr[1]);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

}
