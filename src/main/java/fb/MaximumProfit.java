package fb;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 *
 * In share trading, a buyer buys shares and sells on a future date.
 * Given the stock price of n days, the trader is allowed to make at most k transactions,
 * where a new transaction can only start after the previous transaction is complete,
 * find out the maximum profit that a share trader could have made.
 * Examples:
 *
 * Input:
 * Price = [10, 22, 5, 75, 65, 80]
 *     K = 2
 * Output:  87
 * Trader earns 87 as sum of 12 and 75
 * Buy at price 10, sell at 22, buy at
 * 5 and sell at 80
 *
 * Input:
 * Price = [12, 14, 17, 10, 14, 13, 12, 15]
 *     K = 3
 * Output:  12
 * Trader earns 12 as the sum of 5, 4 and 3
 * Buy at price 12, sell at 17, buy at 10
 * and sell at 14 and buy at 12 and sell
 * at 15
 *
 * Input:
 * Price = [100, 30, 15, 10, 8, 25, 80]
 *     K = 3
 * Output:  72
 * Only one transaction. Buy at price 8
 * and sell at 80.
 *
 * Input:
 * Price = [90, 80, 70, 60, 50]
 *     K = 1
 * Output:  0
 * Not possible to earn.
 */
public class MaximumProfit {

  // O(n²k) time | O(n²k) space
  public static int maxProfit(int[] prices, int k) {
    if(prices.length == 0) {
      return 0;
    }
    int[][] profits = new int [k + 1][prices.length];

    for(int transaction=1; transaction <= k; transaction++) {
      int maxOverAll = profits[transaction - 1][0] - prices[0];
      for(int day=1; day < prices.length; day++) {
        profits[transaction][day] =
           Math.max(profits[transaction][day-1], prices[day] + maxOldProfit(profits, prices, day, transaction));
      }
    }
    return profits[k][prices.length - 1];
  }

  private static int maxOldProfit(int[][] profits, int[] prices, int day, int transaction) {
    int maxProfit = profits[transaction - 1][0] - prices[0];
    for(int index = 1; index < day; index++) {
      int profit = profits[transaction - 1][index] - prices[index];
      if(profit > maxProfit) {
        maxProfit = profit;
      }
    }
    return maxProfit;
  }

  // O(nk) time | O(nk) space
  public static int maxProfitOmptimizedTime(int[] prices, int k) {
    if(prices.length == 0) {
      return 0;
    }
    int[][] profits = new int [k + 1][prices.length];

    for(int transaction=1; transaction <= k; transaction++) {
      int maxOverAll = profits[transaction - 1][0] - prices[0];
      for(int day=1; day < prices.length; day++) {
        maxOverAll = Math.max(maxOverAll, profits[transaction - 1][day - 1] - prices[day - 1]);
        profits[transaction][day] =
            Math.max(profits[transaction][day-1],
                prices[day] + maxOverAll);
      }
    }
    return profits[k][prices.length - 1];
  }

  // O(nk) time | O(n) space
  public static int maxProfitOmptimizedTimeAndSpace(int[] prices, int k) {
    if(prices.length == 0) {
      return 0;
    }

    int[] oddProfits = new int[prices.length];
    int[] evenProfits = new int[prices.length];
    int[] currentProfit;
    int[] previousProfit;

    for(int transaction=1; transaction <= k; transaction++) {
      if(transaction % 2 == 1) {
        currentProfit = oddProfits;
        previousProfit = evenProfits;
      } else {
        currentProfit = evenProfits;
        previousProfit = oddProfits;
      }
      int maxOverAll = previousProfit[0] - prices[0];
      for(int day=1; day < prices.length; day++) {
        maxOverAll = Math.max(maxOverAll, previousProfit[day - 1] - prices[day - 1]);
        currentProfit[day] =
            Math.max(currentProfit[day-1],
                prices[day] + maxOverAll);
      }
    }
    return k % 2 == 1 ? oddProfits[prices.length - 1]:evenProfits[prices.length - 1];
}

  public static int maxProfit(int[] prices) {
    int profit = 0;
    if(prices.length == 0) {
      return profit;
    }
    int buyingPrice = prices[0];
    for (int index = 1; index < prices.length; index++) {
      int sellingPrice = prices[index];
      profit = Math.max(profit, sellingPrice - buyingPrice);
      buyingPrice = Math.min(buyingPrice, sellingPrice);
    }
    return profit;
  }

}
