package ctci.chapters.eight_dynamic_recursion;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PowerSetTest {

  @Test
  public void powerSetTest() {
    List<Integer> set = Arrays.asList(1, 2, 3);
    List<List<Integer>> allSubsets = PowerSet.subSets(set);
    Assert.assertEquals(8, allSubsets.size());
    Assert.assertTrue(allSubsets.contains(Arrays.asList(1)));
    Assert.assertTrue(allSubsets.contains(Arrays.asList(2)));
    Assert.assertTrue(allSubsets.contains(Arrays.asList(2, 1)));
    Assert.assertTrue(allSubsets.contains(Arrays.asList(3, 1)));
    Assert.assertTrue(allSubsets.contains(Arrays.asList(3, 2)));
    Assert.assertTrue(allSubsets.contains(Arrays.asList(3, 2, 1)));
  }
}
