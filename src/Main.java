import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Integer> pointsList = new ArrayList<>();
        ArrayList<String> namesList = new ArrayList<>();

        String choice;
        do {
            System.out.println("Välj vad du vill göra:");
            System.out.println("1. Mata in resultat");
            System.out.println("2. Visa resultat");
            choice= sc.nextLine();

            if(choice.equalsIgnoreCase("1")) {
                namesList.add(addNames());
                pointsList.add(addResult());
                sc.nextLine();

            }
        } while (!choice.equalsIgnoreCase("2"));
        for (int i=0;i<namesList.size();i++) {
            System.out.println(namesList.get(i) + " - " + pointsList.get(i));
        }
        showAverage(pointsList);
        getHighestNumberName(highestResult(pointsList), namesList);
    }


    static int addResult() {
        System.out.println("Ange poäng:");
        return sc.nextInt();
    }

    static String addNames() {

        System.out.println("Ange spelare:");
        return sc.nextLine();
    }
    //Function to check highest result
    static int highestResult(ArrayList<Integer> pointsList)  {
        int highestNumber=0;
        int indexNumber=0;
        for (int number : pointsList) {
            if(number>highestNumber) {
                highestNumber=number;
                indexNumber=pointsList.indexOf(number);
            }
        }
        System.out.println("Det högsta resultatet var " + highestNumber);
        return indexNumber;
    }
    static void getHighestNumberName(int indexNumber, ArrayList<String> listNames) {
        System.out.println("Det var " + listNames.get(indexNumber) + " som fick det högsta resultatet.");
    }
    static void showAverage(ArrayList<Integer> pointsList) {
        int total=0;
        double average;
        for (int i : pointsList) {
            total=(total+i);
        }
        average = (double) total / pointsList.size();
        System.out.println("Medelvärdet var " + average);
    }
}