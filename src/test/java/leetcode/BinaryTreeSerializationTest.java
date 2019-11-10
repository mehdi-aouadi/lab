package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeSerializationTest {
  @Test
  public void deserializeTest() {
    BinaryTreeSerialization.TreeNode head = BinaryTreeSerialization.deserialize("1,2,3,null,null,4,5");
  }

  @Test
  public void serializeTest() {
    /*
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * output: 1,2,null,null,3,4,null,null,5,null,null,
     */
    BinaryTreeSerialization.TreeNode head = new BinaryTreeSerialization.TreeNode(1);
    BinaryTreeSerialization.TreeNode two = new BinaryTreeSerialization.TreeNode(2);
    head.left = two;
    BinaryTreeSerialization.TreeNode four = new BinaryTreeSerialization.TreeNode(4);
    BinaryTreeSerialization.TreeNode five = new BinaryTreeSerialization.TreeNode(5);
    BinaryTreeSerialization.TreeNode three = new BinaryTreeSerialization.TreeNode(3);
    three.left = four;
    three.right = five;
    head.right = three;
    String serialized = "1,2,null,null,3,4,null,null,5,null,null,";
    Assert.assertEquals(serialized, BinaryTreeSerialization.serialize(head));
    BinaryTreeSerialization.TreeNode root = BinaryTreeSerialization.deserialize(serialized);
  }
}
