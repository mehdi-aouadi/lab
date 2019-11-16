package fb;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfitTest {

  @Test
  public void maxProfitOneTransactionTest() {
    int[] prices = new int[] {10, 20, 5, 15, 50};
    Assert.assertEquals(45, MaximumProfit.maxProfit(prices));
    prices = new int[] {10};
    Assert.assertEquals(0, MaximumProfit.maxProfit(prices));
  }

  @Test
  public void maxProfitMultiTransactions() {
    int[] prices = new int[] {5, 11, 3, 50, 60, 90};
    Assert.assertEquals(93, MaximumProfit.maxProfit(prices, 2));
    Assert.assertEquals(93, MaximumProfit.maxProfitOmptimizedTime(prices, 2));
    Assert.assertEquals(93, MaximumProfit.maxProfitOmptimizedTimeAndSpace(prices, 2));
    prices = new int[] {12, 14, 17, 10, 14, 13, 12, 15};
    Assert.assertEquals(12, MaximumProfit.maxProfit(prices, 3));
    Assert.assertEquals(12, MaximumProfit.maxProfitOmptimizedTime(prices, 3));
    Assert.assertEquals(12, MaximumProfit.maxProfitOmptimizedTimeAndSpace(prices, 3));
  }
}
