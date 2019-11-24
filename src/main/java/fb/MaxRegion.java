package fb;

/**
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
 *
 */
public class MaxRegion {

  static int maxRegion(int[][] grid) {
    int biggestRegion = 0;
    for(int row = 0; row < grid.length; row++) {
      for(int column = 0; column < grid[0].length; column++) {
        if(grid[row][column] == 1) {
          biggestRegion = Math.max(biggestRegion, dfs(grid, row, column));
        }
      }
    }
    return biggestRegion;
  }

  static int dfs(int[][] grid, int row, int column) {
    if(row >= grid.length
        || column >= grid[0].length
        || row < 0
        || column < 0
        || grid[row][column] == 0
    ) {
      return 0;
    } else {
      grid[row][column] = 0;
      int size = 1;
      for(int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
        for(int columnIndex = column - 1; columnIndex <= column + 1; columnIndex++) {
          size += dfs(grid, rowIndex, columnIndex);
        }
      }
      return size;
    }
  }

}
