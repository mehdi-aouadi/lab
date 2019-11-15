package ctci.chapters.eight_dynamic_recursion;

import org.junit.Assert;
import org.junit.Test;

public class TripleStepTest {

  @Test
  public void tripleStepTest() {
    Assert.assertEquals(0, TripleStep.count(0));
    Assert.assertEquals(4, TripleStep.count(3));
    Assert.assertEquals(1, TripleStep.countRecursive(0));
    Assert.assertEquals(4, TripleStep.countRecursive(3));
    Assert.assertEquals(0, TripleStep.countMemoization(0));
    Assert.assertEquals(4, TripleStep.countMemoization(3));
    Assert.assertEquals(4, TripleStep.countMemoization(3));
  }
}
