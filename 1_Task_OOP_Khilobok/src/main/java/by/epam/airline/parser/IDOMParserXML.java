package by.epam.airline.parser;

import by.epam.airline.entity.Airline;

public interface IDOMParserXML {
    Airline parse(String fileName);
}
