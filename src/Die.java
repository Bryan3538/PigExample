import java.util.Random;

/**
 * Created by Bryan on 10/9/2015.
 */
public class Die implements Dice {

    private int numberOfSides;
    private Random rng;
    private int value;

    public Die() {
        numberOfSides = 6;
        rng = new Random(System.currentTimeMillis());
        value = 0;
    }

    public Die(int numberOfSides) {
        this();
        this.numberOfSides = numberOfSides;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int roll() {
        value = rng.nextInt((numberOfSides - 1) + 1) + 1;
        return value;
    }
}
