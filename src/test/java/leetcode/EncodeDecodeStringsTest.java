package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStringsTest {
  @Test
  public void testEncodeDecodeStrings() {
    List<String> strs = Arrays.asList("first string", "second"," third String");
    Assert.assertEquals(strs,
        EncodeDecodeStrings.decode(EncodeDecodeStrings.encode(strs)));
    strs = new ArrayList<>();
    Assert.assertEquals(strs,
        EncodeDecodeStrings.decode(EncodeDecodeStrings.encode(strs)));
    String str = "aaaa$END$bbbbbb$END$ccccc$END$";
    Assert.assertEquals(str,EncodeDecodeStrings.encode(EncodeDecodeStrings.decode(str)));
    str = "";
    Assert.assertEquals(str,EncodeDecodeStrings.encode(EncodeDecodeStrings.decode(str)));
  }

}
