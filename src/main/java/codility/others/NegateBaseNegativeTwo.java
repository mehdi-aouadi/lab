package codility.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NegateBaseNegativeTwo {

  public static int[] negateBaseNegativeTwo(int[] numberBaseNegativeTwo) {
    int toTranslate = 0;
    for (int index = numberBaseNegativeTwo.length - 1; index >= 0; index--) {
      if(numberBaseNegativeTwo[index] == 1) {
        toTranslate+= Math.pow(-2, (numberBaseNegativeTwo.length - 1) - index);
      }
    }
    toTranslate = -toTranslate;
    List<Integer> result = new ArrayList<>();

    while(toTranslate != 0) {
      int reminder = toTranslate % -2;
      toTranslate /= -2;
      if(reminder < 0) {
        reminder += 2;
        toTranslate++;
      }
      result.add(reminder);
    }
    Collections.reverse(result);
    return result.stream().mapToInt(i->i).toArray();
  }

  public static String negativeBase(int integer, int base) {
    String result = "";
    int number = integer;
    while (number != 0) {
      int reminder = number % base;
      number /= base;
      if (reminder < 0) {
        reminder += Math.abs(base);
        number++;
      }

      result = reminder + result;
    }

    return result;
  }

}
