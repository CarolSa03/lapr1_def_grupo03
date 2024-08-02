import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

    public static int initialPopulationSize;
    public static int numberOfDays;
    public static double h;
    public static int option;

    public static String[] scanFileNames(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        scan.nextLine();
        String[] initialNames = new String[999];
        String parameters;
        String[] values;
        int x = 0;
        do {
            parameters = scan.nextLine();
            parameters = parameters.replace(",", ".");
            values = parameters.split(";");
            initialNames[x] = values[0];
            x++;
        } while (scan.hasNextLine());
        scan.close();
        String[] names = new String[x];
        System.arraycopy(initialNames, 0, names, 0, x);
        return names;
    }

    public static double[][] scanFileValues(File file, String[] names) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        scan.nextLine();
        double[][] matrix = new double[names.length][5];
        String parameters;
        String[] values;
        double valueOfAlpha, valueOfBeta, valueOfGamma, valueOfRho;
        for (int i = 0; i < names.length; i++) {
            parameters = scan.nextLine();
            parameters = parameters.replace(",", ".");
            values = parameters.split(";");
            valueOfBeta = Double.parseDouble(values[1]);
            valueOfGamma = Double.parseDouble(values[2]);
            valueOfRho = Double.parseDouble(values[3]);
            valueOfAlpha = Double.parseDouble(values[4]);
            matrix[i][1] = valueOfBeta;
            matrix[i][2] = valueOfGamma;
            matrix[i][3] = valueOfRho;
            matrix[i][4] = valueOfAlpha;
        }
        scan.close();
        return matrix;
    }

    public static String[] creatingOutputArray(String methodName, double[][] matrixEuler, double[][] matrixRK4, String[] names, String[] args, int i, boolean interactive) throws FileNotFoundException {
        String[] output = new String[numberOfDays + 1];
        if (methodName.equals("Euler")) {
            output[0] = "Dia;S;I;R;N";
            for (int j = 0; j < matrixEuler.length; j++) {
                output[j + 1] = j + ";";
                for (int k = 1; k < matrixEuler[j].length; k++) {
                    if (k < matrixEuler[j].length - 1) {
                        output[j + 1] += matrixEuler[j][k] + ";";
                    } else {
                        output[j + 1] += matrixEuler[j][k];
                    }
                }
            }
        } else if (methodName.equals("RK4")) {
            output[0] = "Dia;S;I;R;N";
            for (int j = 0; j < matrixRK4.length; j++) {
                output[j + 1] = j + ";";
                for (int k = 1; k < matrixRK4[j].length; k++) {
                    if (k < matrixRK4[j].length - 1) {
                        output[j + 1] += matrixRK4[j][k] + ";";
                    } else {
                        output[j + 1] += matrixRK4[j][k];
                    }
                }
            }
        } else {
            outputToCsvFile(creatingOutputArray(Utils.choosingMethod(option), matrixEuler, matrixRK4, names, args, i, interactive), names, i, interactive);
        }
        return output;
    }
    public static void outputToCsvFile(String[] output, String[] names, int i, boolean interactive) throws FileNotFoundException {
        File outputFile;
        if (interactive) {
            outputFile = new File(".\\ficheiroResultado.csv");
        } else {
            outputFile = new File (generateNICSVFiles(names, i));
        }
        PrintWriter printWriter = new PrintWriter(outputFile);
        for (int j = 0; j < output.length; j++) {
            printWriter.println(output[j]);
        }
        printWriter.close();
    }
    public static String generateNICSVFiles(String[] names, int i) {
        String outputFile = names[i] + "m" + option + "p" + h + "t" + initialPopulationSize + "d" + numberOfDays + ".csv";
        return outputFile;
    }
}
