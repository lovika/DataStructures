package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
 * Author : Lovika Grover
 */
public class LevelOrderTreeInsertion {
    public static void inorder (Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node insert(Node root, int key) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return new Node(key);
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node first = queue.remove();
            if (first.left != null) {
                queue.add(first.left);
            } else {
                first.left = new Node(key);
                return root;
            }
            if (first.right != null) {
                queue.add(first.right);
            } else {
                first.right = new Node(key);
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        LevelOrderTreeInsertion.inorder(root);
        System.out.println();
        root = LevelOrderTreeInsertion.insert(root, 12);
        LevelOrderTreeInsertion.inorder(root);
    }
}
