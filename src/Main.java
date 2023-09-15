
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        HashMap<String, Integer> highScore = new HashMap<>();


        String choice;
        do {
            System.out.println("Välj vad du vill göra:");
            System.out.println("1. Mata in resultat");
            System.out.println("2. Visa resultat");
            System.out.println("3. Räkna ut högsta poäng och medelpoäng samt avsluta programmet");
            choice = sc.nextLine();

            if (choice.equalsIgnoreCase("1")) {

                addResult(highScore);

                System.out.println(highScore);

            } else if (choice.equalsIgnoreCase("2")) {
                printList(highScore);
            }
        } while (!choice.equalsIgnoreCase("3"));
        if(!highScore.isEmpty()) {
            System.out.println("Högsta poäng var: ");
            printList(highestResult(highScore));
            System.out.println("Medelpoängen var:");
            System.out.println(showAverage(highScore));
        }
        System.out.println("Tack för ditt deltagande.");

    }

    static void addResult(HashMap<String, Integer> highScore) {
        String name;
        int score;
        System.out.println("Ange namn: ");
        name = sc.nextLine();
        System.out.println("Ange poäng: ");
        score = sc.nextInt();
        sc.nextLine();
        highScore.put(name, score);


    }

    static void printList(HashMap<String, Integer> highScore) {

        for (String i : highScore.keySet()) {
            System.out.println(i + " - " + highScore.get(i) + " poäng");
        }
        System.out.println();

    }

    //Function to check highest result
    static HashMap<String, Integer> highestResult(HashMap<String, Integer> highScore) {
        HashMap<String, Integer> topScore =new HashMap<>();
        int topScoreNumber= Collections.max(highScore.values());
        for(String name: highScore.keySet())
            if(highScore.get(name) == topScoreNumber) {
                topScore.put(name, highScore.get(name));
            }

        return topScore;
    }



    static double showAverage(HashMap<String, Integer> highScore) {
        int total = 0;
        double average;
        for (int i : highScore.values()) {
            total = (total + i);
        }
        average = (double) total / highScore.size();
        return average;

    }
}