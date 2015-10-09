/**
 * Created by Bryan on 10/9/2015.
 */
public class Player {


    private String name;
    private int score;

    public Player() {
        name = "Player";
        score = 0;
    }

    public Player(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
