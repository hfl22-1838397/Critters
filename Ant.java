import java.awt.*;

public class Ant extends Critter {
    private boolean walkSouth; // to determine if the ant goes south or north
    private int counter; // count the number of moves.

    // construct an ant
    // pass a boolean walkSouth to determine this ant's direction
    public Ant(boolean walkSouth){
        this.walkSouth = walkSouth;
    }

    // the ant is always red so it returns Color red.
    public Color getColor() {
        return Color.RED;
    }

    // returns the attack an ant should use when fighting (always scratch)
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

    // returns the string representation of an ant (always "S")
    public String toString() {
        return "%";
    }

    // an ant's movement - changing south (or north) and east alternatively
    // return south (or north) when the counter is even
    // return east when the counter is odd
    public Direction getMove() {
        counter++;
        if(counter % 2 != 0) {
            if (walkSouth) {
                return Direction.SOUTH;
            } else {
                return Direction.NORTH;
            }
        }else {
            return Direction.EAST;
        }
    }
}
