import pkg.*;

public class main {
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert 20 random elements into the tree
        for (int i = 0; i < 20; i++) {
            int value = (int) (Math.random() * 100) + 1; // Generates random value between 1 and 100
            bst.insert(value);
        }

        // Print the tree in ascending order
        System.out.println("Tree in ascending order:");
        bst.printTree();
    }
}

