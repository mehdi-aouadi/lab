package mehdi.practice.lab.io;

import ctci.chapter.one_arrays_strings.ArraysStrings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Encoding {

  public static String runLengthEncode(String str) {
    if(str.matches(".*\\d.*")) {
      throw new IllegalArgumentException("String should not contain any digit. Otherwise it will " +
          "compromise the encoding / decoding.");
    }

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
    stringBuilder.append(charCount).append(lastChar);

    return stringBuilder.toString();
  }

  public static String runLengthDecode(String str) {

    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder occurence = new StringBuilder();

    for (int index = 0; index < str.length(); index++) {
      char currentChar = str.charAt(index);
      if(currentChar - '0' < 10) {
        occurence.append(currentChar);
      } else {
        stringBuilder.append(
            IntStream
                .range(0,ArraysStrings.stringToInteger(occurence.toString()))
                .mapToObj(i -> String.valueOf(currentChar))
                .collect(Collectors.joining(""))
        );
        occurence.setLength(0);
      }
    }
    return stringBuilder.toString();
  }

}
