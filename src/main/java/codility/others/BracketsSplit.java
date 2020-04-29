package codility.others;

public class BracketsSplit {

  public static int bracketsSplit(String s) {
    int count = 0;
    int consecutiveCount = 0;
    for (int index = 0; index < s.length(); index++) {
      if(s.charAt(index) == '(') {
        count++;
        consecutiveCount++;
      } else {
        consecutiveCount = 0;
      }
    }

    return count != consecutiveCount ? s.length() - count : -1;

  }

}
