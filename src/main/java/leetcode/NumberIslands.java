package leetcode;

/**
 * https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/274/
 *
 * <p>Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You
 * may assume all four edges of the grid are all surrounded by water.
 *
 * <p>Example 1:
 *
 * <p>Input: 11110 11010 11000 00000
 *
 * <p>Output: 1 Example 2:
 *
 * <p>Input: 11000 11000 00100 00011
 *
 * <p>Output: 3
 */
public class NumberIslands {

  public int numIslands(char[][] grid) {
    int islandCount = 0;
    for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < grid[rowIndex].length; columnIndex++) {
        if (grid[rowIndex][columnIndex] == '1') {
          islandCount++;
          dfs(grid, rowIndex, columnIndex);
        }
      }
    }
    return islandCount;
  }

  public static void dfs(char[][] grid, int rowIndex, int columnIndex) {
    int heigth = grid.length;
    int width = grid[0].length;
    if (rowIndex >= heigth
        || columnIndex >= width
        || rowIndex < 0
        || columnIndex < 0
        || grid[rowIndex][columnIndex] == '0') {
      return;
    } else {
      grid[rowIndex][columnIndex] = '0';
      dfs(grid, rowIndex + 1, columnIndex);
      dfs(grid, rowIndex - 1, columnIndex);
      dfs(grid, rowIndex, columnIndex + 1);
      dfs(grid, rowIndex, columnIndex - 1);
    }
  }


}
