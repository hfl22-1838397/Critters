import java.awt.*;

public class Vulture extends Bird {
    private boolean hungry; // determine whether the vulture is hungry

    // Constructs a vulture
    // it is always hungry initially (hungry is true)
    public Vulture(){
        hungry = true;
    }

    // return the color the vulture should appear (always black)
    public Color getColor() {
        return Color.BLACK;

    }

    // returns the attack a vulture should use when fighting
    // when it fights it becomes hungry (hungry turns true)
    public Attack fight(String opponent) {
        hungry = true;// if fights one or more time, hungry
        return super.fight(opponent);
    }

    // returns whether or not the vulture should eat
    // if it is hungry, it eats and it becomes not hungry (hungry is false)
    // it never eats (returns false initially) if it is not hungry
    public boolean eat() {
        if(hungry){
            hungry = false;// if eats, non-hungry
            return true;
        }
        return false;
    }
}
