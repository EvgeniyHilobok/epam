import by.epam.airline.constants.PathConstants;
import by.epam.airline.entity.Airline;
import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.AirlineException;
import by.epam.airline.logic.PlaneFiltering;
import by.epam.airline.parser.DOMParserXMLImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class AirlineTest {
    private static Airline testAirline;
    private static PlaneFiltering planeFilteringObj;

    @BeforeClass
    public static void setBeforeClass() {
        DOMParserXMLImpl domParserXML = new DOMParserXMLImpl();
        testAirline = domParserXML.parse(PathConstants.FILEPATH);
        planeFilteringObj = new PlaneFiltering();
    }

    @Test
    public void emptyFilteringTest() throws AirlineException {
        double lowerBound = 100.0, upperBound = 200.0;
        ArrayList<Plane> tempList = planeFilteringObj.filteringByHourlyFuelConsumption(testAirline.getPlaneList(), lowerBound, upperBound);
        boolean expResult = tempList.isEmpty();
        assertTrue(expResult);
    }

    @Test(expected = AirlineException.class)
    public void airlineExceptionTest() throws AirlineException {
        double lowerBound = 200.0, upperBound = 300.0;
        ArrayList<Plane> tempList = planeFilteringObj.filteringByHourlyFuelConsumption(null, lowerBound, upperBound);
        boolean expResult = tempList.isEmpty();
        assertTrue(expResult);
    }

    @Test
    public void fileFoundingTest(){
        File file = new File(PathConstants.FILEPATH);
        boolean condition = file.exists();
        assertTrue(condition);
    }
}
