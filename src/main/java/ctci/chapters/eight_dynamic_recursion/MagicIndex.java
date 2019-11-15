package ctci.chapters.eight_dynamic_recursion;

/**
 * A magic index in an array A [ 0 ••• n -1] is defined to be an index such that A[i] = i. Given a
 * sorted array of distinct integers, write a method to find a magic index, if one exists, in array
 * A.
 *
 * INPUT:
 * [-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13]
 *    0,   1,  2, 3, 4, 5, 6, 7, 8,  9, 10
 *
 * OUTPUT: 7
 *
 *
 * FOLLOW UP What if the values are not distinct?
 *
 * INPUT:
 * [-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13]
 *    0,  1, 2, 3, 4, 5, 6, 7, 8,  9, 10
 *
 * OUTPUT: 2 or 7
 *
 * INPUT:
 * [-10, -5, -3, 0, 1, 7, 7, 7, 9, 12, 13]
 *    0,  1,  2, 3, 4, 5, 6, 7, 8,  9, 10
 *
 * OUTPUT: 7
 *
 *
 *
 */
public class MagicIndex {

  public static int bruteForce(int[] array) {
    for (int index = 0; index < array.length; index++) {
      if(array[index] == index) {
        return index;
      }
    }
    return -1;
  }

  public static int withDuplicate(int[] array) {
    return withDuplicateHelper(array, 0, array.length -1);
  }

  private static int withDuplicateHelper(int[] array, int start, int end) {
    if(start > end) {
      return -1;
    }
    int middle = (start + end)/2;
    int midValue = array[middle];
    if(midValue == middle) {
      return middle;
    }
    //search right
    int right = withDuplicateHelper(array, Math.max(middle + 1, midValue), end);
    if(right >= 0) {
      return right;
    }

    //search left
    return withDuplicateHelper(array, start, Math.min(middle - 1, midValue));
  }

  public static int binarySearch(int[] array) {
    return binarySearchHelper(array, 0, array.length -1);
  }

  private static int binarySearchHelper(int[] array, int left, int right) {
    if(left > right) {
      return -1;
    }
    int middle = (left + right) / 2;
    int middleValue = array[middle];
    if(middleValue == middle) {
      return middle;
    } else if(middleValue > middle) {
      return binarySearchHelper(array, left, middle);
    } else {
      return binarySearchHelper(array, middle+1, right);
    }
  }

}
