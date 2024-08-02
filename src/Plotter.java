import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Plotter {
    public static void commandsInteractive() {
        String[] cmd = new String[9];
        cmd[0] = "reset\n";
        cmd[1] = "set terminal pngcairo size 1000,500\n";
        cmd[2] = "set output 'grafico.png'\n";
        cmd[3] = "set datafile separator ';'\n";
        cmd[4] = "set title 'Propagação de uma notícia falsa'\n";
        cmd[5] = "set xlabel 'Número de dias'\n";
        cmd[6] = "set ylabel 'População'\n";
        cmd[7] = "plot '.\\ficheiroResultado.csv' every ::1 using 1:2 smooth bezier lw 4 title 'S','.\\ficheiroResultado.csv' every ::1 using 1:3 smooth bezier lw 4 title 'I' ,'.\\ficheiroResultado.csv' every ::1 using 1:4 smooth bezier lw 4 title 'R'\n";
        cmd[8] = "exit";
        graphic(cmd);
    }
    public static void commandsNonInteractive(String[] names, int i) {
        String[] cmd = new String[9];
        String nonInteractiveFileName = FileHandler.generateNICSVFiles(names, i);
        cmd[0] = "reset\n";
        cmd[1] = "set terminal pngcairo size 1000,500\n";
        cmd[2] = "set output 'grafico" + names[i] + ".png'\n";
        cmd[3] = "set datafile separator ';'\n";
        cmd[4] = "set title 'Propagação de uma notícia falsa'\n";
        cmd[5] = "set xlabel 'Número de dias'\n";
        cmd[6] = "set ylabel 'População'\n";
        cmd[7] = "plot '.\\" + nonInteractiveFileName + "' every ::1 using 1:2 smooth bezier lw 4 title 'S','.\\" + nonInteractiveFileName + "' every ::1 using 1:3 smooth bezier lw 4 title 'I' ,'.\\" + nonInteractiveFileName + "' every ::1 using 1:4 smooth bezier lw 4 title 'R'\n";
        cmd[8] = "exit";
        graphic(cmd);
    }
    private static void graphic(String[] cmd) {
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c gnuplot.exe");
            OutputStream outputStream = process.getOutputStream();
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            for (int i = 0; i < cmd.length; i++) {
                printWriter.println(cmd[i]);
                printWriter.flush();
            }
            printWriter.close();
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }
}
