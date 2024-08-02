
import java.util.Scanner;
public class UserInput {

    public static int initialPopulationSize;
    public static int numberOfDays;
    public static float h;
    public static String chosenName;
    public static int option;
    public static Scanner read = new Scanner(System.in);

    public static void interactiveQuestions(String[] names) {
        System.out.println("Qual é o tamanho da população em estudo?");
        initialPopulationSize = read.nextInt();
        while (initialPopulationSize < 1) {
            System.out.println("Por favor, insira um número válido.");
            initialPopulationSize = read.nextInt();
        }
        System.out.println("Durante quantos dias pretende saber a evolução das variáveis do modelo?");
        numberOfDays = read.nextInt();
        while (numberOfDays < 1) {
            System.out.println("Por favor, insira um número válido.");
            numberOfDays = read.nextInt();
        }
        System.out.println("Qual o passo de integração a usar? Entre 0 e 1.");
        h = read.nextFloat();
        while (h <= 0 || h >= 1) {
            System.out.println("Por favor, insira um número válido.");
            h = read.nextFloat();
        }
        read.nextLine();
        System.out.println("Que conjunto de parâmetros pretende utilizar?");
        chosenName = read.nextLine();
        while (readChosenLine(names) < 0) {
            System.out.println("Por favor, insira um nome válido.");
            chosenName = read.nextLine();
        }
        System.out.println("Escolha um método numérico. Insira 1 para Euler e 2 para Runge-Kutta de 4ª ordem.");
        option = read.nextInt();
        while (option != 1 && option != 2) {
            System.out.println("Por favor, insira um número válido.");
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
