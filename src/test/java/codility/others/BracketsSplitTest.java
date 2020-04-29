package codility.others;

import org.junit.Assert;
import org.junit.Test;

public class BracketsSplitTest {

  @Test
  public void bracketsSplitTest() {
    Assert.assertEquals(4, BracketsSplit.bracketsSplit("(())))("));
    Assert.assertEquals(9, BracketsSplit.bracketsSplit("(()))(()()())))"));
  }

}
