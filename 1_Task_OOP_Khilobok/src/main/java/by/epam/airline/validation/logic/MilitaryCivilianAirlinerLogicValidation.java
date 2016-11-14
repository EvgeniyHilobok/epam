package by.epam.airline.validation.logic;

import by.epam.airline.constants.ExceptionConstants;
import by.epam.airline.constants.ValueParametersConstants;
import by.epam.airline.exceptions.PlaneLogicException;

public class MilitaryCivilianAirlinerLogicValidation {
    public void runLengthLogicValidation(double runLength) throws PlaneLogicException {
        if (runLength <= ValueParametersConstants.MIN_RUN_LENGTH_VALUE ||
                runLength >= ValueParametersConstants.MAX_RUN_LENGTH_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.RUN_LENGTH_LOGIC_EXCEPTION);
        }
    }

    public void maximumTakeOffWeightLogicValidation(double maximumTakeOffWeight) throws PlaneLogicException {
        if (maximumTakeOffWeight >= ValueParametersConstants.MAX_TAKE_OFF_WEIGHT_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.TAKE_OFF_WEIGHT_LOGIC_EXCEPTION);
        }
    }
}
