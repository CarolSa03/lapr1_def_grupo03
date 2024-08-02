public class SIRModel {
    public static double beta;
    public static double gamma;
    public static double rho;
    public static double alpha;
    public static double initialSusceptible;
    public static double initialInfected;
    public static double initialRecovered;
    public static double initialPopulationSize;
    public static int numberOfDays;
    public static double h;

    public static double[][] Euler() {
        double susceptible = initialSusceptible;
        double infected = initialInfected;
        double recovered = initialRecovered;
        double populationSize = initialPopulationSize;
        double oldSusceptible = susceptible;
        double oldInfected = infected;
        double oldRecovered = recovered;
        double[][] results = new double[numberOfDays][5];
        for (int i = 0; i < numberOfDays; i++) {
            results[i][0] = i;
            results[i][1] = susceptible;
            results[i][2] = infected;
            results[i][3] = recovered;
            results[i][4] = populationSize;
            for (int j = 0; j < 1 / h; j++) {
                susceptible += h * functionS(oldSusceptible, oldInfected);
                infected += h * functionI(oldSusceptible, oldInfected, oldRecovered);
                recovered += h * functionR(oldSusceptible, oldInfected, oldRecovered);
                oldSusceptible = susceptible;
                oldInfected = infected;
                oldRecovered = recovered;
            }
            populationSize = susceptible + infected + recovered;
        }
        return results;
    }
    public static double[][] RK4() {
        double susceptible = initialSusceptible;
        double infected = initialInfected;
        double recovered = initialRecovered;
        double populationSize = initialPopulationSize;
        double[][] results = new double[numberOfDays][5];
        double[][] kSIR = new double[5][3];
        for (int i = 0; i < numberOfDays; i++) {
            results[i][0] = i;
            results[i][1] = susceptible;
            results[i][2] = infected;
            results[i][3] = recovered;
            results[i][4] = populationSize;
            for (int j = 0; j < 1 / h; j++) {
                calculationOfK(kSIR, susceptible, infected, recovered);
                susceptible += kSIR[4][0];
                infected += kSIR[4][1];
                recovered += kSIR[4][2];
            }
            populationSize = susceptible + infected + recovered;
        }
        return results;
    }

    public static void calculationOfK(double[][] kSIR, double susceptible, double infected, double recovered) {
        kSIR[0][0] = h * functionS(susceptible, infected);
        kSIR[0][1] = h * functionI(susceptible, infected, recovered);
        kSIR[0][2] = h * functionR(susceptible, infected, recovered);
        double k1S = susceptible + kSIR[0][0] / 2;
        double k1I = infected + kSIR[0][1] / 2;
        double k1R = recovered + kSIR[0][2] / 2;
        kSIR[1][0] = h * functionS(k1S, k1I);
        kSIR[1][1] = h * functionI(k1S, k1I, k1R);
        kSIR[1][2] = h * functionR(k1S, k1I, k1R);
        double k2S = susceptible + kSIR[1][0] / 2;
        double k2I = infected + kSIR[1][1] / 2;
        double k2R = recovered + kSIR[1][2] / 2;
        kSIR[2][0] = h * functionS(k2S, k2I);
        kSIR[2][1] = h * functionI(k2S, k2I, k2R);
        kSIR[2][2] = h * functionR(k2S, k2I, k2R);
        double k3S = susceptible + kSIR[2][0];
        double k3I = infected + kSIR[2][1];
        double k3R = recovered + kSIR[2][2];
        kSIR[3][0] = h * functionS(k3S, k3I);
        kSIR[3][1] = h * functionI(k3S, k3I, k3R);
        kSIR[3][2] = h * functionR(k3S, k3I, k3R);
        kSIR[4][0] = (kSIR[0][0] + 2 * kSIR[1][0] + 2 * kSIR[2][0] + kSIR[3][0]) / 6;
        kSIR[4][1] = (kSIR[0][1] + 2 * kSIR[1][1] + 2 * kSIR[2][1] + kSIR[3][1]) / 6;
        kSIR[4][2] = (kSIR[0][2] + 2 * kSIR[1][2] + 2 * kSIR[2][2] + kSIR[3][2]) / 6;
    }

    public static double functionS(double susceptible, double infected) {
        return -beta * susceptible * infected;
    }

    public static double functionI(double susceptible, double infected, double recovered) {
        return rho * beta * susceptible * infected - gamma * infected + alpha * recovered;
    }

    public static double functionR(double susceptible, double infected, double recovered) {
        return gamma * infected - alpha * recovered + (1 - rho) * beta * susceptible * infected;
    }
}
