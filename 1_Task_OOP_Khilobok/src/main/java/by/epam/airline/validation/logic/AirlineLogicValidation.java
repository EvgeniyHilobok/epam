package by.epam.airline.validation.logic;

import by.epam.airline.constants.ExceptionConstants;
import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.AirlineException;

import java.util.ArrayList;

public class AirlineLogicValidation {
    public static void airlineListLogicValidation(ArrayList<Plane> planeList) throws AirlineException {
        if (planeList == null) {
            throw new AirlineException(ExceptionConstants.AIRLINE_LIST_EXCEPTION);
        }
    }
}
