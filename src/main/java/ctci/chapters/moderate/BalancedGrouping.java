package ctci.chapters.moderate;

import java.util.Stack;

public class BalancedGrouping {

  static char[][] groupingCharacters = new char[][]{{'(', ')'}, {'[', ']'}, {'{', '}'}};

  // Checks if a group of grouping characters is balanced :
  // - Opening characters are equal to closing character
  // - Opening and closing characters are in the right order
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

}
