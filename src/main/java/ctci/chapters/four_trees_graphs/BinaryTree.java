package ctci.chapters.four_trees_graphs;

import java.util.*;
import java.util.stream.Collectors;

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

  public static void dfsInOrderTraversal(Node node) {
    if(node == null) {
      return;
    }
    dfsInOrderTraversal(node.left);
    System.out.println(node.val);
    dfsInOrderTraversal(node.right);
  }

  /**
   * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
   *
   * Convert a BST to a sorted circular doubly-linked list in-place.
   * Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
   *
   * Specifically, we want to do the transformation in place.
   * After the transformation, the left pointer of the tree node should point to its predecessor,
   * and the right pointer should point to its successor.
   * We should return the pointer to the first element of the linked list.
   *
   */
  static Node first = null;
  static Node last = null;

  public static Node toLinkedList(Node root) {

    dfsInorderToLinkedList(root);

    first.left = last;
    last.right = first;
    return first;
  }

  private static void dfsInorderToLinkedList(Node node) {
    if (node != null) {
      //left
      dfsInorderToLinkedList(node.left);

      //node
      if(first == null) {
        first = node;
      } else {
        last.right = node;
        node.left = last;
      }
      last = node;

      //right
      dfsInorderToLinkedList(node.right);
    }
  }

  public static List<List<Integer>> verticalOrder(Node root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    TreeMap<Integer, PriorityQueue<Position>> nodesByLevel = new TreeMap<>();
    verticalOrderHelper(root, 0, 0, nodesByLevel);
    for(PriorityQueue<Position> entry: nodesByLevel.values()) {
      List<Integer> level = new ArrayList<>();
      while(!entry.isEmpty()) {
        level.add(entry.poll().nodeValue);
      }
      result.add(level);
    }
    return result;
  }

  private static void verticalOrderHelper(Node node, int verticalLevel, int horizontalLevel,TreeMap<Integer, PriorityQueue<Position>> nodesByLevel) {
    if(node == null) {
      return;
    }
    Position position = new Position(node.val, horizontalLevel);
    if(nodesByLevel.containsKey(verticalLevel)) {
      nodesByLevel.get(verticalLevel).add(position);
    } else {
      PriorityQueue<Position> newVerticalLevel = new PriorityQueue<>();
      newVerticalLevel.add(position);
      nodesByLevel.put(verticalLevel, newVerticalLevel);
    }
    verticalOrderHelper(node.left, verticalLevel - 1, horizontalLevel + 1, nodesByLevel);
    verticalOrderHelper(node.right, verticalLevel + 1, horizontalLevel + 1,nodesByLevel);
  }

  static class Position implements Comparable<Position> {
    public int nodeValue;
    public int horizontalLevel;
    public Position(int nodeValue, int horizontalLevel) {
      this.nodeValue = nodeValue;
      this.horizontalLevel = horizontalLevel;
    }

    @Override
    public int compareTo(Position o) {
      int compare = Integer.compare(o.horizontalLevel, horizontalLevel);
      if (compare != 0) {
        return compare;
      }
      return Integer.compare(nodeValue, o.nodeValue);
    }
  }

}
