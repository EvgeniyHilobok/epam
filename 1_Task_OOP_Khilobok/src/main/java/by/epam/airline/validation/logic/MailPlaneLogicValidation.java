package by.epam.airline.validation.logic;

import by.epam.airline.constants.ExceptionConstants;
import by.epam.airline.constants.ValueParametersConstants;
import by.epam.airline.exceptions.PlaneLogicException;

public class MailPlaneLogicValidation {
    public void costOfDeliveryLogicValidation(double costOfDelivery) throws PlaneLogicException {
        if (costOfDelivery <= ValueParametersConstants.MIN_COST_OF_DELIVERY_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.COST_OF_DELIVERY_LOGIC_EXCEPTION);
        }
    }

    public void speedDeliveryLogicValidation(double speedDelivery) throws PlaneLogicException {
        if (speedDelivery <= ValueParametersConstants.MIN_SPEED_DELIVERY_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.SPEED_DELIVERY_LOGIC_EXCEPTION);
        }
    }

    public void recipientCountryLogicValidation(String recipientCountry) throws PlaneLogicException {
        if (recipientCountry.equals(ValueParametersConstants.EMPTY_STRING)) {
            throw new PlaneLogicException(ExceptionConstants.RECIPIENT_COUNTRY_LOGIC_EXCEPTION);
        }
    }
}
