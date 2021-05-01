package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Print Level Order Traversal
 * Tested on : https://practice.geeksforgeeks.org/problems/level-order-traversal/1
 * Author : Lovika
 */
public class LevelOrderTraversal
{
    //Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node node)
    {
        ArrayList<Integer> levelOrder = new ArrayList<>();
        // Your code here
        Queue<Node> storeLevelOrder = new LinkedList<>();
        storeLevelOrder.add(node);
        while (!storeLevelOrder.isEmpty()) {
            Node first = storeLevelOrder.remove();
            levelOrder.add(first.data);
            if (first.left != null) {
                storeLevelOrder.add(first.left);
            }
            if (first.right != null) {
                storeLevelOrder.add(first.right);
            }
        }
        return levelOrder;
    }
}