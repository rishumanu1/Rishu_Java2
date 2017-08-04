package tree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tree {

    private class Node {

        String key;
        int[] value = new int[10];
        int index = 0;
        Node left;
        Node right;
    }
    private Node root;

    private void debugHelper(Node tree, int depth) {
        if (tree.right != null) { //recursive for right side
            debugHelper(tree.right, depth + 1);
        }

        for (int i = 0; i < depth; i++) { //prints indenation
            System.out.printf(" ");
        }

        System.out.println(depth + " " + tree.key); //prints deptha and key

        if (tree.left != null) { //recursive for left side
            debugHelper(tree.left, depth + 1);
        }
    }

    private void outputHelper(Node tree) {
        if (tree.right != null) { //recursive for right side
            outputHelper(tree.right);
        }

        System.out.print(tree.key + " : "); //prints key and colon
        for (int i = 0; i < tree.index; i++) {
            System.out.print(tree.value[i] + " ");
        }
        System.out.println("");

        if (tree.left != null) { //recursive for left side
            outputHelper(tree.left);
        }
    }

    public void insert(String key, int linenum) {
        // Insert a word into the tree
        if (root == null) { //if root is null, make a new node for the root
            Node n = new Node();
            n.key = key;
            n.value[n.index] = linenum;
            n.index++;
            root = n;
        } else { //root is occupied
            Node current = root; //start at root
            Node parent;
            while (true) {
                parent = current;
                if (current.key.equals(key)) {
                    current.value[current.index] = linenum;
                    current.index++;
                    return;
                } else if (current.key.compareTo(key) < 0) { //try left
                    current = current.left;
                    if (current == null) {
                        Node n = new Node();
                        n.key = key;
                        n.value[n.index] = linenum;
                        n.index++;
                        parent.left = n;
                        return;
                    }
                } //end left if
                else { //try right
                    current = current.right;
                    if (current == null) {
                        Node n = new Node();
                        n.key = key;
                        n.value[n.index] = linenum;
                        n.index++;
                        parent.right = n;
                        return;
                    }
                } //end right if
            } //end while
        } //end else not root

    } //end insert()

    public void debug() {
        // Show debug output of tree
        debugHelper(root, 0);
    }

    public void output() {
        // Show sorted words with lines where each word appears
        outputHelper(root);
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("word.txt"));
        Tree tree = new Tree();
        for (int linenr = 1; scan.hasNextLine(); ++linenr) {
            for (String word : scan.nextLine().split("\\W+")) {
                tree.insert(word, linenr);
            }
        }
        scan.close();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like debug mode on?");
        String debug = keyboard.nextLine();
        if (debug.equals("yes")) {
            tree.debug();
        } else {
            tree.output();
        }
    }
}
