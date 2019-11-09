package ctci.chapters.four_trees_graphs;

import java.util.*;

public class Graph {

  private Map<Integer, Node> nodes = new HashMap<>();

  public static class Node {
    private int id;
    LinkedList<Node> adjacent;
    public Node(int id) {
      this.id = id;
      this.adjacent = new LinkedList<>();
    }
  }

  private Node getNode(int id) {
    return this.nodes.get(id);
  }

  public void AddEdge(int source, int destination) {
    Node s = getNode(source);
    Node d = getNode(destination);
    s.adjacent.push(d);
  }

  public boolean hasPathDFS(int source, int destination) {
    Set<Integer> visited = new HashSet<>();
    Node s = getNode(source);
    Node d = getNode(destination);
    return hasPathDFS(s, d, visited);
  }

  private boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {
    if(visited.contains(source.id) || source == null) {
      return false;
    }
    visited.add(source.id);
    if(source == destination) {
      return true;
    }
    for (Node child: source.adjacent) {
      if(hasPathDFS(child, destination, visited)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasPathBSF(int s, int d) {
    Set<Integer> visited = new HashSet<>();
    Node source = getNode(s);
    Node destination = getNode(d);
    LinkedList<Node> toVisit = new LinkedList<>();
    toVisit.add(source);
    while(!toVisit.isEmpty()) {
      Node visitedNode = toVisit.remove();
      if(visitedNode == destination) {
        return true;
      }
      if(visited.contains(visitedNode.id) || visitedNode == null) {
        continue;
      }
      visited.add(visitedNode.id);
      for (Node child: visitedNode.adjacent) {
        toVisit.add(child);
      }
    }
    return false;
  }

  private boolean hasPathBSF(Node source, Node destination, Set<Integer> visited, LinkedList<Node> toVisit) {





    return false;
  }

}
