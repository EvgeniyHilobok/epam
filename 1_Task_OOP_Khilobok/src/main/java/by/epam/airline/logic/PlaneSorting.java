package by.epam.airline.logic;

import by.epam.airline.comparators.PlaneRangeOfFlightComparator;
import by.epam.airline.constants.SloganConstants;
import by.epam.airline.entity.Airline;
import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.AirlineException;
import by.epam.airline.validation.logic.AirlineLogicValidation;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlaneSorting {
    private static /*final*/ Logger log = Logger.getLogger(PlaneSorting.class);
    private boolean sortFlag;

    public PlaneSorting(boolean sortFlag) {
        this.sortFlag = sortFlag;
    }

    public ArrayList<Plane> sortingByRangeOfFlight(Airline airlineObj) throws AirlineException {
        log.info(SloganConstants.SORTING_LOGGED_MESSAGE);
        ArrayList<Plane> planeList = airlineObj.getPlaneList();
        AirlineLogicValidation.airlineListLogicValidation(planeList);
        Comparator<Plane> comp = new PlaneRangeOfFlightComparator(isSortFlag());
        Collections.sort(planeList, comp);
        return planeList;
    }

    public boolean isSortFlag() {
        return sortFlag;
    }
}
