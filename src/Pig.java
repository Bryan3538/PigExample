import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bryan on 10/9/2015.
 */
public class Pig {
    private static final int MAX_PLAYERS = 4;
    private static final int MIN_PLAYERS = 2;

    private List<Player> players;
    private Dice dice;
    private int maxScore;
    private InputHelper in;

    public Pig() {
        players = new LinkedList<>();
        dice = new Die();
        maxScore = 100;
        in = new InputHelper();
    }

    //initialize players
    private void initializePlayers() {
        int numPlayers = in.getIntInRange("How many players are there?", MIN_PLAYERS, MAX_PLAYERS);

        String playername = "";
        for (int i = 0; i < numPlayers; i++) {
            playername = in.getLine(String.format("Player %s please enter your name.", i+1));
            players.add(new Player(playername));
        }
    }

    public void playGame() {
        char playagain = '\0';
        displayInstructions();

        do {
            takeTurns();
            playagain = in.getChar("Do you wish to play again?");
            resetGame();
        } while (!(playagain == 'n' || playagain == 'N'));

        System.out.println("Thanks for playing!");
    }

    private void displayInstructions() {
        System.out.println("----------Instructions----------");
        System.out.println("Roll Dice. Don't get a 1. First to 100 wins. Go!");
        System.out.println("----------Instructions----------\n");
    }

    private void takeTurns() {
        char rollagain = '\0';
        int tempscore;
        Player winner = null;

        if (players.isEmpty())
            initializePlayers();
        do {
            for (Player p : players) {
                rollagain = '\0';
                tempscore = 0;

                System.out.println(String.format("%s\'s turn!", p.getName()));
                System.out.println(String.format("%s currently has %d points", p.getName(), p.getScore()));

                while (!(rollagain == 'n' || rollagain == 'N')) {
                    System.out.println(String.format("You have rolled a %d.", dice.roll()));

                    if (dice.getValue() == 1) {
                        System.out.println("Sorry, but a 1 means your turn is over. You scored 0 points this round.\n");
                        tempscore = 0;
                        in.discardLine("Hit enter to continue.");
                        break;
                    } else {
                        tempscore += dice.getValue();
                        System.out.println(String.format("Your current potential score for this round is: %d.\n", tempscore));
                        rollagain = in.getChar("Do you wish to roll again (y/n)?");
                    }
                }

                p.setScore(p.getScore() + tempscore);
                displayGameStatus();
                winner = checkForWinner();
            }
        } while (winner == null);

        displayWinner(winner);
    }

    private void displayGameStatus() {
        System.out.println("-----------------------------------------");
        System.out.println("The current scores are as follows:");

        for (Player p : players) {
            System.out.println(String.format("%s:\t%d", p.getName(), p.getScore()));
        }
        System.out.println("-----------------------------------------\n");
    }

    private void displayWinner(Player winner) {
        System.out.println("*************************************************");
        System.out.println("We have a winner!!!");
        System.out.println(String.format("Congratulations %s, you have won the game of pig!", winner.getName()));
        System.out.println("*************************************************\n");
    }

    private Player checkForWinner() {
        for (Player p : players) {
            if (p.getScore() >= maxScore)
                return p;
        }
        return null; //otherwise
    }

    public void resetGame() {
        if (players != null && players.size() > 0) {
            for (Player p : players)
                p.setScore(0);

        } else {
            throw new IllegalStateException("The game must be initialized with players before it can be reset!");
        }
    }


}
