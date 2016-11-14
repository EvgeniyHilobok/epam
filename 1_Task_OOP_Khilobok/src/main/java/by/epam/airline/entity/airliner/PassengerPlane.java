package by.epam.airline.entity.airliner;

import by.epam.airline.constants.TypeConstants;
import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.validation.logic.PassengerPlaneLogicValidation;

import java.io.Serializable;

public class PassengerPlane extends Plane implements Cloneable, Serializable { //пассажирский самолет
    private String manufacturerCountry;
    private String planeClass; //эконом-класс, бизнесс-класс и т.д.
    private double averageCostOfFlight; //средняя стоимость перелета(у.е.)

    public PassengerPlane() {
        super();
        this.manufacturerCountry = "";
        this.planeClass = "";
        this.averageCostOfFlight = 0.0;
    }

    public PassengerPlane(PassengerPlane passengerPlane) throws PlaneLogicException {
        super(passengerPlane.getId(), passengerPlane.getModel(), passengerPlane.getEngine(), passengerPlane.getTotalNumberOfSeats(),
                passengerPlane.getCapacity(), passengerPlane.getRangeOfFlight(), passengerPlane.getHourlyFuelConsumption(),
                passengerPlane.getMaximumAltitude());
        PassengerPlaneLogicValidation logicValidation = new PassengerPlaneLogicValidation();
        logicValidation.manufacturerCountryLogicValidation(passengerPlane.getManufacturerCountry());
        this.manufacturerCountry = passengerPlane.getManufacturerCountry();
        logicValidation.planeClassLogicValidation(passengerPlane.getPlaneClass());
        this.planeClass = passengerPlane.getPlaneClass();
        logicValidation.averageCostOfFlightLogicValidation(passengerPlane.getAverageCostOfFlight());
        this.averageCostOfFlight = passengerPlane.getAverageCostOfFlight();
    }

    @Override
    protected void generateType() {
        this.setType(TypeConstants.PASSENGER_TYPE);
    }

    @Override
    public String toString() {
        return super.toString() + " Manufacturer country: " + this.getManufacturerCountry() + '\n'
                + " Class of plane: " + this.getPlaneClass() + '\n' + " The average cost of the flight: " +
                this.getAverageCostOfFlight() + " USD" + '\n';
    }

    @Override
    public PassengerPlane clone() throws CloneNotSupportedException {
        return (PassengerPlane) super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof PassengerPlane) {
            PassengerPlane temp = (PassengerPlane) obj;
            return this.getId() == temp.getId() &&
                    this.getModel().equals(temp.getModel()) &&
                    this.getEngine().equals(temp.getEngine()) &&
                    this.getType().equals(temp.getType()) &&
                    this.getTotalNumberOfSeats() == temp.getTotalNumberOfSeats() &&
                    this.getCapacity() == temp.getCapacity() &&
                    this.getRangeOfFlight() == temp.getRangeOfFlight() &&
                    this.getHourlyFuelConsumption() == temp.getHourlyFuelConsumption() &&
                    this.getMaximumAltitude() == temp.getMaximumAltitude() &&
                    this.manufacturerCountry.equals(temp.manufacturerCountry) &&
                    this.planeClass.equals(temp.planeClass) &&
                    this.averageCostOfFlight == temp.averageCostOfFlight;
        } else return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = manufacturerCountry != null ? manufacturerCountry.hashCode() : 0;
        result = 31 * result + (planeClass != null ? planeClass.hashCode() : 0);
        temp = Double.doubleToLongBits(averageCostOfFlight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public String getPlaneClass() {
        return planeClass;
    }

    public void setPlaneClass(String planeClass) {
        this.planeClass = planeClass;
    }

    public double getAverageCostOfFlight() {
        return averageCostOfFlight;
    }

    public void setAverageCostOfFlight(double averageCostOfFlight) {
        this.averageCostOfFlight = averageCostOfFlight;
    }
}
