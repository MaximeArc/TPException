import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DataAnalyser {

    public static void main(String args[]) throws IOException {

        Scanner in = new Scanner(System.in);
        DataSetReader dst = new DataSetReader();
        System.out.println("Entrez nom de fichier");
        boolean repeat=true;
        while(repeat){
            try{
                double[] db = dst.readFile("resources/" + in.nextLine() +".txt");
                System.out.println(Arrays.toString(db));
                repeat= false;
            }
            catch (FileNotFoundException | BadDataException b){
                System.out.println(b.getMessage());
                System.out.println("Entrez autre nom de fichier");
            }
        }
    }
}

