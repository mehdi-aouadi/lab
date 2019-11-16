package fb;

import ctci.chapters.one_arrays_strings.ArraysStrings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunLengthEncoding {

  public static String runLengthEncode(String s) {
    if(s.matches(".*\\d.*")) {
      throw new IllegalArgumentException("String must not include digits.");
    }
    StringBuilder encoded = new StringBuilder();
    int index = 0;
    while(index < s.length()) {
      encoded.append(s.charAt(index));
      int count = 1;
      while(index < s.length() - 1
          && s.charAt(index+1) == s.charAt(index)) {
        count++;
        index++;
      }
      encoded.append(count);
      index++;
    }
    return encoded.toString();
  }

  public static String runLengthDecode(String s) {
    if(s.matches("\\d.*") || s.matches("\\D$")) {
      throw new IllegalArgumentException("String must start with a letter and end with a digit");
    }
    StringBuilder decoded = new StringBuilder();
    StringBuilder occurrence = new StringBuilder();
    Character lastChar = null;
    for(int index = 0; index < s.length(); index++) {
      Character c = s.charAt(index);
      if(Character.isDigit(c)) {
        occurrence.append(c);
      } else {
        if(occurrence.length() != 0) {
          Character charToAppend = lastChar;
          decoded.append(
              appendChar(charToAppend, occurrence)
          );
          occurrence.setLength(0);
        }
        lastChar = c;
      }
    }
    Character charToAppend = lastChar;
    decoded.append(
        appendChar(charToAppend, occurrence)
    );
    return decoded.toString();
  }

  private static String appendChar(Character charToAppend, StringBuilder occurrence) {
    return IntStream
        .range(0,ArraysStrings.stringToInteger(occurrence.toString()))
        .mapToObj(i -> String.valueOf(charToAppend))
        .collect(Collectors.joining(""));
  }

}
