package ctci.chapters.eight_dynamic_recursion;

import org.junit.Assert;
import org.junit.Test;

public class MagicIndexTest {
  @Test
  public void magicIndexTest() {
    int[] array = new int[] {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
    Assert.assertEquals(7, MagicIndex.bruteForce(array));
    Assert.assertEquals(7, MagicIndex.binarySearch(array));

    Assert.assertEquals(7, MagicIndex.withDuplicate(array));
    int[] arrayWithDuplicates = new int[] {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
    Assert.assertEquals(7, MagicIndex.withDuplicate(arrayWithDuplicates));
  }
}
