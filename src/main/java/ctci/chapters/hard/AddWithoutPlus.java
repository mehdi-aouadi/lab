package ctci.chapters.hard;

public class AddWithoutPlus {

  public static int addRecursive(int a, int b) {
    if(b == 0) {
      return a;
    }
    int sumWithoutCarry = a ^ b;
    int carry = (a & b) << 1;
    return addRecursive(sumWithoutCarry, carry);
  }

  public static int addIterative(int a, int b) {
    while(b!=0) {
      int sumWithoutCarry = a ^ b;
      int carry = (a & b) << 1;
      a = sumWithoutCarry;
      b = carry;
    }
    return a;
  }

}
