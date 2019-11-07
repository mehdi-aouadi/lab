package ctci.chapters.four_trees_graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreesGraphs {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static boolean isSymmetric(TreeNode root) {
    Deque<TreeNode> values = new ArrayDeque<>();

    isSymUtils(values, root);

    Queue<TreeNode> toVisit = new LinkedList<TreeNode>();
    toVisit.add(root.left);
    toVisit.add(root.right);
    while(!toVisit.isEmpty()) {
      TreeNode visited = toVisit.poll();
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

  public static void isSymUtils(Deque<TreeNode> values, TreeNode node) {
    if(node == null || node.val == Integer.MIN_VALUE) {
      return;
    }
    if(node.left == null && node.val != Integer.MIN_VALUE) {
      node.left = new TreeNode(Integer.MIN_VALUE);
    }
    if(node.right == null  && node.val != Integer.MIN_VALUE) {
      node.right = new TreeNode(Integer.MIN_VALUE);
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
