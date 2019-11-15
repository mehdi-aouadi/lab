package ctci.chapters.eight_dynamic_recursion;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c
 * columns. The robot can only move in two directions, right and down, but certain cells are "off
 * limits" such that the robot cannot step on them. Design an algorithm to find a path for the robot
 * from the top left to the bottom right.
 *
 */
public class RobotGrid {


  public static boolean pathWithMemoization(int[][] grid) {
    if(grid.length == 0) {
      return false;
    }
    Set<int[]> failedPoints = new HashSet<>();
    return findPathRecursively(grid, 0, 0, failedPoints);
  }

  private static boolean findPathRecursively(int[][] grid, int row, int column,
                                             Set<int[]> failedPoints) {
    int[] currentPoint = new int[] {row, column};
    if(failedPoints.contains(currentPoint)) {
      return false;
    }
    if(row >= grid.length || column >= grid[0].length || grid[row][column] != 0) {
      failedPoints.add(currentPoint);
      return false;
    }
    if(row == grid.length - 1 && column == grid[0].length - 1) {
      return true;
    }
    return findPathRecursively(grid, row + 1, column, failedPoints) || findPathRecursively(grid, row,
        column + 1, failedPoints);
  }

  public static boolean path(int[][] grid) {
    if(grid.length == 0) {
      return false;
    }
    return findPathRecursively(grid, 0, 0);
  }

  private static boolean findPathRecursively(int[][] grid, int row, int column) {
    if(row >= grid.length || column >= grid[0].length || grid[row][column] != 0) {
      return false;
    }
    if(row == grid.length - 1 && column == grid[0].length - 1) {
      return true;
    }
    return findPathRecursively(grid, row + 1, column) || findPathRecursively(grid, row,
        column + 1);
  }

}
