package fb;

import org.junit.Assert;
import org.junit.Test;

public class RunLengthEncodingTest {

  @Test
  public void runLengthEncodingTest() {
    Assert.assertEquals("w4a3d1e1x6y1w3",
        RunLengthEncoding.runLengthEncode("wwwwaaadexxxxxxywww"));
  }

  @Test
  public void runLengthDecodingTest() {
    Assert.assertEquals("wwwwaaadexxxxxxywww",
        RunLengthEncoding.runLengthDecode("w4a3d1e1x6y1w3"));
  }

}
