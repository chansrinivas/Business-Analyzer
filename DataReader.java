package business_analyzer_assignment;
import java.io.*;
import java.util.Scanner;

public class DataReader {
    /**
     * Method that reads data into particular data structures - AL/LL
     * @param dataFile The input csv file that needs to be read
     * @param dataStructure AL or LL
     * @return List of entities
     * @throws FileNotFoundException If wrong file is given
     */
    public static List<Entities> reader(String dataFile, String dataStructure) throws FileNotFoundException {
        List<Entities> businesses = null;

        //Try catch block implementation if file not found exception arises
        try {
            Scanner scanner = new Scanner (new File(dataFile));
            if (dataStructure.equals("LL")) {
                businesses = new LinkedList<>();
            }
            else if (dataStructure.equals("AL")) {
                businesses = new ArrayList<>();
            }
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
                Entities business = new Entities(fields[14],fields[8], fields[9], fields[16], fields[17], fields[23]);
                assert businesses != null;
                businesses.add(business);
            }
        }

        catch (FileNotFoundException fnfe) {
            System.err.println("Error: File not found!");
        }
        return businesses;
    }
}
