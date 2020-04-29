package codility.arrays;

import org.junit.Assert;
import org.junit.Test;

public class OddOccurrencesInArrayTest {

  @Test
  public void oddOccurrencesInArrayTest() {
    Assert.assertEquals(7, OddOccurrencesInArray.oddOccurrencesInArray(new int[] {9, 3, 9, 3, 9, 7, 9}));
  }

  @Test
  public void oddOccurrencesWithSortTest() {
    Assert.assertEquals(7, OddOccurrencesInArray.oddOccurrenceWithSort(new int[] {9, 3, 9, 3, 9, 7, 9}));
  }

  @Test
  public void oddOccurrenceNoSpace() {
    Assert.assertEquals(7, OddOccurrencesInArray.oddOccurrenceNoSpace(new int[] {9, 3, 9, 3, 9, 7, 9}));
  }

}
