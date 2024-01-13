package business_analyzer_assignment;
import java.io.FileNotFoundException;
import java.util.*;


public class BusinessAnalyzer {
    private final business_analyzer_assignment.List<Entities> businesses;
    private final Map<String, List<Entities>> naicsMap;


    /**
     * Method that takes user command as input and invokes particular functions to calculate summary
     */
    public void executeUserCommands(){
        Scanner scanner = new Scanner (System.in);
        business_analyzer_assignment.ArrayList<String> commandHistory = new ArrayList<>();
        String command;

        do{
            System.out.print("Command: ");
            command = scanner.nextLine();

            if (! command.equalsIgnoreCase ("quit") ){
                if(! command.equalsIgnoreCase("History"))
                    commandHistory.add(command);
            }

            if (command.startsWith("Zip") || command.startsWith("zip") || command.startsWith("ZIP") ) {
                UserCommandProcessor.processZipCommand(command.substring(4, 9), naicsMap);
            }
            else if (command.startsWith("NAICS") || command.startsWith("Naics") || command.startsWith("naics")) {
                UserCommandProcessor.processNAICSCommand(command.substring(6, 10), naicsMap);
            }
            else if (command.equalsIgnoreCase("Summary")) {
                UserCommandProcessor.processSummaryCommand(businesses);
            }
            else if (command.equalsIgnoreCase("History")) {
                UserCommandProcessor.processHistoryCommand(commandHistory);
            }
        } while (! command.equalsIgnoreCase("quit"));
        scanner.close();
        }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        String flag = args[1];
        System.out.println("Reading data file...");
        BusinessAnalyzer businessAnalyzer = new BusinessAnalyzer(fileName, flag);
        System.out.println("Enter user command ");
        businessAnalyzer.executeUserCommands();
    }

    /**
     * Method that calls DataReader and DataProcessor to implement AL and LL
     * @param dataFile The input csv file that needs to be read
     * @param dataStruct AL or LL
     * @throws FileNotFoundException If wrong file is passed as arguments
     */
    public BusinessAnalyzer(String dataFile, String dataStruct) throws FileNotFoundException {
        businesses = DataReader.reader(dataFile, dataStruct);
        naicsMap = DataProcessor.processor(dataFile, dataStruct);
    }
}


