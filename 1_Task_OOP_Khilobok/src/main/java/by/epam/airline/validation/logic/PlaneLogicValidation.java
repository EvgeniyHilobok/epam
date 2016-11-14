package by.epam.airline.validation.logic;

import by.epam.airline.constants.ExceptionConstants;
import by.epam.airline.constants.ValueParametersConstants;
import by.epam.airline.exceptions.PlaneLogicException;

public class PlaneLogicValidation {
    public void idLogicValidation(long id) throws PlaneLogicException {
        if (id <= ValueParametersConstants.MIN_ID_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.ID_LOGIC_EXCEPTION);
        }
    }

    public void modelLogicValidation(String model) throws PlaneLogicException {
        if (model.equals(ValueParametersConstants.EMPTY_STRING)) {
            throw new PlaneLogicException(ExceptionConstants.MODEL_LOGIC_EXCEPTION);
        }
    }

    public void engineLogicValidation(String engine) throws PlaneLogicException {
        if (engine.equals(ValueParametersConstants.EMPTY_STRING)) {
            throw new PlaneLogicException(ExceptionConstants.ENGINE_LOGIC_EXCEPTION);
        }
    }

    public void numberOfSeatsLogicValidation(int totalNumberOfSeats) throws PlaneLogicException {
        if (totalNumberOfSeats <= ValueParametersConstants.MIN_NUMBER_SEATS_VALUE ||
                totalNumberOfSeats >= ValueParametersConstants.MAX_NUMBER_SEATS_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.NUMBER_OF_SEATS_LOGIC_EXCEPTION);
        }
    }

    public void capacityLogicValidation(double capacity) throws PlaneLogicException {
        if (capacity <= ValueParametersConstants.MIN_CAPACITY_VALUE ||
                capacity >= ValueParametersConstants.MAX_CAPACITY_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.CAPACITY_LOGIC_EXCEPTION);
        }
    }

    public void rangeOfFlightLogicValidation(double rangeOfFlight) throws PlaneLogicException {
        if (rangeOfFlight <= ValueParametersConstants.MIN_RANGE_OF_FLIGHT_VALUE ||
                rangeOfFlight >= ValueParametersConstants.MAX_RANGE_OF_FLIGHT_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.RANGE_OF_FLIGHT_LOGIC_EXCEPTION);
        }
    }

    public void hourlyFuelConsumptionLogicValidation(double hourlyFuelConsumption) throws PlaneLogicException {
        if (hourlyFuelConsumption <= ValueParametersConstants.MIN_HOURLY_FUEL_CONSUMPTION_VALUE ||
                hourlyFuelConsumption >= ValueParametersConstants.MAX_HOURLY_FUEL_CONSUMPTION_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.HOURLY_FUEL_CONSUMPTION_LOGIC_EXCEPTION);
        }
    }

    public void maximumAltitudeLogicValidation(double maximumAltitude) throws PlaneLogicException {
        if (maximumAltitude <= ValueParametersConstants.MIN_ALTITUDE_VALUE ||
                maximumAltitude >= ValueParametersConstants.MAX_ALTITUDE_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.MAXIMUM_ALTITUDE_LOGIC_EXCEPTION);
        }
    }

    public void maximumCargoVolumeLogicValidation(double maximumCargoVolume) throws PlaneLogicException {
        if (maximumCargoVolume <= ValueParametersConstants.MIN_VOLUME_VALUE ||
                maximumCargoVolume >= ValueParametersConstants.MAX_VOLUME_VALUE) {
            throw new PlaneLogicException(ExceptionConstants.MAXIMUM_CARGO_VOLUME_LOGIC_EXCEPTION);
        }
    }
}
