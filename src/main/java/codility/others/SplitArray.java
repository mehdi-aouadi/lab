package codility.others;

/**
 * Given an array of integers A and an integer X. Find the position splits the array in two,
 * where one side has as many occurrences of X as the other side has occurrences
 * of any number but X. Otherwise returns -1.
 * Example:
 * A: [5, 5, 2, 3, 5, 1, 6] and X: 5,
 * The function should return 4
 * [5, 5, 2, 3 | 5, 1, 6]
 * Two fives on the left and two non fives on the right (1 and 6).
 */

public class SplitArray {

  public static int splitArray(int[] array, int value) {
    int length = array.length;
    int count = 0;
    int consecutiveCount = 0;
    for (int index = 0; index < length; index++) {
      if(array[index] == value) {
        count++;
        consecutiveCount++;
      } else {
        consecutiveCount = 0;
      }
    }
    return (count > 0 && count != consecutiveCount) ? (length - count) : -1;
  }
}
