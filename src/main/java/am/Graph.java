package am;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
  private Map<Integer, Node> nodeLookUp;

  static class Node {
    private int id;
    private LinkedList<Node> adjacent = new LinkedList<>();
    Node(int id) {
      this.id = id;
    }
  }

  Graph(Map<Integer, Node> nodes) {
    this.nodeLookUp = nodes;
  }

  private Node getNode(int id) {
    return nodeLookUp.get(id);
  }

  public void addEdge(int source, int destination) {
    Node s = nodeLookUp.get(source);
    Node d = nodeLookUp.get(destination);
    s.adjacent.add(d);
  }

  Deque<Integer> topologicalSort() {
    Deque<Integer> stack = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();

    for (int index = 0; index < this.nodeLookUp.entrySet().size(); index++) {
      Node node = this.getNode(index);
      if(visited.contains(node.id)) {
        continue;
      }

      visited.add(node.id);
      for (Node adjacent: node.adjacent) {
        topologicalSortUtil(adjacent, visited, stack);
      }
      stack.add(node.id);
    }
    return stack;
  }

  private void topologicalSortUtil(Node node, Set<Integer> visited, Deque<Integer> stack) {
    if(!visited.contains(node.id)) {
      visited.add(node.id);
      if(node.adjacent.isEmpty()) {
        stack.add(node.id);
      } else {
        for (Node adjacent: node.adjacent) {
          topologicalSortUtil(adjacent, visited, stack);
        }
      }
    }
  }
}
