package pkg;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    /* 
        Postcondition: The root will be null
    */
    public BinarySearchTree() {
        root = null;
    }

    /* 
        Create the getRecursive method that recursively traverses the tree finding the value. 
        Using curr as the current node that to look at.
    */ 
    public Node get(int value){
        return getRecursive(root,value);
    }
    public Node getRecursive(Node curr, int value){
        if (curr == null || curr.value == value) {
            return curr;
        }
        if (value < curr.value) {
            return getRecursive(curr.left, value);
        } else {
            return getRecursive(curr.right, value);
        }
    }

    /*
        Insert a new Node correctly into the tree ensuring that the left nodes are smaller 
        than the current node and right nodes are larger. Duplicates should always be on the right side of the tree. 
    */
    public void insert(int value){
        root = insertRecursive(root,value);
    }

    public Node insertRecursive(Node curr, int value){
        if(curr == null) {
            return new Node(value);
        }
        if(value < curr.value) {
            curr.left = insertRecursive(curr.left, value);
        } else if (value > curr.value) {
            curr.right = insertRecursive(curr.right, value);
        } else {
            curr.right = insertRecursive(curr.right, value); // duplicate values go right of existing node
        }
        return curr;
    }

    /*
        Print all data values of the tree in ascending order
    */
    public void printTree(){
        printTreeRecursive(root);
    }
    public void printTreeRecursive(Node curr){
        if (curr != null) {
            printTreeRecursive(curr.left);
            System.out.println(curr.value);
            printTreeRecursive(curr.right);
        }
    }
    
    /*
        Print all data values of the tree in Breadth First Search Order
    */
    public void BFSprintTree(Node root){
        if (root == null) return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.println(curr.value);
            
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    /*
        Print all data values of the tree in Depth First Search Order
    */
    public void DFSprintTree(){
        DFSprintTreeRecursive(root);
    }
    public void DFSprintTreeRecursive(Node curr){
        if (curr != null) {
            System.out.println(curr.value);
            DFSprintTreeRecursive(curr.left);
            DFSprintTreeRecursive(curr.right);
        }
    }

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
