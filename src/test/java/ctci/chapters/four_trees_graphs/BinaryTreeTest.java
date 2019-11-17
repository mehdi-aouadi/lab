package ctci.chapters.four_trees_graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BinaryTreeTest {

  @Test
  public void isBSTTest() {
    BinaryTree.Node head = new BinaryTree.Node(50);
    BinaryTree.Node ten = new BinaryTree.Node(10);
    BinaryTree.Node eighty = new BinaryTree.Node(80);
    BinaryTree.Node five = new BinaryTree.Node(5);
    BinaryTree.Node thirty = new BinaryTree.Node(30);
    BinaryTree.Node twenty = new BinaryTree.Node(20);
    BinaryTree.Node forty = new BinaryTree.Node(40);
    thirty.left = twenty;
    thirty.right = forty;
    ten.left = five;
    ten.right = thirty;
    head.left = ten;
    head.right = eighty;
    BinaryTree.Node seventy = new BinaryTree.Node(70);
    BinaryTree.Node ninety = new BinaryTree.Node(90);
    BinaryTree.Node eightyFive = new BinaryTree.Node(85);
    ninety.left = eightyFive;
    eighty.right = ninety;
    eighty.left = seventy;
    Assert.assertTrue(BinaryTree.validateBST(head));
  }

  @Test
  public void testSymmetric() {
    BinaryTree.Node one = new BinaryTree.Node(1);
    BinaryTree.Node two_left = new BinaryTree.Node(2);
    BinaryTree.Node two_right = new BinaryTree.Node(2);
    one.left = two_left;
    one.right = two_right;
    BinaryTree.Node three_right = new BinaryTree.Node(3);
    BinaryTree.Node three_left = new BinaryTree.Node(3);
    BinaryTree.Node four_right = new BinaryTree.Node(4);
    BinaryTree.Node four_left = new BinaryTree.Node(4);
    two_left.left = three_left;
    two_left.right = four_left;
    two_right.right = three_right;
    two_right.left = four_right;
    Assert.assertTrue(BinaryTree.isSymmetric(one));
  }

  @Test
  public void toLinkedListTest() {
    BinaryTree.Node head = new BinaryTree.Node(4);
    BinaryTree.Node two = new BinaryTree.Node(2);
    BinaryTree.Node three = new BinaryTree.Node(3);
    BinaryTree.Node one = new BinaryTree.Node(1);
    BinaryTree.Node five = new BinaryTree.Node(5);
    two.left = one;
    two.right = three;
    head.left = two;
    head.right = five;
    BinaryTree.Node linkedList = BinaryTree.toLinkedList(head);
  }

  @Test
  public void verticalOrderTest() {
    BinaryTree.Node head = new BinaryTree.Node(6);
    BinaryTree.Node four = new BinaryTree.Node(4);
    head.left = four;
    BinaryTree.Node five = new BinaryTree.Node(5);
    BinaryTree.Node one = new BinaryTree.Node(1);
    four.right = five;
    four.left = one;
    BinaryTree.Node two = new BinaryTree.Node(2);
    one.right = two;
    BinaryTree.Node three = new BinaryTree.Node(3);
    two.right = three;
    List<List<Integer>> verticalOrder = BinaryTree.verticalOrder(head);
  }
}
