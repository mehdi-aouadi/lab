package ctci.chapters.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem
 *
 * Sample Input
 *
 * 12
 * 4
 * 5
 * 3
 * 8
 * 7
 * Sample Output
 *
 * 12.0
 * 8.0
 * 5.0
 * 4.5
 * 5.0
 * 6.0
 *
 */

public class RunningMedian {

  public static double[] getMedians(int[] array) {
    PriorityQueue<Integer> lowerValues = new PriorityQueue<>(Comparator.comparing(value -> (Integer)value).reversed());
    PriorityQueue<Integer> higherValues = new PriorityQueue<>();
    double[] medians = new double[array.length];
    for (int index = 0; index < array.length; index++) {
      addToHeaps(array[index], lowerValues, higherValues);
      rebalanceHeaps(lowerValues, higherValues);
      medians[index] = getMedian(lowerValues, higherValues);
    }

    return medians;
  }

  private static void addToHeaps(int value, PriorityQueue<Integer> smallest, PriorityQueue<Integer> biggestValues) {
    if(smallest.isEmpty() || value < smallest.peek()) {
      smallest.add(value);
    } else {
      biggestValues.add(value);
    }
  }

  private static void rebalanceHeaps(PriorityQueue<Integer> smallestValues, PriorityQueue<Integer> biggestValues) {
    PriorityQueue<Integer> bigger = smallestValues.size() > biggestValues.size() ? smallestValues:biggestValues;
    PriorityQueue<Integer> smaller = smallestValues.size() < biggestValues.size() ? smallestValues:biggestValues;
    if(bigger.size() - smaller.size() >= 2) {
      smaller.add(bigger.poll());
    }
  }

  private static double getMedian(PriorityQueue<Integer> smallestValues, PriorityQueue<Integer> biggestValues) {
    if(smallestValues.size() == biggestValues.size()) {
      return ((double)smallestValues.peek() + biggestValues.peek()) / 2.0;
    } else {
      return smallestValues.size() > biggestValues.size() ? smallestValues.peek():biggestValues.peek();
    }
  }

}
