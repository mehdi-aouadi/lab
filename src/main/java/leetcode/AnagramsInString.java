package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class AnagramsInString {

  /**
   *  Input
   *  s: "cbaebabacd" p: "abc"
   *  Output:
   *  [0, 6]
   *
   *  Input:
   *  s: "abab" p: "ab"
   *  Output:
   *  [0, 1, 2]
   */
  public static List<Integer> findAnagramsWithHashMapCount(String s, String p) {
    if(s.isEmpty() || p.isEmpty()) {
      return Collections.emptyList();
    }
    Map<Character, Integer> lettersCount = new HashMap<>();
    for (Character c: p.toCharArray()) {
      if(lettersCount.containsKey(c)) {
        lettersCount.put(c, lettersCount.get(c) + 1);
      } else {
        lettersCount.put(c, 1);
      }
    }
    List<Integer> positions = new ArrayList<>();
    for(int index = 0; index <= s.length() - p.length(); index++) {
      String next = s.substring(index, index + p.length());
      Map<Character, Integer> currentCount = new HashMap<>();
      boolean permutation = true;
      for (Character c: next.toCharArray()) {
        if(lettersCount.containsKey(c)
            && (!currentCount.containsKey(c))) {
          currentCount.put(c, 1);
        } else if(lettersCount.containsKey(c)
            && (currentCount.containsKey(c) && currentCount.get(c) < lettersCount.get(c))) {
          currentCount.put(c, currentCount.get(c) + 1);
        } else {
          permutation = false;
        }
      }
      if(permutation) {
        positions.add(index);
      }
    }
    return positions;
  }

  public static List<Integer> findAnagramsWithPermutation(String s, String p) {
    if(s.isEmpty() || p.isEmpty()) {
      return Collections.emptyList();
    }
    int[] letters = new int[26];
    for (char letter: p.toCharArray()) {
      letters[letter - 'a']++;
    }
    List<Integer> positions = new ArrayList<>();
    for(int index = 0; index <= s.length() - p.length(); index++) {
      String next = s.substring(index, index + p.length());
      if(isPermutation(next, letters)) {
        positions.add(index);
      }
    }
    return positions;
  }

  private static boolean isPermutation(String first, int[] letters) {
    int[] lettersCount = new int[26];
    System.arraycopy(letters, 0, lettersCount, 0, letters.length);
    for (char c : first.toCharArray()) {
      lettersCount[c - 'a']--;
      if (lettersCount[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  public static List<Integer> findAnagramsWithSort(String s, String p) {
    if(s.isEmpty() || p.isEmpty()) {
      return Collections.emptyList();
    }
    char[] sortedPalindromeChars= p.toCharArray();
    Arrays.sort(sortedPalindromeChars);
    String sortedPalindrome = new String(sortedPalindromeChars);
    List<Integer> positions = new ArrayList<>();
    for(int index = 0; index <= s.length() - p.length(); index++) {
      char[] nextChars = s.substring(index, index + p.length()).toCharArray();
      Arrays.sort(nextChars);
      String next = new String(nextChars);
      if(next.equals(sortedPalindrome)) {
        positions.add(index);
      }
    }
    return positions;
  }

}
