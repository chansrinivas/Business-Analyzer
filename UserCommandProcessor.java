package business_analyzer_assignment;
import java.util.*;

public class UserCommandProcessor {

    /**
     * Method processes the Summary by ZipCode summary to output total businesses, neighborhoods and business types
     * @param substring The user command - Zipcode
     * @param naicsCodeMap Hashmap of key value pairs for NAICS codes
     */
    public static void processZipCommand(String substring, Map<String, business_analyzer_assignment.List<Entities>> naicsCodeMap) {
        business_analyzer_assignment.List<Entities> businesses;
        int total_businesses=0;
        business_analyzer_assignment.List<String> neighborhoods = new business_analyzer_assignment.ArrayList<>();
        business_analyzer_assignment.List<String> busTypes = new business_analyzer_assignment.ArrayList<>();
        String location;

        for(Map.Entry<String, business_analyzer_assignment.List<Entities>> entry: naicsCodeMap.entrySet()){
             businesses = entry.getValue();
            for (int i = 0; i< businesses.size();i++)    {
                Entities business = businesses.get(i);
                if (business.zipcode.startsWith(substring)) {
                    total_businesses++;

                    location = business.neighbourhood;
                    if (!neighborhoods.contains(location)) {
                        neighborhoods.add(location);
                    }

                    if(!busTypes.contains(business.businessType)){
                        busTypes.add(business.businessType);
                    }
                }
            }
        }

        System.out.println("Total Businesses: " + total_businesses);
        System.out.println("Business types: " + busTypes.size());
        System.out.println("Neighborhood: " + neighborhoods.size());
    }

    /**
     * Method processes the Summary by Naics code summary to output total businesses, neighborhoods and zipcodes
     * @param substring The user command - NAICS code
     * @param naicsCodeMap Hashmap of key value pairs for NAICS codes
     */
    public static void processNAICSCommand(String substring, Map<String, business_analyzer_assignment.List<Entities>> naicsCodeMap) {
        business_analyzer_assignment.List<Entities> businesses;
        int total_businesses=0;
        business_analyzer_assignment.List<String> neigh = new business_analyzer_assignment.ArrayList<>();
        business_analyzer_assignment.List<String> zip =new ArrayList<>();
        String naicsrange;
        int val = Integer.parseInt(substring);
        try {
            for (Map.Entry<String, business_analyzer_assignment.List<Entities>> entry : naicsCodeMap.entrySet()) {
                businesses = entry.getValue();
                for (int i = 0; i< businesses.size();i++)    {
                    Entities business = businesses.get(i);

                    int num1 = 0, num2 = 0;
                    if(business.NAICS.length()>0) {

                        naicsrange = business.NAICS;
                        String[] arr = naicsrange.split("-");

                        if (arr.length == 2) {
                            num1 = Integer.parseInt(arr[0]);
                            num2 = Integer.parseInt(arr[1]);
                        }
                        if (arr.length == 1) {
                            num1 = Integer.parseInt(arr[0]);
                            num2 = num1;
                        }

                        if (val >= num1 && val <= num2) {
                            total_businesses++;

                            if (!neigh.contains(business.neighbourhood)) {
                                neigh.add(business.neighbourhood);
                            }

                            if (!zip.contains(business.zipcode)) {
                                zip.add(business.zipcode);
                            }
                        }
                    }
                }
            }
        }
        catch(NumberFormatException nfe){
            System.out.println("error");
        }
        System.out.println("Total Businesses: " + total_businesses);
        System.out.println("Zipcode: " + zip.size());
        System.out.println("Neighborhood: " + neigh.size());
    }

    /**
     * Method that processes the Summary to output total businesses, new businesses and close businesses
     * @param businesses List of entities
     */
    public static void processSummaryCommand(business_analyzer_assignment.List<Entities> businesses) {
        int closedBusinesses=0;
        int newBusinessesLastYear=0;

        for(int i=0; i<businesses.size(); i++){
            if(businesses.get(i).endDate.length()>0){
                closedBusinesses++;
            }

            if(businesses.get(i).startDate.endsWith("2022")){
                newBusinessesLastYear++;
            }
        }

        System.out.println("Total Businesses: " + businesses.size());
        System.out.println("Closed Businesses: " + closedBusinesses);
        System.out.println("New Businesses in last year: " + newBusinessesLastYear);
    }

    /**
     * Method gives a History of all previous commands
     * @param commandHistory List to store all previous commands
     */
    public static void processHistoryCommand(List<String> commandHistory) {
        for(int i=0; i<commandHistory.size(); i++){
            String element=commandHistory.get(i);
            System.out.println(element);
        }
    }
}
