import java.awt.*;
import java.util.*;

public class Husky extends Critter {
    private Random r;
    private Color newColor;
    private int moveCount;
    private int redValue;
    private int greenValue;
    private int blueValue;


    public Husky() {
        r = new Random();
    }

    public Color getColor() {
        redValue = r.nextInt(255);
        greenValue = r.nextInt(255);
        blueValue = r.nextInt(255);
        newColor = new Color(redValue, greenValue, blueValue);
        return newColor;
    }

    public String toString() {
        return "H";
    }

    public Attack fight(String opponent) {
        int code = r.nextInt(3);
        if (code == 0) {
            return Attack.POUNCE;
        } else if (code == 1) {
            return Attack.SCRATCH;
        } else { // (code == 2)
            return Attack.ROAR;
        }
    }

    public Direction getMove() {
        moveCount++;
        int code = r.nextInt(4);

        if (moveCount % 3 == 0) {
            return Direction.CENTER;
        }

        if (code == 0) {
            return Direction.NORTH;
        } else if (code == 1) {
            return Direction.SOUTH;
        } else if (code == 2) {
            return Direction.EAST;
        } else {
            return Direction.WEST;
        }
    }
}
