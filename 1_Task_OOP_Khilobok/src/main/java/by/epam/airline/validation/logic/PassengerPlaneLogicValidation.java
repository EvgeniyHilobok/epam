package by.epam.airline.validation.logic;

import by.epam.airline.constants.ExceptionConstants;
import by.epam.airline.constants.ValueParametersConstants;
import by.epam.airline.exceptions.PlaneLogicException;

public class PassengerPlaneLogicValidation {
    public void manufacturerCountryLogicValidation(String manufacturerCountry) throws PlaneLogicException {
        if (manufacturerCountry.equals(ValueParametersConstants.EMPTY_STRING)) {
            throw new PlaneLogicException(ExceptionConstants.MANUFACTURER_COUNTRY_LOGIC_EXCEPTION);
        }
    }

    public void planeClassLogicValidation(String planeClass) throws PlaneLogicException {
        if (planeClass.equals(ValueParametersConstants.EMPTY_STRING)) {
            throw new PlaneLogicException(ExceptionConstants.PLANE_CLASS_LOGIC_EXCEPTION);
        }
    }

    public void averageCostOfFlightLogicValidation(double averageCostOfFlight) throws PlaneLogicException {
        if (averageCostOfFlight <= ValueParametersConstants.MIN_AVERAGE_COST_OF_FLIGHT_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.AVERAGE_COST_OF_FLIGHT_LOGIC_EXCEPTION);
        }
    }
}
