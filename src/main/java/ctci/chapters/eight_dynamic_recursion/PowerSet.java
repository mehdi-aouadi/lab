package ctci.chapters.eight_dynamic_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Power Set: Write a method to return all subsets of a set.
 *
 */
public class PowerSet {

  public static List<List<Integer>> subSets(List<Integer> set) {
    List<List<Integer>> subSets = new ArrayList<>();
    if(set.isEmpty()) {
      return subSets;
    }
    subSetsRecursive(set, subSets, 0);
    return subSets;
  }

  private static void subSetsRecursive(List<Integer> set, List<List<Integer>> subSets, int index) {
    if(set.size() == index) {
      subSets.add(new ArrayList<>());
    } else {
      subSetsRecursive(set, subSets, index + 1);
      List<List<Integer>> moreSubsets = new ArrayList<>();
      for(List<Integer> subSet: subSets) {
        List<Integer> newSubSet = new ArrayList<>(subSet);
        newSubSet.add(set.get(index));
        moreSubsets.add(newSubSet);
      }
      subSets.addAll(moreSubsets);
    }
  }

}
