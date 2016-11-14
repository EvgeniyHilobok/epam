package by.epam.airline.factory;

import by.epam.airline.entity.Plane;
import by.epam.airline.entity.transport.CargoAndPassengerPlane;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.exceptions.PlaneTechnicalException;
import org.w3c.dom.Element;

public class CargoAndPassengerPlaneCreator implements AirlineFactory {
    public Plane createPlane(Element element) throws PlaneLogicException, PlaneTechnicalException {
        return new CargoAndPassengerPlane(DOM_PARSER_XML.purchaseCargoAndPassengerPlane(element));
    }
}
