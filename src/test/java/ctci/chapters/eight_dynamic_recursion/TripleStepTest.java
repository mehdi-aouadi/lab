package ctci.chapters.eight_dynamic_recursion;

import org.junit.Assert;
import org.junit.Test;

public class TripleStepTest {

  @Test
  public void tripleStepTest() {
    Assert.assertEquals(0, TripleStep.count(0));
    Assert.assertEquals(4, TripleStep.count(3));
  }
}
