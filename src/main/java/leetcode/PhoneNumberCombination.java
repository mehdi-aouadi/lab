package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 *
 * 2: a,b,c
 * 3: d,e,f
 * 4: g,h,i
 * 5: j,k,l
 * 6: m,n,o
 * 7: p,q,r,s
 * 8: t,u,v
 * 9: w,x,y,z
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you
 * want.
 */
public class PhoneNumberCombination {

  Map<Character, List<Character>> mapping = new HashMap<Character, List<Character>>() {{
    put('2', Arrays.asList('a', 'b', 'c'));
    put('3', Arrays.asList('d', 'e', 'f'));
    put('4', Arrays.asList('g', 'h', 'i'));
    put('5', Arrays.asList('j', 'k', 'l'));
    put('6', Arrays.asList('m', 'n', 'o'));
    put('7', Arrays.asList('p', 'q', 'r', 's'));
    put('8', Arrays.asList('t', 'u', 'v'));
    put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }};

  public List<String> letterCombinations(String digits) {
    List<String> output = new ArrayList<>();
    if(digits.isEmpty()) {
      return new ArrayList<>();
    }
    recursiveLetterCombinations(new StringBuilder(),
        digits.chars().mapToObj(c -> (char) c).collect(Collectors.toList()), output);
    return output;
  }

  private void recursiveLetterCombinations(StringBuilder combination, List<Character> nextDigits,
                                           List<String> output) {
    if(nextDigits.isEmpty()) {
      output.add(combination.toString());
    } else {
      Character nextDigit = nextDigits.get(0);
      List<Character> nextDigitLetters = mapping.get(nextDigit);
      for(Character nextDigitChar: nextDigitLetters) {
        recursiveLetterCombinations(combination.append(nextDigitChar), nextDigits.subList(1,
            nextDigits.size()), output);
        combination.deleteCharAt(combination.length() - 1);
      }
    }
  }

}
