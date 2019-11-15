package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()" Output: ["()()()", "(())()"] Example 2:
 *
 * Input: "(a)())()" Output: ["(a)()()", "(a())()"] Example 3:
 *
 * Input: ")(" Output: [""]
 *
 */
public class InvalidParentheses {

  private Set<String> validExpressions = new HashSet<>();
  private int minimumRemoved;

  public List<String> removeInvalidParentheses(String s) {
    if(s.isEmpty()) {
      return new ArrayList<>();
    }

    Set<String> result = new HashSet<>();
    Set<String> visited = new HashSet<>();
    Queue<String> toVisit = new LinkedList<>();
    toVisit.add(s);
    visited.add(s);

    int removed = Integer.MAX_VALUE;
    boolean level = false;

    while(!toVisit.isEmpty()) {
      String toCheck = toVisit.remove();
      int removedChars = s.length() - toCheck.length();

      if(isValid(toCheck)) {
        if(removedChars <= removed) {
          result.add(toCheck);
          removed = removedChars;
          level = true;
        }
      }

      if (level) {
        continue;
      }

      if(removedChars <= removed) {
        for(int index=0; index < toCheck.length(); index++) {
          if(!isParenthesis(toCheck.charAt(index))) {
            continue;
          }
          toVisit.add(toCheck.substring(0, index) + toCheck.substring(index+1, toCheck.length()));
        }
      }

    }

    return new ArrayList<>(result);
  }

  public void removeInvalidParenthesis(String str)
  {
    if (str.isEmpty())
      return;

    // visit set to ignore already visited string
    HashSet<String> visit = new HashSet<String>();

    // queue to maintain BFS
    Queue<String> q = new LinkedList<>();
    String temp;
    boolean level = false;

    // pushing given string as
    // starting node into queue
    q.add(str);
    visit.add(str);
    while (!q.isEmpty())
    {
      str = q.peek(); q.remove();
      if (isValid(str))
      {
        System.out.println(str);

        // If answer is found, make level true
        // so that valid string of only that level
        // are processed.
        level = true;
      }
      if (level)
        continue;
      for (int i = 0; i < str.length(); i++)
      {
        if (!isParenthesis(str.charAt(i)))
          continue;

        // Removing parenthesis from str and
        // pushing into queue,if not visited already
        temp = str.substring(0, i) + str.substring(i + 1);
        if (!visit.contains(temp))
        {
          q.add(temp);
          visit.add(temp);
        }
      }
    }
  }

  public boolean isValid(String s) {
    int count=0;

    for(char c: s.toCharArray()) {
      if(c == '(') {
        count++;
      } else if(c == ')') {
        count--;
        if(count < 0) {
          return false;
        }
      }
    }

    return count == 0;
  }

  public boolean isParenthesis(char c) {
    return c=='(' || c==')';
  }

  public List<String> removeInvalidParenthesesRecursive(String s) {
    this.reset();
    this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
    return new ArrayList<>(this.validExpressions);
  }

  private void reset() {
    this.validExpressions.clear();
    this.minimumRemoved = Integer.MAX_VALUE;
  }

  private void recurse(String s, int index, int leftCount, int rightCount,
                       StringBuilder expression, int removedCount) {

    // If we have reached the end of string.
    if (index == s.length()) {

      // If the current expression is valid.
      if (leftCount == rightCount) {

        // If the current count of removed parentheses is <= the current minimum count
        if (removedCount <= this.minimumRemoved) {

          // Convert StringBuilder to a String. This is an expensive operation.
          // So we only perform this when needed.
          String possibleAnswer = expression.toString();

          // If the current count beats the overall minimum we have till now
          if (removedCount < this.minimumRemoved) {
            this.validExpressions.clear();
            this.minimumRemoved = removedCount;
          }
          this.validExpressions.add(possibleAnswer);
        }
      }
    } else {

      char currentCharacter = s.charAt(index);
      int length = expression.length();

      // If the current character is neither an opening bracket nor a closing one,
      // simply recurse further by adding it to the expression StringBuilder
      if (currentCharacter != '(' && currentCharacter != ')') {
        expression.append(currentCharacter);
        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
        expression.deleteCharAt(length);
      } else {

        // Recursion where we delete the current character and move forward
        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
        expression.append(currentCharacter);

        // If it's an opening parenthesis, consider it and recurse
        if (currentCharacter == '(') {
          this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
        } else if (rightCount < leftCount) {
          // For a closing parenthesis, only recurse if right < left
          this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
        }

        // Undoing the append operation for other recursions.
        expression.deleteCharAt(length);
      }
    }
  }
}
