package by.epam.airline.logic;

import by.epam.airline.constants.SloganConstants;
import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.AirlineException;
import by.epam.airline.validation.logic.AirlineLogicValidation;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class PerformanceCalculation { //подсчет показателей(общая вместимость и грузоподъемность всех самолетов авиакомпании)
    private static /*final*/ Logger log = Logger.getLogger(PerformanceCalculation.class);
    private double totalNumberOfSeatsInAirline;
    private double totalCapacityInAirline;

    public PerformanceCalculation() {
        this.totalNumberOfSeatsInAirline = 0.0;
        this.totalCapacityInAirline = 0.0;
    }

    public double calculationOfTotalNumberSeats(ArrayList<Plane> planeList) throws AirlineException {
        log.info(SloganConstants.CALCULATION_NUMBER_SEATS_LOGGED_MESSAGE);
        AirlineLogicValidation.airlineListLogicValidation(planeList);
        double totalNumberOfSeats = 0.0;
        for (Plane plane : planeList) {
            totalNumberOfSeats += plane.getTotalNumberOfSeats();
        }
        setTotalNumberOfSeatsInAirline(totalNumberOfSeats);
        return getTotalNumberOfSeatsInAirline();
    }

    public double calculationOfTotalCapacity(ArrayList<Plane> planeList) throws AirlineException {
        log.info(SloganConstants.CALCULATION_CAPACITY_LOGGED_MESSAGE);
        AirlineLogicValidation.airlineListLogicValidation(planeList);
        double totalCapacity = 0.0;
        for (Plane plane : planeList) {
            totalCapacity += plane.getCapacity();
        }
        setTotalCapacityInAirline(totalCapacity);
        return getTotalCapacityInAirline();
    }

    public double getTotalNumberOfSeatsInAirline() {
        return totalNumberOfSeatsInAirline;
    }

    public void setTotalNumberOfSeatsInAirline(double totalNumberOfSeatsInAirline) {
        this.totalNumberOfSeatsInAirline = totalNumberOfSeatsInAirline;
    }

    public double getTotalCapacityInAirline() {
        return totalCapacityInAirline;
    }

    public void setTotalCapacityInAirline(double totalCapacityInAirline) {
        this.totalCapacityInAirline = totalCapacityInAirline;
    }
}
