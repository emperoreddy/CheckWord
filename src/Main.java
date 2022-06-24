import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static void again(String word) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("Would you like to choose another option? Y/n");
        String playAgain = input.next();
        if (playAgain.equals("Y") || playAgain.equals("y"))
            check(word);
        else System.out.println("~ Thanks for playing! ~");

    }

    private static void printChoices() {
        System.out.println("=================================");

        System.out.println("| 1. Check if it's a Palindrome |");
        System.out.println("| 2. Count vowels               |");
        System.out.println("| 3. Count letters              |");

        System.out.println("=================================");
    }

    private static void palindrome(String word) {
        StringBuilder copyOfWord = new StringBuilder(word);
        copyOfWord.reverse();

        if (copyOfWord.toString().equals(word))
            System.out.println("~ The word IS a Palindrome! :) ~");
        else
            System.out.println("~ The word IS NOT a Palindrome :( ~");
    }

    private static void countVowels(String word) {
        char[] word2 = word.toCharArray();
        char[] theVowels = {'a', 'e', 'i', 'o', 'u'};
        int count = 0;

        for (char theVowel : theVowels) {
            for (char theWord : word2) {
                if (theWord == theVowel)
                    count++;
            }
        }
        System.out.println("~ The word contains: " + count + " vowels ~");
    }

    private static void countLetters(String word) {
        char[] letters = word.toCharArray();
        int count = 0;
        for (char letter : letters) {
            count++;
        }
        System.out.println("~ The word contains: " + count + " letters ~");
    }

    private static void check(String word) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do with" + " \"" + word + "\" ?");
        Thread.sleep(500);
        printChoices();
        System.out.print("Choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                palindrome(word);
                again(word);
            }
            case 2 -> {
                countVowels(word);
                again(word);
            }
            case 3 -> {
                countLetters(word);
                again(word);
            }
            default -> System.out.println("INVALID CHOICE");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to CheckWord");
        System.out.print("Please choose your word of choice: ");
        String word = input.next();
        check(word);


    }
}