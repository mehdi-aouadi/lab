package mehdi.practice.lab.ds;

public class BinarySearchTree {

  public static boolean checkBTS(Node root) {
    return checkBTS(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  static boolean checkBTS(Node node, int minValue, int maxValue) {
    if(node == null) {
      return true;
    }
    if(node.value < minValue || node.value > maxValue) {
      return false;
    }
    return checkBTS(node.rightNode, node.value - 1, maxValue)
        && checkBTS(node.leftNode, minValue, node.value - 1);
  }

  public static class Node {
    int value;
    Node rightNode;
    Node leftNode;

    public Node(int value, Node leftNode, Node rightNode) {
      this.value = value;
      this.leftNode = leftNode;
      this.rightNode = rightNode;
    }
  }
}
