package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  https://leetcode.com/problems/encode-and-decode-strings/
 */
public class EncodeDecodeStrings {
  // Encodes a list of strings to a single string.
  public static String encode(List<String> strs) {
    if(strs.isEmpty()) {
      return "$EMPTY$";
    }
    final String delimiter = "$END$";
    StringBuilder encoded = new StringBuilder();
    for (String s: strs) {
      encoded.append(s).append(delimiter);
    }
    encoded.delete(encoded.length() - delimiter.length(), encoded.length());
    return encoded.toString();
  }

  // Decodes a single string to a list of strings.
  public static List<String> decode(String s) {
    final String delimiter = "\\$END\\$";
    if(s.equals("$EMPTY$")) {
      return new ArrayList<>();
    }
    return Arrays.asList(s.split(delimiter, -1));
  }
}
