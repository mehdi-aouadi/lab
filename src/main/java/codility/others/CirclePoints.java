package codility.others;

import java.util.HashSet;
import java.util.Set;

public class CirclePoints {

  public static int countPoints(String s, int[] x, int[] y) {
    Set<Character> included = new HashSet<>();
    int radius = 1;
    while(included.size() < s.length()) {
      for(int index=0; index<s.length(); index++) {
        Character current = s.charAt(index);
        if(included.contains(current)) {
          return included.size();
        } else {
          addToCircle(current, radius, x[index], y[index], included);
        }
      }
      radius++;
    }

    return included.size();
  }

  private static void addToCircle(Character element,int radius, int x, int y, Set<Character> included) {
    if(Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius, 2)) {
      included.add(element);
    }
  }
}
