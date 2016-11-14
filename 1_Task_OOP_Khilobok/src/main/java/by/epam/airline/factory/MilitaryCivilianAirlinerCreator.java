package by.epam.airline.factory;

import by.epam.airline.entity.Plane;
import by.epam.airline.entity.transport.MilitaryCivilianAirliner;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.exceptions.PlaneTechnicalException;
import org.w3c.dom.Element;

public class MilitaryCivilianAirlinerCreator implements AirlineFactory {
    public Plane createPlane(Element element) throws PlaneLogicException, PlaneTechnicalException {
        return new MilitaryCivilianAirliner(DOM_PARSER_XML.purchaseMilitaryCivilianAirliner(element));
    }
}
