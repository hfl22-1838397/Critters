import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
    private int hungerMax; // the maximum amount a hippo can eat
    private int eatCount; // the amount that a hippo already ate
    private int moveCount; // count the number of moves
    private Direction initialDirection; // the first direction that the hippo faces to
    private Random r; // for random activity in the program

    // Construct a hippo
    // int hunger - the amount a hippo can eat, equals to hungerMax
    public Hippo(int hunger){
        r = new Random();
        hungerMax = hunger;
        initialDirection = getRandomDirection();
    }

    // returns whether or not a hippo eats
    // eat (returns true) when eatCount is less than hungerMax
    // not eat (returns false) otherwise
    // also track how many the hippo has already eaten
    public boolean eat() {
        if(eatCount >= hungerMax){
            return false;
        }
        eatCount++;
        return true;
    }

    // returns the string representation of the hippo
    // represent as a number that shows how much more this hippo can eat
    public String toString() {
        int diff = hungerMax - eatCount;
        if (diff < 0){
            diff = 0;
        }
        return "" + diff;
    }

    // return the color the hippo should appear
    // returns gray when it hasn't eaten enough, white otherwise
    public Color getColor() {
        if(eatCount < hungerMax){
            return Color.GRAY;
        }
        return Color.WHITE;
    }


    // returns the attack a hippo should use when fighting
    // when it hasn't eaten enough, returns scratch, otherwise returns pounce
    public Attack fight(String opponent) {
        if(eatCount <= hungerMax){
            return Attack.SCRATCH;
        }
        return Attack.POUNCE;
    }

    // returns a random direction from those four
    public Direction getRandomDirection() {
        int index = r.nextInt(4);

        if(index == 0){
            return Direction.NORTH;
        } else if (index == 1){
            return Direction.SOUTH;
        } else if (index == 2){
            return Direction.EAST;
        } else {
            return Direction.WEST;
        }
    }

    // returns the direction the hippo should move
    // hippo moves in one direction for five times then changes into a randomly new one
    public Direction getMove() {
        moveCount++;
        if(moveCount == 6){
            //return the changed direction
            moveCount = 1;
            initialDirection = getRandomDirection();
            return initialDirection;
        }
        //return the same direction
        return initialDirection;
    }
}
