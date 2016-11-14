package by.epam.airline.report;

import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.AirlineException;
import by.epam.airline.validation.logic.AirlineLogicValidation;

import java.util.ArrayList;
import java.util.Iterator;

public class PrintPlaneList {

    public String printList(ArrayList<Plane> planeList) throws AirlineException {
        AirlineLogicValidation.airlineListLogicValidation(planeList);
        int i = 1;
        Iterator it = planeList.iterator();
        String airline = "";
        while (it.hasNext()) {
            airline += '\n' + Integer.toString(i) + ")" + it.next();
            i = i + 1;
        }
        return airline;
    }
}
