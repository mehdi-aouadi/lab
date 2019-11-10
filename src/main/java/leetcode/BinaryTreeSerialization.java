package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * DFS:
 * as "[1,2,null,null,3,4,null,null,5,null,null]"
 *
 */
public class BinaryTreeSerialization {

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    if(data.isEmpty()) {
      return null;
    }
    String[] tokens = data.split(",");
    return recursiveDeserialize(new ArrayList<>(Arrays.asList(tokens)));
  }

  private static TreeNode recursiveDeserialize(List<String> values) {
    if(values.get(0).equals("null")) {
      values.remove(0);
      return null;
    }
    TreeNode head = new TreeNode(Integer.valueOf(values.remove(0)));
    head.left = recursiveDeserialize(values);
    head.right = recursiveDeserialize(values);
    return head;
  }

  public static String serialize(TreeNode node) {
    if(node == null) {
      return "null,";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(node.val).append(",");
    sb.append(serialize(node.left));
    sb.append(serialize(node.right));
    return sb.toString();
  }

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
}
