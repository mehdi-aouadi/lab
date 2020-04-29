package practice.io;

import ctci.chapters.one_arrays_strings.ArraysStrings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Encoding {

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
    stringBuilder.append(charCount).append(lastChar);

    return stringBuilder.toString();
  }

  public static String runLengthDecode(String str) {

    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder occurrence = new StringBuilder();

    for (int index = 0; index < str.length(); index++) {
      char currentChar = str.charAt(index);
      if(currentChar - '0' < 10) {
        occurrence.append(currentChar);
      } else {
        stringBuilder.append(
            IntStream
                .range(0,ArraysStrings.stringToInteger(occurrence.toString()))
                .mapToObj(i -> String.valueOf(currentChar))
                .collect(Collectors.joining(""))
        );
        occurrence.setLength(0);
      }
    }
    return stringBuilder.toString();
  }

}
