package ctci.chapters.eight_dynamic_recursion;

/**
 * child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class TripleStep {

  public static int count(int stairSteps) {
    if(stairSteps <= 0) {
      return 0;
    }
    return countHelper(0, stairSteps);
  }

  public static int countHelper(int traveledSteps, int stairSteps) {
    if(traveledSteps > stairSteps) {
      return 0;
    } else if(traveledSteps == stairSteps) {
      return 1;
    } else {
      return  countHelper(traveledSteps + 1, stairSteps)
          + countHelper(traveledSteps + 2, stairSteps)
          + countHelper(traveledSteps + 3, stairSteps);
     }
  }

}
