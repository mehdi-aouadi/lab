package ds;

import mehdi.practice.lab.ds.BinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {
  @Test
  public void btsCheck() {
    BinarySearchTree.Node five = new BinarySearchTree.Node(5, null, null);
    BinarySearchTree .Node ten = new BinarySearchTree.Node(49, five, null);
    BinarySearchTree.Node seventy = new BinarySearchTree.Node(70, null, null);
    BinarySearchTree.Node ninety = new BinarySearchTree.Node(90, null, null);
    BinarySearchTree.Node eighty = new BinarySearchTree.Node(80, seventy, ninety);
    BinarySearchTree.Node root = new BinarySearchTree.Node(50, ten, eighty);
    Assert.assertTrue(BinarySearchTree.checkBTS(root));
  }
}
