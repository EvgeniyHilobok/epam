package by.epam.airline.factory;

import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.exceptions.PlaneTechnicalException;
import by.epam.airline.parser.DOMParserXMLImpl;
import org.w3c.dom.Element;

public interface AirlineFactory {
    DOMParserXMLImpl DOM_PARSER_XML = new DOMParserXMLImpl();

    Plane createPlane(Element element) throws PlaneLogicException, PlaneTechnicalException;
}
