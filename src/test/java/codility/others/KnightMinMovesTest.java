package codility.others;

import org.junit.Assert;
import org.junit.Test;

public class KnightMinMovesTest {

  @Test
  public void knightMinMoves() {
    Assert.assertEquals(4, KnightMinMoves.knightMinMoveByLevel(5, 5));
    Assert.assertEquals(1, KnightMinMoves.knightMinMoveByLevel(2, 1));
    Assert.assertEquals(3, KnightMinMoves.knightMinMoveByLevel(4, 5));
  }

}
