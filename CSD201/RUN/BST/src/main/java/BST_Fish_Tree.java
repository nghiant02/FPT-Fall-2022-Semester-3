
import java.io.PrintWriter;
import java.util.LinkedList;

public class BST_Fish_Tree {

    BST_Node root;

    // create an empty tree
    public BST_Fish_Tree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Add a fish methods - Recursive implementation
    public BST_Node add_recur(BST_Node curref, AquariumFish fish) {
        if (curref == null) {
            curref = new BST_Node(fish);
        } else if (fish.compareTo(curref.fish) < 0) {
            curref.left = add_recur(curref.left, fish);
        } else {
            curref.right = add_recur(curref.right, fish);
        }
        return curref;
    }

    public void add_recur(AquariumFish fish) {
        root = add_recur(root, fish);
    }

    // Add some fishes using their names only. For testing
    public void add_recur(String... names) {
        for (String name : names) {
            add_recur(new AquariumFish(name));
        }
    }

    // Add a fish medthods - Iterative implementtation
    // Dulications are permitted
    public void add(AquariumFish fish) {
        BST_Node newNode = new BST_Node(fish);
        if (root == null) {
            root = newNode;
        } else {
            BST_Node pFather = null;
            BST_Node pBefore = root;
            // Determining the father node
            while (pBefore != null) {
                pFather = pBefore;
                if (fish.compareTo(pBefore.fish) < 0) {
                    pBefore = pBefore.left;
                } else {
                    pBefore = pBefore.right;
                }
            }
            // Link pFather to the newNode
            if (fish.compareTo(pFather.fish) < 0) {
                pFather.left = newNode;
            } else {
                pFather.right = newNode;
            }
        }
    }

    //Add some fishes using their names only - For testing
    public void add(String... names) {
        for (String name : names) {
            add(new AquariumFish(name));
        }
    }

    // Search operation. Recusive implemantation
    private BST_Node search_Recur(BST_Node curref, AquariumFish fish) {
        if (curref == null) {
            return null;
        } else {
            AquariumFish curFish = curref.fish;
            int d = fish.compareTo(curFish);
            if (d == 0) {
                return curref;
            } else if (d < 0) {
                return search_Recur(curref.left, fish);
            } else {
                return search_Recur(curref.right, fish);
            }
        }
    }

    // Search operation. Recursive implementation
    public BST_Node search_Recur(AquariumFish fish) {
        return search_Recur(root, fish);
    }

    // Search operation. Iterative implementation
    public BST_Node search(AquariumFish fish) {
        if (this.isEmpty()) {
            return null;
        }
        BST_Node t = root;
        AquariumFish curFish;
        while (t != null) {
            curFish = t.fish;
            int d = fish.compareTo(curFish);
            if (d == 0) {
                return t;
            } else if (d < 0) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        return null;
    }

    // Getting the leftmost node of a tree
    public BST_Node leftMost(BST_Node treeRoot) {
        BST_Node result = treeRoot;
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }

    // Getting the leftmost node of the a tree
    public BST_Node leftMost() {
        return leftMost(root);
    }

    //Getting the rightmost node of a tree
    public BST_Node rightMost(BST_Node treeRoot) {
        BST_Node result = treeRoot;
        while (result.right != null) {
            result = result.right;
        }
        return result;
    }

    //Getting the rightmost node of this tree
    public BST_Node rightMost() {
        return rightMost(root);
    }

    // visit: Print the fish to monitor
    public void visit(BST_Node node) {
        System.out.println(node.fish);
    }

    // visit: Print the fish to the opening file
    public void visitF(PrintWriter pw, BST_Node node) {
        try {
            pw.println(node.fish); // write a fish to file in a line  
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Breadth First Traversal: Print data to monitor
    public void BF_Traverse() {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
            return;
        }
        MyQueue queue = new MyQueue();
        queue.enqueue(root);// put the root to the queue
        BST_Node node;
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            visit(node);
            // put it's left and right child nodes to the queue
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    // Breadth First Traversal: Print data to file
    public void BF_Traverse_F(String filename) throws Exception {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
            return;
        }
        // open the text file for writing
        PrintWriter pw = new PrintWriter(filename);
        MyQueue queue = new MyQueue();
        queue.enqueue(root);
        BST_Node node;
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            visitF(pw, node);// write a data line to file
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }

        }
        pw.close();
    }

    private void NLR(BST_Node p) {
        if (p != null) {
            visit(p); // node
            NLR(p.left);
            NLR(p.right);
        }
    }

    public void NLR() {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            NLR(root);
        }
    }

    // NLR Traversal: print data to file
    private void NLR_F(PrintWriter pw, BST_Node p) {
        if (p != null) {
            try {
                visitF(pw, p); // write a fíh to file
                NLR_F(pw, p.left);
                NLR_F(pw, p.right);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void NLR_F(String filename) throws Exception {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            // Open the text file for writing
            PrintWriter pw = new PrintWriter(filename);
            NLR_F(pw, root);
            pw.close();
        }
    }

    //LNR traversal:Print data to file
    private void LNR(BST_Node p) {
        if (p != null) {
            LNR(p.left);
            visit(p);
            LNR(p.right);
        }
    }

    public void LNR() {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            LNR(root);
        }
    }

    //LNR Traversal: print data to file
    private void LLR_F(PrintWriter pw, BST_Node p) {
        if (p != null) {
            try {
                NLR_F(pw, p.left);
                visitF(pw, p); // write a fíh to file               
                NLR_F(pw, p.right);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void LLR_F(String filename) throws Exception {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            // Open the text file for writing
            PrintWriter pw = new PrintWriter(filename);
            NLR_F(pw, root);
            pw.close();
        }
    }

    //RNL traversal:Print data to file
    private void RNL(BST_Node p) {
        if (p != null) {
            LNR(p.right);
            visit(p);
            LNR(p.left);
        }
    }

    public void RNL() {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            LNR(root);
        }
    }

    //RNl Traversal: print data to file
    private void RNL_F(PrintWriter pw, BST_Node p) {
        if (p != null) {
            try {
                NLR_F(pw, p.left);
                visitF(pw, p); // write a fíh to file               
                NLR_F(pw, p.right);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void RNL_F(String filename) throws Exception {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            // Open the text file for writing
            PrintWriter pw = new PrintWriter(filename);
            NLR_F(pw, root);
            pw.close();
        }
    }

    // Methods are used in remove operations
    //counting children of a node
    private int countChild(BST_Node node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        if ((node.left != null && node.right == null)
                || (node.right != null && node.left == null)) {
            return 1;
        }
        return 2;
    }

    // Remove a leaf
    private BST_Node deleteLeaf(BST_Node father, BST_Node deletedChild) {
        if (deletedChild == root) {
            root = null; // or father == null, onr node tree
        } else {
            if (father.left == deletedChild) {
                father.left = null;
            } else {
                father.right = null;
            }

        }
        return deletedChild;
    }

    //Remove a node which hass ONE child
    private BST_Node deleteOneChildNode(BST_Node father, BST_Node deletedChild) {
        if (deletedChild == root) {
            root = root.left != null ? root.left : root.right;
        } else {
            BST_Node grandChild;
            if (deletedChild.left != null) {
                grandChild = deletedChild.left;
            } else {
                grandChild = deletedChild.right;
            }
            if (father.left == deletedChild) {
                father.left = grandChild;
            } else {
                father.right = grandChild;
            }
        }
        return deletedChild;
    }

    // Remove a node which has TWO children using Copy method
    private BST_Node deleteTwoChildrenNodeByCopy(BST_Node deleted) {
        // Find the rightmost node in the left subtree
        BST_Node father = deleted;
        BST_Node rightMost = deleted.left;
        while (rightMost.right != null) {
            father = rightMost;
            rightMost = rightMost.right;
        }
        // Copy data in the rightMOst to deleted
        deleted.fish = rightMost.fish;
        // remove the rightMost
        int count = countChild(rightMost);
        if (count == 0) {
            return deleteLeaf(father, rightMost); // leaf
        } else {
            return deleteOneChildNode(father, rightMost); // 1-child node
        }
    }

    //Delete a fish
    public BST_Node deleteFish(AquariumFish f) {
        if (this.isEmpty()) {
            return null;
        }
        BST_Node deleted = root, father = null;
        // Find the deleted node
        while (deleted != null) {
            int d = f.compareTo(deleted.fish);
            if (d == 0) {
                break;// deleted node is detected
            } else {
                father = deleted;
                if (d < 0) {
                    deleted = deleted.left;
                } else {
                    deleted = deleted.right;
                }
            }
        }
        //remove one node
        if (deleted == null) {
            return null;
        }
        int count = countChild(deleted); // number of it's children
        if (count == 0) {
            return deleteLeaf(father, deleted);
        }
        if (count == 1) {
            return deleteOneChildNode(father, deleted);
        }
        return deleteTwoChildrenNodeByCopy(deleted);
    }

    // Internal class for level based processing
    private class Node_Level {

        BST_Node node;
        int level;

        public Node_Level(BST_Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int height() {
        if (this.isEmpty()) {
            return 0;
        }
        int level = 1, maxLevel = 1;
        LinkedList<Node_Level> queue = new LinkedList();
        queue.addLast(new Node_Level(root, level));
        while (!queue.isEmpty()) {
            Node_Level nl = queue.removeFirst();
            level = nl.level;
            if (maxLevel < level) {
                maxLevel = level;
            }
            if (nl.node.left != null) {
                queue.addLast(new Node_Level(nl.node.left, level + 1));
            }
            if (nl.node.right != null) {
                queue.addLast(new Node_Level(nl.node.right, level + 1));
            }
        }
        return maxLevel;

    }
}
