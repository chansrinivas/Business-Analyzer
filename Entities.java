package business_analyzer_assignment;
public class Entities {
    String zipcode;
    String startDate;
    String endDate;
    String NAICS;
    String businessType;
    String neighbourhood;

    /**
     * Method initialises all entities
     * @param zc Zipcode
     * @param sd start date
     * @param ed end date
     * @param naics naics code
     * @param busType naics code description
     * @param n neighborhood
     */

    public Entities(String zc, String sd, String ed, String naics, String busType, String n) {
        zipcode = zc;
        startDate = sd;
        endDate = ed;
        NAICS = naics;
        businessType = busType;
        neighbourhood = n;
    }
}
