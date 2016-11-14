package by.epam.airline.demo;

import by.epam.airline.constants.SloganConstants;
import by.epam.airline.entity.Airline;
import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.AirlineException;
import by.epam.airline.logic.PerformanceCalculation;
import by.epam.airline.logic.PlaneFiltering;
import by.epam.airline.logic.PlaneSorting;
import by.epam.airline.report.PrintPlaneList;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Demo {
    private static /*final*/ Logger log = Logger.getLogger(Demo.class);

    public void demonstrationOfWorkProgram() {
        try {
            Airline airline = Airline.createAirline();
            Airline airlineCopy = null;
            try {
                airlineCopy = (Airline) airline.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            log.info(SloganConstants.SUCCESS_MESSAGE);
            PrintPlaneList print = new PrintPlaneList();
            ArrayList<Plane> planeList = airline.getPlaneList();
            String originalAirline = print.printList(planeList);
            log.info(SloganConstants.ORIGINAL_TEAM_MESSAGE + originalAirline);
            PerformanceCalculation performanceCalculation = new PerformanceCalculation();
            log.info(SloganConstants.OVERALL_PERFORMANCE_MESSAGE);
            double totalNumberOfSeatsInAirline = performanceCalculation.calculationOfTotalNumberSeats(planeList);
            log.info(SloganConstants.NUMBER_SEATS_MESSAGE + totalNumberOfSeatsInAirline);
            double totalCapacityInAirline = performanceCalculation.calculationOfTotalCapacity(planeList);
            log.info(SloganConstants.LOAD_CAPACITY_MESSAGE + totalCapacityInAirline);
            //если в конструктор класса PlaneSorting передается параметр true, то сортировка производится по возрастанию,
            // в противном случае по убыванию.
            PlaneSorting sortAscending = new PlaneSorting(true);
            //в метод sortingByRangeOfFlight передается копия объекта airline, чтобы исходящий объект не подвергся изменениям.
            //для клонирования объекта используется механизм клонирования и сериализации.
            ArrayList<Plane> sortAscendingList = sortAscending.sortingByRangeOfFlight(airlineCopy);
            String sortAscendingAirline = print.printList(sortAscendingList);
            log.info(SloganConstants.SORT_ASCENDING_MESSAGE + sortAscendingAirline);
            PlaneSorting sortDescending = new PlaneSorting(false);
            ArrayList<Plane> sortDescendingList = sortDescending.sortingByRangeOfFlight(airlineCopy);
            String sortDescendingAirline = print.printList(sortDescendingList);
            log.info(SloganConstants.SORT_DESCENDING_MESSAGE + sortDescendingAirline);
            PlaneFiltering filtering = new PlaneFiltering();
            double lowerBound = 1000.0;
            double upperBound = 2000.0;
            ArrayList<Plane> filteredList = filtering.filteringByHourlyFuelConsumption(planeList, lowerBound, upperBound);
            String filteringAirline = print.printList(filteredList);
            log.info(SloganConstants.FILTERING_MESSAGE + filteringAirline);
        } catch (AirlineException e) {
            log.error(e);
        }
    }
}
