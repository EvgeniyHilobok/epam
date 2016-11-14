package by.epam.airline.factory;

import by.epam.airline.entity.Plane;
import by.epam.airline.entity.airliner.PassengerPlane;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.exceptions.PlaneTechnicalException;
import org.w3c.dom.Element;

public class PassengerPlaneCreator implements AirlineFactory {
    public Plane createPlane(Element element) throws PlaneLogicException, PlaneTechnicalException {
        return new PassengerPlane(DOM_PARSER_XML.purchasePassengerPlane(element));
    }
}
