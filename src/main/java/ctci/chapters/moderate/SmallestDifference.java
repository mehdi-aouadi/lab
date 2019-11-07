package ctci.chapters.moderate;

import java.util.Arrays;

public class SmallestDifference {

  // Given two arrays of integers, compute the pair of values (one value in each
  // array) with the smallest (non-negative) difference. Return the difference.
  // EXAMPLE
  // Input: {1, 3, 15, 11, 2}, {23, 127,235, 19, 8}
  // Output: 3. That is, the pair (11, 8).

  public static int smallestDifference(int[] firstArray, int[] secondArray) {

    Arrays.sort(firstArray);
    Arrays.sort(secondArray);
    int firstIndex = 0;
    int secondIndex = 0;
    int minDifference = Integer.MAX_VALUE;

    while(firstIndex < firstArray.length && secondIndex < secondArray.length) {
      int difference = Math.abs(firstArray[firstIndex] - secondArray[secondIndex]);
      if(minDifference > difference) {
        minDifference = difference;
      }
      if(firstArray[firstIndex] < secondArray[secondIndex]) {
        firstIndex ++;
      } else {
        secondIndex ++;
      }
    }

    return minDifference;
  }

}
