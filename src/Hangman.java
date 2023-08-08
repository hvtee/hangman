import java.util.*;

public class Hangman {

    public static void game(Words words, ArrayList<String> hangmanList) {
        String word = words.getWord();
        String definition = words.getDefinition();

        Scanner scanner = new Scanner(System.in);
        List<Character> guess = new ArrayList<>();
        int attempt = 0;

        for (int i = 0; i < word.length(); i++) {
            guess.add('-');
        }


        while (attempt < 7 && !isListEqualString(guess, word)) {
            System.out.println(hangmanList.get(attempt));
            printArrayList(guess);
            System.out.println(" : " + definition);
            System.out.print("Your guess: ");

            char ch = scanner.next().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ch) {
                    guess.set(i, ch);
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("You guessed the right character!");
                System.out.println();
            } else {
                System.out.println("Wrong character");
                System.out.println();
                attempt++;
            }
        }

        System.out.println();
        System.out.println(word + ":" + definition);
    }

    private static void printArrayList(List<Character> arrayList) {
        for (char ch : arrayList) System.out.print(ch);
    }

    private static boolean isListEqualString(List<Character> arrayList, String string) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != string.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<String> getHangmanList() {
        ArrayList<String> hangmanList = new ArrayList<>();
        hangmanList.add(" +---+\n |   |\n     |\n     |\n     |\n     |\n=======");
        hangmanList.add(" +---+\n |   |\n O   |\n     |\n     |\n     |\n=======");
        hangmanList.add(" +---+\n |   |\n O   |\n |   |\n     |\n     |\n=======");
        hangmanList.add(" +---+\n |   |\n O   |\n/|   |\n     |\n     |\n=======");
        hangmanList.add(" +---+\n |   |\n O   |\n/|\\ |\n     |\n     |\n=======");
        hangmanList.add(" +---+\n |   |\n O   |\n/|\\ |\n/    |\n     |\n=======");
        hangmanList.add(" +---+\n |   |\n O   |\n/|\\ |\n/ \\ |\n     |\n=======");
        return hangmanList;
    }
}
