import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataSetReader {
    private double[] data;

    public DataSetReader() {
    }

    public double[] readFile(String filename) throws IOException {

        Scanner scan = new Scanner(new File(filename));
        readData(scan);
        return data;
    }

    private void readData(Scanner in) throws BadDataException {
        if (!in.hasNextInt()) {
            throw new BadDataException("Erreur de format d'index");
        }
        int doubleNb = in.nextInt();
        int i = 0;
        data = new double[doubleNb];
        if (!in.hasNextDouble()) {
            throw new BadDataException("Erreur de format de données");
        }
        while (in.hasNextDouble()) {
            readValue(in, i);
            i++;
        }
    }
    private void readValue(Scanner in, int i) throws BadDataException {
        if(!in.hasNextDouble()){
            throw new BadDataException("Erreur de format de données");
        }
        this.data[i] = in.nextDouble();
    }
}
