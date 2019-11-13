package leetcode;

import java.util.List;

import org.junit.Test;

public class InvalidParenthesesTest {

  @Test
  public void invalidParenthesisTest() {
    InvalidParentheses invalidParentheses = new InvalidParentheses();
    // List<String> result = invalidParentheses.removeInvalidParenthesesRecursive("()())()");
    // invalidParentheses.removeInvalidParenthesis("()())()");
    List<String> result = invalidParentheses.removeInvalidParentheses("()())()");
  }

}
