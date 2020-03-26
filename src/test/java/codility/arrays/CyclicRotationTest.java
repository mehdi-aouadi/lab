package codility.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class CyclicRotationTest {

  @Test
  public void cyclicRotationTest() {
    Assert.assertArrayEquals(new int[]{}, CyclicRotation.cyclicRotation(new int[]{}, Math.abs(new Random().nextInt())));
    Assert.assertArrayEquals(new int[]{9, 7, 6, 3, 8}, CyclicRotation.cyclicRotation(new int[]{3, 8, 9, 7, 6}, 3));
    Assert.assertArrayEquals(new int[]{0, 0, 0}, CyclicRotation.cyclicRotation(new int[]{0, 0, 0}, Math.abs(new Random().nextInt())));
    Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, CyclicRotation.cyclicRotation(new int[]{1, 2, 3, 4}, 4));
  }

}
