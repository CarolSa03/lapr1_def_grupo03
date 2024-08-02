import java.io.File;
import java.io.FileNotFoundException;

public class Program {
    static double alpha;
    static double beta;
    static double gamma;
    static double rho;
    static int option;
    static int initialPopulationSize;
    static int initialSusceptible;
    static int initialInfected;
    static int initialRecovered;

    public static void interactiveProgram(File interactiveFile, String[] names, String[] args, boolean interactive) throws FileNotFoundException {
        double[][] matrix = FileHandler.scanFileValues(interactiveFile, names);
        UserInput.interactiveQuestions(names);
        int chosenLine = UserInput.readChosenLine(names);
        beta = matrix[chosenLine][1];
        gamma = matrix[chosenLine][2];
        rho = matrix[chosenLine][3];
        alpha = matrix[chosenLine][4];
        program(names, args, chosenLine, interactive);
        Plotter.commandsInteractive();
    }

    public static void nonInteractiveProgram(File nonInteractiveFile, String[] args, boolean interactive) throws FileNotFoundException {
        String[] names = FileHandler.scanFileNames(nonInteractiveFile);
        double[][] matrix = FileHandler.scanFileValues(nonInteractiveFile, names);
        Utils.readNIMethod(args);
        Utils.readNIh(args);
        Utils.readNIpopulationSize(args);
        Utils.readNInumberOfDays(args);
        for (int i = 0; i < names.length; i++) {
            beta = matrix[i][1];
            gamma = matrix[i][2];
            rho = matrix[i][3];
            alpha = matrix[i][4];
            program(names, args, i, interactive);
            Plotter.commandsNonInteractive(names, i);
        }
    }

    private static void program(String[] names, String[] args, int i, boolean interactive) throws FileNotFoundException {
        initialSusceptible = initialPopulationSize - 1;
        initialInfected = 1;
        initialRecovered = 0;
        double[][] matrixEuler = SIRModel.Euler();
        double[][] matrixRK4 = SIRModel.RK4();
        FileHandler.outputToCsvFile(FileHandler.creatingOutputArray(Utils.choosingMethod(option), matrixEuler, matrixRK4, names, args, i, interactive), names, i, interactive);
    }
}
