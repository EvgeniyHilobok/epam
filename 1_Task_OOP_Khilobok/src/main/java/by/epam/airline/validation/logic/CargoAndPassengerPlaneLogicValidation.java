package by.epam.airline.validation.logic;

import by.epam.airline.constants.ExceptionConstants;
import by.epam.airline.constants.ValueParametersConstants;
import by.epam.airline.exceptions.PlaneLogicException;

public class CargoAndPassengerPlaneLogicValidation {
    public void fullSpeedLogicValidation(double fullSpeed) throws PlaneLogicException {
        if (fullSpeed <= ValueParametersConstants.MIN_FULL_SPEED_VALUE ||
                fullSpeed >= ValueParametersConstants.MAX_FULL_SPEED_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.FULL_SPEED_LOGIC_EXCEPTION);
        }
    }

    public void fuelSupplyLogicValidation(double fuelSupply) throws PlaneLogicException {
        if (fuelSupply <= ValueParametersConstants.MIN_FUEL_SUPPLY_VALUE ||
                fuelSupply >= ValueParametersConstants.MAX_FUEL_SUPPLY_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.FUEL_SUPPLY_LOGIC_EXCEPTION);
        }
    }
}
