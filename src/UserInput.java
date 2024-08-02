
import java.util.Scanner;
public class UserInput {

    public static int initialPopulationSize;
    public static int numberOfDays;
    public static float h;
    public static String chosenName;
    public static int option;
    public static Scanner read = new Scanner(System.in);

    public static void interactiveQuestions(String[] names) {
        System.out.println("What is the size of the population under study?");
        initialPopulationSize = read.nextInt();
        while (initialPopulationSize < 1) {
            System.out.println("Please enter a valid number.");
            initialPopulationSize = read.nextInt();
        }
        System.out.println("For how many days would you like to track the evolution of the model variables?");
        numberOfDays = read.nextInt();
        while (numberOfDays < 1) {
            System.out.println("Please enter a valid number.");
            numberOfDays = read.nextInt();
        }
        System.out.println("What integration step should be used? Between 0 and 1.");
        h = read.nextFloat();
        while (h <= 0 || h >= 1) {
            System.out.println("Please enter a valid number.");
            h = read.nextFloat();
        }
        read.nextLine();
        System.out.println("Which set of parameters would you like to use? Introduce the name of the set.");
        chosenName = read.nextLine();
        while (readChosenLine(names) < 0) {
            System.out.println("Please enter a valid name.");
            chosenName = read.nextLine();
        }
        System.out.println("Choose a numerical method. Enter 1 for Euler and 2 for 4th order Runge-Kutta.");
        option = read.nextInt();
        while (option != 1 && option != 2) {
            System.out.println("Please enter a valid number.");
            option = read.nextInt();
        }
    }

    public static int readChosenLine(String[] names) {
        int chosenLine;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(chosenName)) {
                chosenLine = i;
                return chosenLine;
            }
        }
        return -1;
    }
}
