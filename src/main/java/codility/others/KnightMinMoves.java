package codility.others;

import java.util.*;

public class KnightMinMoves {

  public static class Position {
    int row;
    int col;
    public Position(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof Position
          && (this.row == ((Position) obj).row && this.col == ((Position) obj).col);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.row, this.col);
    }
  }

  public static int knightMinMoveByLevel(int row, int col) {
    Set<Position> visited = new HashSet<>();
    TreeMap<Integer, LinkedList<Position>> toVisitByLevel = new TreeMap<>();
    LinkedList<Position> initialLevel = new LinkedList<>();
    Position knightPosition = new Position(0, 0);
    Position destination = new Position(row, col);
    int level = 0;
    initialLevel.push(knightPosition);
    toVisitByLevel.put(0, initialLevel);

    while(!toVisitByLevel.isEmpty()) {
      LinkedList<Position> toVisitLevel = toVisitByLevel.get(level);
      toVisitByLevel.remove(level);

      while(!toVisitLevel.isEmpty()) {
        Position current = toVisitLevel.remove();
        if(current.equals(destination)) {
          return level;
        }

        if(visited.contains(current)) {
          continue;
        }

        visited.add(current);

        LinkedList<Position> positionByLevel = new LinkedList<>();

        addNextMoves(current.row, current.col, visited, positionByLevel);

        if(toVisitByLevel.containsKey(level+1)) {
          toVisitByLevel.get(level+1).addAll(positionByLevel);
        } else {
          toVisitByLevel.put(level+1, positionByLevel);
        }
      }
      level++;
    }
    return -1;
  }

  private static void addNextMoves(int row, int col, Set<Position> visited, LinkedList<Position> positionByLevel) {
    Position nextMove = new Position(row + 2, col + 1);
    addIfNotVisited(nextMove, positionByLevel, visited);
    nextMove = new Position(row + 1, col + 2);
    addIfNotVisited(nextMove, positionByLevel, visited);
    if(col - 1 >= 0) {
      nextMove = new Position(row + 2, col - 1);
      addIfNotVisited(nextMove, positionByLevel, visited);
    }
    if(row - 1 >= 0) {
      nextMove = new Position(row - 1, col + 2);
      addIfNotVisited(nextMove, positionByLevel, visited);
    }
    if(row - 2 >= 0) {
      nextMove = new Position(row - 2, col + 1);
      addIfNotVisited(nextMove, positionByLevel, visited);
      if(col - 1 >= 0) {
        nextMove = new Position(row - 2, col - 1);
        addIfNotVisited(nextMove, positionByLevel, visited);
      }
    }
    if(col - 2 >= 0) {
      nextMove = new Position(row + 1, col - 2);
      addIfNotVisited(nextMove, positionByLevel, visited);
      if(row - 1 >= 0) {
        nextMove = new Position(row - 1, col - 2);
        addIfNotVisited(nextMove, positionByLevel, visited);
      }
    }
  }

  private static void addIfNotVisited(Position nextMove, LinkedList<Position> positionByLevel, Set<Position> visited) {
    if(!visited.contains(nextMove)) {
      positionByLevel.add(nextMove);
    }
  }


  public static int knightMinMove(int row, int col) {
    Set<Position> visited = new HashSet<>();
    LinkedList<Position> toVisit = new LinkedList<>();
    Position knightPosition = new Position(0, 0);
    Position destination = new Position(row, col);
    int moves = 0;
    toVisit.push(knightPosition);

    while(!toVisit.isEmpty()) {
      Position current = toVisit.remove();
      if(current.equals(destination)) {
        return moves;
      }

      if(visited.contains(current)) {
        continue;
      }

      visited.add(current);

      toVisit.add(new Position(current.row + 2, current.col + 1));
      toVisit.add(new Position(current.row + 1, current.col + 2));
      if(current.col - 1 >= 0) {
        toVisit.add(new Position(current.row + 2, current.col - 1));
      }
      if(current.row - 1 >= 0) {
        toVisit.add(new Position(current.row - 1, current.col + 2));
      }
      if(current.row - 2 >= 0) {
        toVisit.add(new Position(current.row - 2, current.col + 1));
        if(current.col - 1 >= 0) {
          toVisit.add(new Position(current.row - 2, current.col - 1));
        }
      }
      if(current.col - 2 >= 0) {
        toVisit.add(new Position(current.row + 1, current.col - 2));
        if(row - 1 >= 0) {
          toVisit.add(new Position(current.row - 1, current.col - 2));
        }
      }
      moves++;
    }
    return -1;
  }

}
