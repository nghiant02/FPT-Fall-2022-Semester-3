/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    Node insert(Boo x, Node node) {
        if (node == null)
            return new Node(x);
        
        if (x.sound < node.info.sound)
            node.left = insert(x, node.left);
        else if (x.sound > node.info.sound)
            node.right = insert(x, node.right);
        
        return node;
    }
    
    void insert(String xForest, int xRate, int xSound) {
        if (xForest.charAt(0) == 'A') {
            return;
        }
        
        root = insert(new Boo(xForest, xRate, xSound), root);
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void preOrder2(Node p, RandomAccessFile f, int pattern) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.rate < pattern)
            fvisit(p, f);
        preOrder2(p.left, f, pattern);
        preOrder2(p.right, f, pattern);
    }
    
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        try {
            preOrder2(root, f, 6);
        } catch (Exception e) {
        }
 
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void preOrder(Node p, ArrayList<Node> list) {
        if (p == null) {
            return;
        }
        
        list.add(p);
        preOrder(p.left, list);
        preOrder(p.right, list);
    }
    
    Boo getMaxValue(Node node) {
        if (node == null)
            return null;
        
        while (node.right != null)
            node = node.right;
        
        return node.info;
    }
    
    Node delete(Boo x, Node node) {
        if (node == null)
            return null;
        if (x.sound < node.info.sound)
            node.left = delete(x, node.left);
        else if (x.sound > node.info.sound)
            node.right = delete(x, node.right);
        else {
            if (node.left == null) {
                if (node.right == null)
                    return node = null;
                
                return node = node.right;
            }
            
            else if (node.right == null)
                return node = node.left;
            else {
                Boo max = getMaxValue(node.left);
                delete(max, node.left);
                node.info = max;
            }
        }
        
        return node;
    }
    
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        
        ArrayList<Node> list = new ArrayList<>();
        preOrder(root, list);
        
        Boo x = null;
        if (list.size() >= 4)
            x = list.get(3).info;
        
        if (x != null)
            root = delete(x, root);
        
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    Node rotateLeft(Node x) {
        if (x.right == null)
            return x;
        Node ans = x.right;
        x.right = ans.left;
        ans.left = x;
        
        return ans;
    }
    
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        ArrayList<Node> list = new ArrayList<>();
        preOrder(root, list);
        Node x = list.get(3);
        
        if (x.right != null) {
            Node ans = rotateLeft(x);

            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i).left != null && list.get(i).left.info.sound == x.info.sound) {
                    list.get(i).left = ans;
                    break;
                }
                else if (list.get(i).right != null && list.get(i).right.info.sound == x.info.sound) {
                    list.get(i).right = ans;
                    break;
                }
            }
        }
        
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
