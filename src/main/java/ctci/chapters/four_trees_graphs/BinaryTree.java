package ctci.chapters.four_trees_graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

  static class Node {
    int val;
    Node left;
    Node right;
    Node(int x) { val = x; }
  }

  /**
   * Validate BST: Implement a function to check if a binary tree is a binary search tree.
   */
  public static boolean validateBST(Node head) {
    return isBSTUtil(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBSTUtil(Node node, int min, int max) {
    if(node == null) {
      return true;
    }
    if(node.val < min || node.val > max) {
      return false;
    }
    return isBSTUtil(node.left, min, node.val - 1) && isBSTUtil(node.right, node.val - 1, max);
  }

  public static boolean isSymmetric(Node root) {
    Deque<Node> values = new ArrayDeque<>();

    isSymUtils(values, root);

    Queue<Node> toVisit = new LinkedList<>();
    toVisit.add(root.left);
    toVisit.add(root.right);
    while(!toVisit.isEmpty()) {
      Node visited = toVisit.poll();
      isSymUtils(values, visited);
      if(visited.left != null) {
        toVisit.add(visited.left);
      }
      if(visited.right != null) {
        toVisit.add(visited.right);
      }
    }

    return values.isEmpty();
  }

  public static void isSymUtils(Deque<Node> values, Node node) {
    if(node == null || node.val == Integer.MIN_VALUE) {
      return;
    }
    if(node.left == null && node.val != Integer.MIN_VALUE) {
      node.left = new Node(Integer.MIN_VALUE);
    }
    if(node.right == null  && node.val != Integer.MIN_VALUE) {
      node.right = new Node(Integer.MIN_VALUE);
    }
    values.add(node.left);
    if((values.peek() == null && node.right == null)
        || (values.peek().val == node.right.val)) {
      values.pop();
    } else {
      values.add(node.right);
    }
  }

}
