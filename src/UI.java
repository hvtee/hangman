import java.util.*;

public class UI {
    public static void loop() {
        System.out.println("Welcome to Hangman!");
        System.out.println();

        do {
            Hangman.game(new Words(), Hangman.getHangmanList());
        } while (checkExit());
    }

    private static boolean checkExit() {
        boolean isPlaying = true;
        try {

            do {
                Scanner scanner = new Scanner(System.in);

                System.out.println();
                System.out.println("Do you wish to play again?");
                System.out.println("Print 'y' for yes");
                System.out.println("Print 'n' for no");

                System.out.print("Choice: ");
                String result = scanner.next();
                if (Objects.equals(result, "n")) {
                    isPlaying = false;
                    break;
                } else if (Objects.equals(result, "y")) break;
                else System.out.println("Wrong choice");
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println(e);
        }

        return isPlaying;
    }
}
