package by.epam.airline.factory;

import by.epam.airline.entity.Plane;
import by.epam.airline.entity.mail.MailPlane;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.exceptions.PlaneTechnicalException;
import org.w3c.dom.Element;

public class MailPlaneCreator implements AirlineFactory {
    public Plane createPlane(Element element) throws PlaneLogicException, PlaneTechnicalException {
        return new MailPlane(DOM_PARSER_XML.purchaseMailPlane(element));
    }
}
