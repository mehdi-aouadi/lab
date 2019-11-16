package ctci.chapters.eight_dynamic_recursion;

import org.junit.Test;

import java.util.Stack;

public class HanoiTowerTest {

  @Test
  public void hanoiTowerTest() {
    HanoiTower.Tower[] towers = new HanoiTower.Tower[3];
    for (int i = 0; i < 3; i++) {
      towers[i] = new HanoiTower.Tower(i);
    }

    for (int i = 5; i > 0 ; i--) {
      towers[0].addDisk(i);
    }

    HanoiTower.moveDisk(5, towers[0], towers[1], towers[2]);

  }

}
