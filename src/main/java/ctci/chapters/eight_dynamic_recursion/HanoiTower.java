package ctci.chapters.eight_dynamic_recursion;

import java.util.Stack;

/**
 *
 * Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
 * different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
 * of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following
 * constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks from the first tower to the last using Stacks.
 *
 */
public class HanoiTower {

  public static void moveDisk(int n, Tower source, Tower destination, Tower buffer) {
    if(n <= 0) {
      return;
    }
    moveDisk(n-1, source, buffer, destination);
    source.moveToTop(destination);
    moveDisk(n-1, buffer, destination, source);
  }

  public static class Tower{
    private Stack<Integer> disks;
    private int index;
    public Tower(int index) {
      this.index = index;
      this.disks = new Stack<>();
    }

    public int index() {
      return index;
    }

    public void addDisk(int disk) {
      if(this.disks.isEmpty() || this.disks.peek() > disk) {
        this.disks.add(disk);
      } else{
        throw new IllegalArgumentException(String.format(
            "Cannot add disk %d in tower %d. Disk must be smaller than %d", disk, this.index, this.disks.peek())
        );
      }
    }

    public void moveToTop(Tower destination) {
      int lastDisk = this.disks.peek();
      try{
        destination.addDisk(lastDisk);
        // Remove the disk only if the add operation succeeds
        this.disks.pop();
      } catch (IllegalArgumentException e) {
        System.out.println(
            String.format("Cannot move disk %d from tower %d to the top of tower %d.", lastDisk, this.index, destination.index)
        );
      }
    }

    public void moveDisk(int n, Tower destination, Tower buffer) {
      if(n > 0) {
        moveDisk(n-1, buffer, destination);
        moveToTop(destination);
        buffer.moveDisk(n-1, destination, this);
      }
    }
  }

}
