package ctci.chapters.four_trees_graphs;

import org.junit.Assert;
import org.junit.Test;

public class TreesGraphsTest {
  @Test
  public void testSymmetric() {
    TreesGraphs.TreeNode one = new TreesGraphs.TreeNode(1);
    TreesGraphs.TreeNode two_left = new TreesGraphs.TreeNode(2);
    TreesGraphs.TreeNode two_right = new TreesGraphs.TreeNode(2);
    one.left = two_left;
    one.right = two_right;
    TreesGraphs.TreeNode three_right = new TreesGraphs.TreeNode(3);
    TreesGraphs.TreeNode three_left = new TreesGraphs.TreeNode(3);
    TreesGraphs.TreeNode four_right = new TreesGraphs.TreeNode(4);
    TreesGraphs.TreeNode four_left = new TreesGraphs.TreeNode(4);
    two_left.left = three_left;
    two_left.right = four_left;
    two_right.right = three_right;
    two_right.left = four_right;
    Assert.assertTrue(TreesGraphs.isSymmetric(one));
  }
}
