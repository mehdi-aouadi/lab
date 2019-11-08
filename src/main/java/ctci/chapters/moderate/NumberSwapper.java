package ctci.chapters.moderate;

public class NumberSwapper {

  // Page 181
  // 16.1
  // Solution page 462
  // Write a function to swap a number in place (that is, without temporary vari­
  // ables).
  public static void swapIntegers(int a, int b) {
    a = a + b;
    b = a - b;
    a = a - b;
  }

  public static void swapLongs(byte a, byte b) {
  }


}
