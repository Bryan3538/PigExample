import java.util.Iterator;

/**
 * Created by Bryan on 11/8/2015.
 */
public interface MultiDice extends Dice {
    public Iterable<Integer> getValues();
    public int size();
}
