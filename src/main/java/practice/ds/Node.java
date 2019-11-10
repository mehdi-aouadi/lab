package practice.ds;

import java.util.ArrayList;
import java.util.List;

public class Node {
  private int value;
  private List<Node> children;

  public Node(int value) {
    this.value = value;
    this.children = null;
  }

  public Node(int value, List<Node> descendants) {
    this.value = value;
    this.children = descendants;
  }

  int getValue() {
    return this.value;
  }

  List<Node> getChildren() {
    return this.children;
  }

  List<Node> getAllDescendants() {
    List<Node> allDescendants = new ArrayList<>();
    for(Node node: this.getChildren()) {
      allDescendants.add(node);
      if(node.getChildren() != null) {
        allDescendants.addAll(node.getAllDescendants());
      }
    }
    return allDescendants;
  }

  int getAllDescendantsSum() {
    int sum = 0;
    for(Node node : this.getChildren()) {
      sum += node.getValue();
      if (node.getChildren() != null) {
        sum+= node.getAllDescendantsSum();
      }
    }
    return sum;
  }

}
