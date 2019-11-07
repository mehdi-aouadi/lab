package ctci.chapters.one_arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysStrings {

  /**
   * Checks if a String contains unique characters (case sentitive)
   * @param str an ASCII encoded String
   * @return true if str contains unique characters. False otherwise
   * @param str
   * @return
   * @throws IllegalArgumentException if str contains non ASCII characters
   */
  public static boolean isUniqueAscii(String str) throws IllegalArgumentException{
    boolean[] charSet = new boolean[128];
    if(str.length() > 128) {
      return false;
    }
    for (int index = 0; index < str.length(); index++) {
      int charCode = str.charAt(index);
      if(charCode > 128) {
        throw new IllegalArgumentException(
            String.format("%s is not an ASCII char.", str.charAt(index))
        );
      }
      if (charSet[charCode]) {
        return false;
      } else {
        charSet[charCode] = true;
      }
    }
    return true;
  }

  /**
   * Optimized
   * Checks if a String contains unique characters
   * @param str an ASCII encoded String containing only lowercase letter a throught z
   * @return true if str contains unique characters. False otherwise
   */
  public static boolean isUniqueBitVector(String str) {
    int bitVector = 0;
    for (int index = 0; index < str.length(); index++) {
      int charCode = str.charAt(index) - 'a';
      if((bitVector & (1 << charCode))> 0) {
        return false;
      }
      bitVector |= (1 << charCode);
    }
    return true;
  }

  /**
   * Checks if a {@link String} is a permutation of another String
   * @param firstString
   * @param secondString
   * @return true if firstString is a permutation of secondString. False otherwise
   */
  public static boolean isPermutationWithSort(String firstString, String secondString) {

    if(firstString.length() != secondString.length()) {
      return false;
    }

    char[] firstStringAsArray = firstString.toCharArray();
    Arrays.sort(firstStringAsArray);

    char[] secondStringAsArray = secondString.toCharArray();
    Arrays.sort(secondStringAsArray);

    firstString = new String(firstStringAsArray);
    secondString = new String(secondStringAsArray);

    return firstString.equals(secondString);
  }

  /**
   * Checks if a String is a permutation of another String
   * @param firstString ASCII encoded string
   * @param secondString ASCII encoded string
   * @return true if firstString is a permutation of secondString. False otherwise
   * @throws IllegalArgumentException if firstString or secondString contains non ASCII characters
   */
  public static boolean isPermutationWithCharCount(String firstString, String secondString)
      throws IllegalArgumentException {

    if(firstString.length() != secondString.length()) {
      return false;
    }

    int[] charCount = new int[128];
    for (int index = 0; index < firstString.length(); index++) {
      if(firstString.charAt(index) > 128) {
        throw new IllegalArgumentException(
            String.format("%s is not an ASCII character.", firstString.charAt(index))
        );
      }
      charCount[firstString.charAt(index)] ++;
    }

    for (int index = 0; index < secondString.length(); index++) {
      if(secondString.charAt(index) > 128) {
        throw new IllegalArgumentException(
            String.format("%s is not an ASCII character.", secondString.charAt(index))
        );
      }
      charCount[secondString.charAt(index)]--;
      if(charCount[secondString.charAt(index)] < 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Converts a {@link String} to an int.
   * @param str The {@link String} to convert. May contain negative signe "-"
   *            otherwise considered positive ("+" sign not accepted)
   * @return
   */
  public static int stringToInteger(String str) {
    boolean negative = str.charAt(0) == '-';
    if(negative) {
      str = str.substring(1);
    }
    int result = 0;
    for (int index = 0; index < str.length(); index++) {
      int intValue = str.charAt(index) - '0';
      if(intValue > 9 || intValue < 0) {
        throw new IllegalArgumentException(String.format("%s contains non digit value " +
            "or special charctacter ither tha '-'", str));
      }
      result = result * 10;
      result += intValue;
    }
    return negative ? result * -1:result;
  }

  /**
   * Checks if a {@link String} is different from another {@link String}
   * by only one edit (one different character, one additional character, one less character)
   * @param firstString
   * @param secondString
   * @return true if the two {@link String} are different by only one edit
   */
  public static boolean oneEditAway(String firstString, String secondString) {
    if(firstString.length() == secondString.length()) {
      return oneEditReplacement(firstString, secondString);
    } else if (firstString.length() - secondString.length() == 1) {
      return oneInsertAway(firstString, secondString);
    } else if (secondString.length() - firstString.length() == 1) {
      return oneInsertAway(secondString, firstString);
    }
    return false;
  }

  private static boolean oneEditReplacement(String firstString, String secondString) {
    boolean foundDifference = false;
    for (int index = 0; index < firstString.length(); index++) {
      if(firstString.charAt(index) != secondString.charAt(index)) {
        if(!foundDifference) {
          foundDifference = true;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean oneInsertAway(String firstString, String secondString) {
    int firstIndex = 0;
    int secondIndex = 0;
    while(firstIndex < firstString.length() && secondIndex < secondString.length()) {
      if(firstString.charAt(firstIndex) != secondString.charAt(secondIndex)) {
        if(firstIndex != secondIndex) {
          return false;
        } else {
          firstIndex++;
        }
      } else {
        firstIndex++;
        secondIndex++;
      }
    }
    return true;
  }

  public static String mostCommonWord(String paragraph, String[] banned) {
    Map<String, Integer> wordsCount = new HashMap<>();
    List<String> bannedWords = Arrays.asList(banned);
    String [] words = paragraph.split("[!?',;.]*\\s+[!?',;.]*|[!?',;.]");
    int maxOccurence = 0;
    String result = "";
    for(int index=0; index < words.length; index++) {
      String current = words[index].toLowerCase();
      if(!bannedWords.contains(current)) {
        if(wordsCount.containsKey(current)) {
          int newCount = wordsCount.get(current) + 1;
          wordsCount.put(current, newCount);
          if(newCount >= maxOccurence) {
            maxOccurence = newCount;
            result = current;
          }
        } else {
          wordsCount.put(current, 1);
          if(maxOccurence < 1) {
            maxOccurence = 1;
            result = current;
          }
        }
      }
    }
    return result;
  }

  public static String reverseString(String s) {
    StringBuilder sb = new StringBuilder();
    for(int index=s.length() - 1; index>=0; index--) {
      sb.append(s.charAt(index));
    }
    return sb.toString();
  }


}
