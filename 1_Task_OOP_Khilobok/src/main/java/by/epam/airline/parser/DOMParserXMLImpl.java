package by.epam.airline.parser;

import by.epam.airline.constants.ExceptionConstants;
import by.epam.airline.constants.TagConstants;
import by.epam.airline.entity.Airline;
import by.epam.airline.entity.airliner.PassengerPlane;
import by.epam.airline.entity.mail.MailPlane;
import by.epam.airline.entity.transport.CargoAircraft;
import by.epam.airline.entity.transport.CargoAndPassengerPlane;
import by.epam.airline.entity.transport.MilitaryCivilianAirliner;
import by.epam.airline.exceptions.PlaneTechnicalException;
import by.epam.airline.factory.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserXMLImpl implements IDOMParserXML {
    private static /*final*/ Logger log = Logger.getLogger(DOMParserXMLImpl.class);

    public Airline parse(String fileName) {
        Airline airline = new Airline();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            FileInputStream in = new FileInputStream(new File(fileName));
            Document doc = dBuilder.parse(in, "UTF-8");
            NodeList passengerPlane = doc.getElementsByTagName(TagConstants.PASSENGER_PLANE);
            NodeList mailPlane = doc.getElementsByTagName(TagConstants.MAIL_PLANE);
            NodeList cargoAircraft = doc.getElementsByTagName(TagConstants.CARGO_AIRCRAFT);
            NodeList cargoAndPassengerPlane = doc.getElementsByTagName(TagConstants.CARGO_AND_PASSENGER_PLANE);
            NodeList militaryCivilianAirliner = doc.getElementsByTagName(TagConstants.MILITARY_CIVILIAN_AIRLINER);
            for (int i = 0; i < passengerPlane.getLength(); i++) {
                Node nNode = passengerPlane.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    PassengerPlaneCreator creator = new PassengerPlaneCreator();
                    airline.addPlane(creator.createPlane(eElement));
                }
            }
            for (int i = 0; i < mailPlane.getLength(); i++) {
                Node nNode = mailPlane.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    MailPlaneCreator creator = new MailPlaneCreator();
                    airline.addPlane(creator.createPlane(eElement));
                }
            }
            for (int i = 0; i < cargoAircraft.getLength(); i++) {
                Node nNode = cargoAircraft.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    CargoAircraftCreator creator = new CargoAircraftCreator();
                    airline.addPlane(creator.createPlane(eElement));
                }
            }
            for (int i = 0; i < cargoAndPassengerPlane.getLength(); i++) {
                Node nNode = cargoAndPassengerPlane.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    CargoAndPassengerPlaneCreator creator = new CargoAndPassengerPlaneCreator();
                    airline.addPlane(creator.createPlane(eElement));
                }
            }
            for (int i = 0; i < militaryCivilianAirliner.getLength(); i++) {
                Node nNode = militaryCivilianAirliner.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    MilitaryCivilianAirlinerCreator creator = new MilitaryCivilianAirlinerCreator();
                    airline.addPlane(creator.createPlane(eElement));
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
        return airline;
    }

    public PassengerPlane purchasePassengerPlane(Element eElement) throws PlaneTechnicalException {
        PassengerPlane passengerPlane = new PassengerPlane();
        try {
            passengerPlane.setId(Long.valueOf(eElement.getElementsByTagName(TagConstants.ID).item(0).getTextContent()));
            passengerPlane.setModel(eElement.getElementsByTagName(TagConstants.MODEL).item(0).getTextContent());
            passengerPlane.setEngine(eElement.getElementsByTagName(TagConstants.ENGINE).item(0).getTextContent());
            passengerPlane.setTotalNumberOfSeats(Integer.parseInt(eElement.getElementsByTagName(TagConstants.TOTAL_NUMBER_OF_SEATS).item(0).getTextContent()));
            passengerPlane.setCapacity(Double.valueOf(eElement.getElementsByTagName(TagConstants.CAPACITY).item(0).getTextContent()));
            passengerPlane.setRangeOfFlight(Double.valueOf(eElement.getElementsByTagName(TagConstants.RANGE_OF_FLIGHT).item(0).getTextContent()));
            passengerPlane.setHourlyFuelConsumption(Double.valueOf(eElement.getElementsByTagName(TagConstants.HOURLY_FUEL_CONSUMPTION).item(0).getTextContent()));
            passengerPlane.setMaximumAltitude(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_ALTITUDE).item(0).getTextContent()));
            passengerPlane.setManufacturerCountry(eElement.getElementsByTagName(TagConstants.MANUFACTURER_COUNTRY).item(0).getTextContent());
            passengerPlane.setPlaneClass(eElement.getElementsByTagName(TagConstants.PLANE_CLASS).item(0).getTextContent());
            passengerPlane.setAverageCostOfFlight(Double.parseDouble(eElement.getElementsByTagName(TagConstants.AVERAGE_COST_OF_FLIGHT).item(0).getTextContent()));
        } catch (NumberFormatException e) {
            throw new PlaneTechnicalException(ExceptionConstants.PASSENGER_PLANE_TECHNICAL_EXCEPTION, e);
        }
        return passengerPlane;
    }

    public MailPlane purchaseMailPlane(Element eElement) throws PlaneTechnicalException {
        MailPlane mailPlane = new MailPlane();
        try {
            mailPlane.setId(Long.valueOf(eElement.getElementsByTagName(TagConstants.ID).item(0).getTextContent()));
            mailPlane.setModel(eElement.getElementsByTagName(TagConstants.MODEL).item(0).getTextContent());
            mailPlane.setEngine(eElement.getElementsByTagName(TagConstants.ENGINE).item(0).getTextContent());
            mailPlane.setTotalNumberOfSeats(Integer.parseInt(eElement.getElementsByTagName(TagConstants.TOTAL_NUMBER_OF_SEATS).item(0).getTextContent()));
            mailPlane.setCapacity(Double.valueOf(eElement.getElementsByTagName(TagConstants.CAPACITY).item(0).getTextContent()));
            mailPlane.setRangeOfFlight(Double.valueOf(eElement.getElementsByTagName(TagConstants.RANGE_OF_FLIGHT).item(0).getTextContent()));
            mailPlane.setHourlyFuelConsumption(Double.valueOf(eElement.getElementsByTagName(TagConstants.HOURLY_FUEL_CONSUMPTION).item(0).getTextContent()));
            mailPlane.setMaximumAltitude(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_ALTITUDE).item(0).getTextContent()));
            mailPlane.setCostOfDelivery(Double.valueOf(eElement.getElementsByTagName(TagConstants.COST_OF_DELIVERY).item(0).getTextContent()));
            mailPlane.setSpeedDelivery(Double.valueOf(eElement.getElementsByTagName(TagConstants.SPEED_DELIVERY).item(0).getTextContent()));
            mailPlane.setRecipientCountry(eElement.getElementsByTagName(TagConstants.RECIPIENT_COUNTRY).item(0).getTextContent());
        } catch (NumberFormatException e) {
            throw new PlaneTechnicalException(ExceptionConstants.MAIL_PLANE_TECHNICAL_EXCEPTION, e);
        }
        return mailPlane;
    }

    public CargoAircraft purchaseCargoAircraft(Element eElement) throws PlaneTechnicalException {
        CargoAircraft cargoAircraft = new CargoAircraft();
        try {
            cargoAircraft.setId(Long.valueOf(eElement.getElementsByTagName(TagConstants.ID).item(0).getTextContent()));
            cargoAircraft.setModel(eElement.getElementsByTagName(TagConstants.MODEL).item(0).getTextContent());
            cargoAircraft.setEngine(eElement.getElementsByTagName(TagConstants.ENGINE).item(0).getTextContent());
            cargoAircraft.setTotalNumberOfSeats(Integer.parseInt(eElement.getElementsByTagName(TagConstants.TOTAL_NUMBER_OF_SEATS).item(0).getTextContent()));
            cargoAircraft.setCapacity(Double.valueOf(eElement.getElementsByTagName(TagConstants.CAPACITY).item(0).getTextContent()));
            cargoAircraft.setRangeOfFlight(Double.valueOf(eElement.getElementsByTagName(TagConstants.RANGE_OF_FLIGHT).item(0).getTextContent()));
            cargoAircraft.setHourlyFuelConsumption(Double.valueOf(eElement.getElementsByTagName(TagConstants.HOURLY_FUEL_CONSUMPTION).item(0).getTextContent()));
            cargoAircraft.setMaximumAltitude(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_ALTITUDE).item(0).getTextContent()));
            cargoAircraft.setMaximumCargoVolume(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_CARGO_VOLUME).item(0).getTextContent()));
            cargoAircraft.setSizeOfCargoCompartment(eElement.getElementsByTagName(TagConstants.SIZE_OF_CARGO_COMPARTMENT).item(0).getTextContent());
            cargoAircraft.setSizeOfCargoHatch(eElement.getElementsByTagName(TagConstants.SIZE_OF_CARGO_HATCH).item(0).getTextContent());
        } catch (NumberFormatException e) {
            throw new PlaneTechnicalException(ExceptionConstants.CARGO_AIRCRAFT_TECHNICAL_EXCEPTION, e);
        }
        return cargoAircraft;
    }

    public CargoAndPassengerPlane purchaseCargoAndPassengerPlane(Element eElement) throws PlaneTechnicalException {
        CargoAndPassengerPlane cargoAndPassengerPlane = new CargoAndPassengerPlane();
        try {
            cargoAndPassengerPlane.setId(Long.valueOf(eElement.getElementsByTagName(TagConstants.ID).item(0).getTextContent()));
            cargoAndPassengerPlane.setModel(eElement.getElementsByTagName(TagConstants.MODEL).item(0).getTextContent());
            cargoAndPassengerPlane.setEngine(eElement.getElementsByTagName(TagConstants.ENGINE).item(0).getTextContent());
            cargoAndPassengerPlane.setTotalNumberOfSeats(Integer.parseInt(eElement.getElementsByTagName(TagConstants.TOTAL_NUMBER_OF_SEATS).item(0).getTextContent()));
            cargoAndPassengerPlane.setCapacity(Double.valueOf(eElement.getElementsByTagName(TagConstants.CAPACITY).item(0).getTextContent()));
            cargoAndPassengerPlane.setRangeOfFlight(Double.valueOf(eElement.getElementsByTagName(TagConstants.RANGE_OF_FLIGHT).item(0).getTextContent()));
            cargoAndPassengerPlane.setHourlyFuelConsumption(Double.valueOf(eElement.getElementsByTagName(TagConstants.HOURLY_FUEL_CONSUMPTION).item(0).getTextContent()));
            cargoAndPassengerPlane.setMaximumAltitude(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_ALTITUDE).item(0).getTextContent()));
            cargoAndPassengerPlane.setMaximumCargoVolume(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_CARGO_VOLUME).item(0).getTextContent()));
            cargoAndPassengerPlane.setFullSpeed(Double.valueOf(eElement.getElementsByTagName(TagConstants.FULL_SPEED).item(0).getTextContent()));
            cargoAndPassengerPlane.setFuelSupply(Double.valueOf(eElement.getElementsByTagName(TagConstants.FUEL_SUPPLY).item(0).getTextContent()));
        } catch (NumberFormatException e) {
            throw new PlaneTechnicalException(ExceptionConstants.CARGO_AND_PASSENGER_PLANE_TECHNICAL_EXCEPTION, e);
        }
        return cargoAndPassengerPlane;
    }

    public MilitaryCivilianAirliner purchaseMilitaryCivilianAirliner(Element eElement) throws PlaneTechnicalException {
        MilitaryCivilianAirliner militaryCivilianAirliner = new MilitaryCivilianAirliner();
        try {
            militaryCivilianAirliner.setId(Long.valueOf(eElement.getElementsByTagName(TagConstants.ID).item(0).getTextContent()));
            militaryCivilianAirliner.setModel(eElement.getElementsByTagName(TagConstants.MODEL).item(0).getTextContent());
            militaryCivilianAirliner.setEngine(eElement.getElementsByTagName(TagConstants.ENGINE).item(0).getTextContent());
            militaryCivilianAirliner.setTotalNumberOfSeats(Integer.parseInt(eElement.getElementsByTagName(TagConstants.TOTAL_NUMBER_OF_SEATS).item(0).getTextContent()));
            militaryCivilianAirliner.setCapacity(Double.valueOf(eElement.getElementsByTagName(TagConstants.CAPACITY).item(0).getTextContent()));
            militaryCivilianAirliner.setRangeOfFlight(Double.valueOf(eElement.getElementsByTagName(TagConstants.RANGE_OF_FLIGHT).item(0).getTextContent()));
            militaryCivilianAirliner.setHourlyFuelConsumption(Double.valueOf(eElement.getElementsByTagName(TagConstants.HOURLY_FUEL_CONSUMPTION).item(0).getTextContent()));
            militaryCivilianAirliner.setMaximumAltitude(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_ALTITUDE).item(0).getTextContent()));
            militaryCivilianAirliner.setMaximumCargoVolume(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_CARGO_VOLUME).item(0).getTextContent()));
            militaryCivilianAirliner.setRunLength(Double.valueOf(eElement.getElementsByTagName(TagConstants.RUN_LENGTH).item(0).getTextContent()));
            militaryCivilianAirliner.setMaximumTakeOffWeight(Double.valueOf(eElement.getElementsByTagName(TagConstants.MAXIMUM_TAKE_OFF_WEIGHT).item(0).getTextContent()));
        } catch (NumberFormatException e) {
            throw new PlaneTechnicalException(ExceptionConstants.MILITARY_CIVILIAN_AIRLINER_TECHNICAL_EXCEPTION, e);
        }
        return militaryCivilianAirliner;
    }
}

