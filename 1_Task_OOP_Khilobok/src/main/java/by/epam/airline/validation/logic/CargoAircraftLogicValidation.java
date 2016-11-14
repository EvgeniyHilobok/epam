package by.epam.airline.validation.logic;

import by.epam.airline.constants.ExceptionConstants;
import by.epam.airline.constants.ValueParametersConstants;
import by.epam.airline.exceptions.PlaneLogicException;

public class CargoAircraftLogicValidation {
    public void sizeOfCargoCompartmentLogicValidation(String sizeOfCargoCompartment) throws PlaneLogicException {
        if (sizeOfCargoCompartment.equals(ValueParametersConstants.EMPTY_STRING)) {
            throw new PlaneLogicException(ExceptionConstants.SIZE_OF_CARGO_COMPARTMENT_LOGIC_EXCEPTION);
        }
    }

    public void sizeOfCargoHatchLogicValidation(String sizeOfCargoHatch) throws PlaneLogicException {
        if (sizeOfCargoHatch.equals(ValueParametersConstants.EMPTY_STRING)) {
            throw new PlaneLogicException(ExceptionConstants.SIZE_OF_CARGO_HATCH_LOGIC_EXCEPTION);
        }
    }
}
