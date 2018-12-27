import java.awt.*;

public class Bird extends Critter {

    private int counter; // to count the number of moves
    private int index; // represent a direction and is used for conversion
    private Direction lastMove; // the last direction that the bird goes to

    // a bird is always blue so the method returns color blue
    public Color getColor() {
        return Color.BLUE;
    }

    // pass the String opponent so the object knows what the bird fights against
    // when fighting against an ant ("%"), return Roar
    // otherwise return Pounce
    public Attack fight(String opponent) {
        if(opponent.equals("%")){
            return Attack.ROAR;
        }
        return Attack.POUNCE;
    }

    // pass an int index and different index represents a different direction
    // return the direction that particular index represents
    public Direction convert(int index){
        if(index == 0){
            return Direction.NORTH;
        } else if (index == 1){
            return Direction.EAST;
        } else if (index == 2){
            return Direction.SOUTH;
        } else { // (index == 3)
            return Direction.WEST;
        }
    }

    // a bird moves clockwise and for three steps in each direction
    // when the counter reaches three, bird changes to the next direction
    // return the corresponding direction
    public Direction getMove() {
        counter++;
        if (counter == 4){
            index++;
            counter = 1;
            if(index > 3){
                index = 0;
            }
            return convert(index);
        }
        return convert(index);
    }

    // returns the string representation of a bird (depending on bird's moving direction)
    public String toString() {
        lastMove = convert(index);
        if(lastMove == Direction.NORTH || lastMove == Direction.CENTER){
            return "^";
        } else if (lastMove == Direction.EAST){
            return ">";
        } else if (lastMove == Direction.SOUTH){
            return "V";
        } else {
            return "<";
        }
    }
}
