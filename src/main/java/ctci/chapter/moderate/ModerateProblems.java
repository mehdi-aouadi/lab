package ctci.chapter.moderate;

import java.util.Arrays;
import java.util.Stack;

public class ModerateProblems {

  /**
   * Calculates the smallest difference between two elements from to dofferent int arrays.
   * @param firstArray
   * @param secondArray
   * @return the smallest difference
   */
  public static int smallestDifference(int[] firstArray, int[] secondArray) {

    Arrays.sort(firstArray);
    Arrays.sort(secondArray);
    int firstIndex = 0;
    int secondIndex = 0;
    int minDifference = Integer.MAX_VALUE;

    while(firstIndex < firstArray.length && secondIndex < secondArray.length) {
      int difference = Math.abs(firstArray[firstIndex] - secondArray[secondIndex]);
      if(minDifference > difference) {
        minDifference = difference;
      }
      if(firstArray[firstIndex] < secondArray[secondIndex]) {
        firstIndex ++;
      } else {
        secondIndex ++;
      }
    }

    return minDifference;
  }

  public int iterativeFib(int order) {

    int result = 0;
    int previous = 1;
    for (int index = 0; index < order; index++) {
      result = result + previous;
      previous = result - previous;
    }

    return result;
  }

  static char[][] groupingCharacters = new char[][]{{'(', ')'}, {'[', ']'}, {'{', '}'}};

  /**
   * Checks if a group of grouping characters is balanced :
   * - Opening characters are equal to closing characters
   * - Opening and closing characters are in the right order
   * @param expression
   * @return true if the expression is balanced, false otherwise
   */
  public boolean balancedGrouping(String expression) {
    Stack<Character> counter = new Stack<>();
    for (int index = 0; index < expression.length(); index++) {
      Character character = expression.charAt(index);
      if(isOpeningCharacter(character)) {
        counter.push(character);
      } else {
        Character lastOpening = counter.pop();
        if(!complementGroupingChars(lastOpening, character)) {
          return false;
        }
      }
    }
    return counter.size() == 0;
  }

  private boolean isOpeningCharacter(Character character) {
    return character == groupingCharacters[0][0] ||
        character == groupingCharacters[1][0] ||
        character == groupingCharacters[2][0];
  }

  private boolean complementGroupingChars(Character opening, Character closing) {
    if(opening == groupingCharacters[0][0]) {
      return closing == groupingCharacters[0][1];
    } else if (opening == groupingCharacters[1][0]) {
      return closing == groupingCharacters[1][1];
    } else if (opening == groupingCharacters[2][0]) {
      return closing == groupingCharacters[2][1];
    } else {
      return false;
    }
  }

  public void permutation(String str) {

  }


}
