package by.epam.airline.entity;

import by.epam.airline.constants.PathConstants;
import by.epam.airline.parser.DOMParserXMLImpl;

import java.io.*;
import java.util.ArrayList;

public class Airline implements Cloneable, Serializable {
    private ArrayList<Plane> airline;

    public Airline() {
        this.airline = new ArrayList<Plane>();
    }

    public ArrayList<Plane> getPlaneList() {
        return this.airline;
    }

    public void addPlane(Plane plane) {
        this.airline.add(plane);
    }

    public static Airline createAirline() {
        DOMParserXMLImpl domParserXML = new DOMParserXMLImpl();
        return domParserXML.parse(PathConstants.FILEPATH);
    }

    @Override
    public String toString() {
        String result = "Airline:" + '\n';
        for (int i = 0; i < this.getPlaneList().size(); i++) {
            result += this.getPlaneList().get(i).toString() + "\n";
        }
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Airline copy = (Airline) super.clone();
        Object object = null;
        try {
            object = getDeepCloning(copy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public Object getDeepCloning(Object copy) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(copy);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }
}
