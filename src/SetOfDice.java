import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bryan on 11/8/2015.
 */
public class SetOfDice implements MultiDice {

    private List<Die> dice;

    /**
     *
     */
    public SetOfDice() {
        dice = new LinkedList<>();
    }

    public SetOfDice(Iterable<Die> dice) {
        this();
        for(Die d : dice) {
            this.dice.add(d);
        }
    }

    public void addDie(Die d)
    {
        dice.add(d);
    }

    @Override
    public Iterable<Integer> getValues() {
        if(dice.isEmpty()) return null;

        List<Integer> values = new LinkedList<Integer>();
        for(Die d : dice) {
            values.add(d.getValue());
        }
        return values;
    }

    @Override
    public int size() {
        return dice.size();
    }

    @Override
    public int getValue() {
        int sum = 0;

        for(Die d : dice)
            sum += d.getValue();

        return sum;
    }

    @Override
    public int roll() {
        int sum = 0;

        for(Die d : dice) {
            sum += d.roll();
        }

        return sum;
    }
}
