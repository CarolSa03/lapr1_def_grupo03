import java.io.*;
import java.util.Scanner;
import java.lang.Runtime;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            File nonInteractiveFile = new File(args[0]);
            Program.nonInteractiveProgram(nonInteractiveFile, args, false);
        } else {
            File interactiveFile = new File("ficheiroSIR.csv");
            String[] names = FileHandler.scanFileNames(interactiveFile);
            Program.interactiveProgram(interactiveFile, names, args, true);
        }
    }
}