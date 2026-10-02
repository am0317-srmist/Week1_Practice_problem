
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
                (player.equals("Paper") && computer.equals("Rock")) ||
                (player.equals("Scissors") && computer.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player | Computer | Result");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Rock, Paper, or Scissors: ");
            String player = sc.next();

            if (!player.equalsIgnoreCase("Rock") &&
                    !player.equalsIgnoreCase("Paper") &&
                    !player.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move. Try again.");
                i--;
                continue;
            }

            player = player.substring(0, 1).toUpperCase()
                    + player.substring(1).toLowerCase();

            String computer = moves[random.nextInt(3)];
            String result = playRound(player, computer);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println(i + " | " + player + " | "
                    + computer + " | " + result);
        }

        double percentage = wins * 100.0 / 5;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", percentage);

        sc.close();
    }
}