package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class AddBinaryTest {
  @Test
  public void addBinaryTest() {
    String expected = "10001";
    Assert.assertEquals(expected, AddBinary.addBinaryBigInteger("1111", "0010"));
  }
}
