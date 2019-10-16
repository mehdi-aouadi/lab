package am;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {
/*

Input
0:
1: 0
2: 0
3: 1, 2
4: 3

Output: 0, 1, 2, 3, 4

 */
  @Test
  public void TopologicalSortTest() {
    Map<Integer, Graph.Node> nodeLookup = new HashMap<>();
    Graph.Node zero = new Graph.Node(0);
    nodeLookup.put(0, zero);
    Graph.Node one = new Graph.Node(1);
    nodeLookup.put(1, one);
    Graph.Node two = new Graph.Node(2);
    nodeLookup.put(2, two);
    Graph.Node three = new Graph.Node(3);
    nodeLookup.put(3, three);
    Graph.Node four = new Graph.Node(4);
    nodeLookup.put(4, four);

    Graph dag = new Graph(nodeLookup);
    dag.addEdge(1, 0);
    dag.addEdge(2, 0);
    dag.addEdge(3, 1);
    dag.addEdge(3, 2);
    dag.addEdge(4, 3);


    Deque<Integer> result = dag.topologicalSort();

    Assert.assertEquals(5, result.size());

    Assert.assertEquals(0, (int) result.pop());
    Assert.assertEquals(1, (int) result.pop());
    Assert.assertEquals(2, (int) result.pop());
    Assert.assertEquals(3, (int) result.pop());
    Assert.assertEquals(4, (int) result.pop());
  }

}
