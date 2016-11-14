package by.epam.airline.logic;

import by.epam.airline.constants.SloganConstants;
import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.AirlineException;
import by.epam.airline.validation.logic.AirlineLogicValidation;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class PlaneFiltering {
    private static /*final*/ Logger log = Logger.getLogger(PlaneFiltering.class);

    public ArrayList<Plane> filteringByHourlyFuelConsumption(ArrayList<Plane> planeList, double lowerBound, double upperBound) throws AirlineException {
        log.info(SloganConstants.FILTERING_LOGGED_MESSAGE);
        AirlineLogicValidation.airlineListLogicValidation(planeList);
        ArrayList<Plane> filteredList = new ArrayList<Plane>();
        for (Plane plane : planeList) {
            if (plane.getHourlyFuelConsumption() >= lowerBound && plane.getHourlyFuelConsumption() <= upperBound) {
                filteredList.add(plane);
            }
        }
        if (filteredList.isEmpty()) {
            log.info(SloganConstants.FILTERING_INFO_MESSAGE);
        }
        return filteredList;
    }
}
