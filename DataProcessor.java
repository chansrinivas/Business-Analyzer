package business_analyzer_assignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataProcessor {
    /**
     * Method that processes data based on data structure
     * @param dataFile The input csv file that needs to be read
     * @param dataStructure LL or AL
     * @return Hashmap of key value pairs where the key is the NAICS code and values are List of entities
     */
    public static Map<String, business_analyzer_assignment.List<Entities>> processor(String dataFile, String dataStructure) {
        business_analyzer_assignment.List<Entities> businesses;
        Map<String, List<Entities>> naicsMap = new HashMap<>();

        try (Scanner scanner = new Scanner (new File(dataFile))) {

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
                Entities business = new Entities(fields[14],fields[8], fields[9], fields[16], fields[17], fields[23]);
                businesses = naicsMap.get(fields[16]);
                if(businesses == null) {
                    if (dataStructure.equals("LL")) {
                        businesses = new LinkedList<>();
                        businesses.add(business);
                        naicsMap.put(fields[16], businesses);
                    }
                    else
                        if (dataStructure.equals("AL")) {
                        businesses = new ArrayList<>();
                        businesses.add(business);
                        naicsMap.put(fields[16], businesses);
                    }
                } else {
                    businesses.add(business);
                }
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return naicsMap;
    }
}
