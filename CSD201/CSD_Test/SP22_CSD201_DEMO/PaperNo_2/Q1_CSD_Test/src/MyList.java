/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(Boo x) {
        Node node = new Node(x);

        if (head == null) {
            head = node;
            tail = head;
            return;
        }

        tail.next = node;
        tail = node;
    }

    void addLast(String xForest, int xRate, int xSound) {
        if (xForest.charAt(0) == 'B') {
            return;
        }
        addLast(new Boo(xForest, xRate, xSound));
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    void insertAt(Boo x, int pos) {
        int index = 0;
        Node node = head;

        while (index + 1 < pos) {
            node = node.next;
            ++index;
        }

        node.next = new Node(x, node.next);
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Boo x, y;
        x = new Boo("X", 1, 2);
        y = new Boo("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        insertAt(x, 1);
        insertAt(y, 2);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void deleteAt(int pos) {
        if (pos == 0) {
            head = head.next;
            return;
        }
        Node node = head;
        int index = 0;
        while (index + 1 < pos) {
            node = node.next;
            ++index;
        }

        Node del = node.next;
        if (del == tail) {
            tail = node;
        }

        node.next = del.next;
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        deleteAt(0);
        deleteAt(1);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void sort(int n) {

        Node[] list = new Node[n];
        int index = 0;
        Node node = head;
        while (index < n) {
            list[index] = node;
            ++index;
            node = node.next;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (list[i].info.rate > list[j].info.rate) {
                    Boo x = list[i].info;
                    list[i].info = list[j].info;
                    list[j].info = x;
                }
            }
        }

    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//      sort(size());
        sort(4);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
//    int size() {
//        int i = 0;
//        Node p = head;
//        while (p != null) {
//            i++;
//            p = p.next;
//        }
//        return (i);
//    }

}
