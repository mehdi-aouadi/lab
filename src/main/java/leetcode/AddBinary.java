package leetcode;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/add-binary/
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1" Output: "100" Example 2:
 *
 * Input: a = "1010", b = "1011" Output: "10101"
 */
public class AddBinary {
  public static String addBinaryBigInteger(String a, String b) {
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);
    BigInteger zero = new BigInteger("0", 2);
    BigInteger carry, sumWithoutCarrying;
    while (y.compareTo(zero) != 0) {
      sumWithoutCarrying = x.xor(y);
      carry = x.and(y).shiftLeft(1);
      x = sumWithoutCarrying;
      y = carry;
    }
    return x.toString(2);
  }
}
