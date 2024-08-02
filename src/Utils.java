public class Utils {
    public static int initialPopulationSize;
    public static int numberOfDays;
    public static double h;
    public static int option;

    public static String choosingMethod(int option) {
        String methodName;
        switch (option) {
            case 1:
                methodName = "Euler";
                break;
            case 2:
                methodName = "RK4";
                break;
            default:
                return "";
        }
        return methodName;
    }
    public static void readNIMethod(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i - 1].equals("-m")) {
                option = Integer.parseInt(args[i]);
            }
        }
    }
    public static void readNIh(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i - 1].equals("-p")) {
                h = Double.parseDouble(args[i]);
            }
        }
    }
    public static void readNIpopulationSize(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i - 1].equals("-t")) {
                initialPopulationSize = Integer.parseInt(args[i]);
            }
        }
    }
    public static void readNInumberOfDays(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i - 1].equals("-d")) {
                numberOfDays = Integer.parseInt(args[i]);
            }
        }
    }
}
