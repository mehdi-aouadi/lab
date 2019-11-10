package practice.sort;

import org.junit.Assert;
import org.junit.Test;

public class SortingTest {

  @Test
  public void mergeSort() {
    int[] array = new int[] {2, 21, 15, 1, 3, 4, 35, 54};
    MergeSort.mergeSort(array);
    Assert.assertEquals(1, array[0]);
    Assert.assertEquals(2, array[1]);
    Assert.assertEquals(3, array[2]);
    Assert.assertEquals(4, array[3]);
    Assert.assertEquals(15, array[4]);
    Assert.assertEquals(21, array[5]);
    Assert.assertEquals(35, array[6]);
    Assert.assertEquals(54, array[7]);
  }

}
