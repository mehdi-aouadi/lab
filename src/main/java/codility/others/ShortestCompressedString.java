package codility.others;

import java.util.LinkedList;
import java.util.List;

public class ShortestCompressedString {

  public int shortestCompressedString(String s, int k) {
    List<String> compressions = new LinkedList<>();
    for(int index = 0; index < s.length() - k; index++) {
      compressions.add(runLengthEncode(s.substring(index + k)));
    }

    String shortestCompression = compressions.get(0);
    for(int index=1; index < compressions.size(); index++) {
      if(compressions.get(index).length() < shortestCompression.length()) {
        shortestCompression = compressions.get(index);
      }
    }

    return shortestCompression.length();
  }

  public static String runLengthEncode(String str) {
    StringBuilder stringBuilder = new StringBuilder();
    char lastChar = str.charAt(0);
    char currentChar;
    int charCount = 1;

    for(int index = 1; index < str.length(); index++) {
      currentChar = str.charAt(index);
      if(currentChar == lastChar) {
        charCount ++;
      } else {
        stringBuilder.append(charCount).append(lastChar);
        lastChar = currentChar;
        charCount = 1;
      }
    }
    if(charCount == 1) {
      stringBuilder.append(lastChar);
    } else {
      stringBuilder.append(charCount).append(lastChar);
    }

    return stringBuilder.toString();
  }

}
