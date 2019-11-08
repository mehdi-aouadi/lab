package fb;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.
 * Examples:
 * a) If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers from 1 to 5.
 *
 * b) If array is {83, 78, 80, 81, 79, 82}, then the function should return true because the array has consecutive numbers from 78 to 83.
 *
 *
 *
 * c) If the array is {34, 23, 52, 12, 3 }, then the function should return false because the elements are not consecutive.
 *
 * d) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false because 5 and 5 are not consecutive.
 */
public class ArrayConsecutive {
  public static boolean isConsecutive(int[] array) {
    Arrays.sort(array);
    return array[array.length - 1] - array[0] == array.length - 1;
  }
}
