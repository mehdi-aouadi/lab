package ctci.chapters.one_arrays_strings;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ArraysStringsTest {

  @Test
  @Parameters({"AaBcd123Xx", "Aa Bcd%()23Xx"})
  public void isUniqueAsciiOkTest(String str) {
    Assert.assertTrue(ArraysStrings.isUniqueAscii(str));
  }

  @Test
  @Parameters({"aa", "aBcd  eE", "a         b", "abc ((%%aa"})
  public void isUniqueAsciiNotOkTest(String str) {
    Assert.assertFalse(ArraysStrings.isUniqueAscii(str));
  }

  @Test(expected = IllegalArgumentException.class)
  @Parameters({"éjj", "abcç"})
  public void isUniqueAsciiTestException(String str) {
    ArraysStrings.isUniqueAscii(str);
  }

  @Test
  @Parameters({"abc, cba", "%aBC ((de, (de (%CaB"})
  public void isPermutationSortOk(String firstString, String secondString) {
    Assert.assertTrue(ArraysStrings.isPermutationWithSort(firstString, secondString));
  }

  @Test
  @Parameters({"a, b", "%aBC ((de, (de(%CaB"})
  public void isPermutationSortNotOk(String firstString, String secondString) {
    Assert.assertFalse(ArraysStrings.isPermutationWithSort(firstString, secondString));
  }

  @Test
  @Parameters({"abc, cba", "%aBC ((de, (de (%CaB"})
  public void isPermutationCharCountOk(String firstString, String secondString) {
    Assert.assertTrue(ArraysStrings.isPermutationWithCharCount(firstString, secondString));
  }

  @Test
  @Parameters({"a, b", "%aBC ((de, (de(%CaB"})
  public void isPermutationCharCountNotOk(String firstString, String secondString) {
    Assert.assertTrue(ArraysStrings.isPermutationWithCharCount(firstString, secondString));
  }

  @Test(expected = IllegalArgumentException.class)
  @Parameters({"éjj, jjé", "abcc, abcç"})
  public void isPermutationCharCountException(String firstString, String secondString) {
    ArraysStrings.isPermutationWithCharCount(firstString, secondString);
  }

  @Test
  @Parameters({"123, 123", "1000, 1000", "-123, -123"})
  public void stringToIntegerTestOk(String integerString, int result) {
    Assert.assertEquals(result, ArraysStrings.stringToInteger(integerString));
  }

  @Test
  public void mostCommon() {
    String phrase = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String [] banned = new String[] {"hit"};
    ArraysStrings.mostCommonWord(phrase, banned);
  }
}
