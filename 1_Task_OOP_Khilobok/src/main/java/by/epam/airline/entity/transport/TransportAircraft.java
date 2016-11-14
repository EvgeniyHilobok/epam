package by.epam.airline.entity.transport;

import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.validation.logic.PlaneLogicValidation;

import java.io.Serializable;

public abstract class TransportAircraft extends Plane implements Cloneable, Serializable { //транспортный самолет
    private double maximumCargoVolume; //максимальный объем груза(м3)

    public TransportAircraft() {
        super();
        this.maximumCargoVolume = 0.0;
    }

    public TransportAircraft(long id, String model, String engine, int totalNumberOfSeats, double capacity, double rangeOfFlight,
                             double hourlyFuelConsumption, double maximumAltitude, double maximumCargoVolume) throws PlaneLogicException {
        super(id, model, engine, totalNumberOfSeats, capacity, rangeOfFlight, hourlyFuelConsumption, maximumAltitude);
        PlaneLogicValidation logicValidation = new PlaneLogicValidation();
        logicValidation.maximumCargoVolumeLogicValidation(maximumCargoVolume);
        this.maximumCargoVolume = maximumCargoVolume;
    }

    @Override
    public String toString() {
        return super.toString() + " Maximum cargo volume: " + this.getMaximumCargoVolume() + " m3." + '\n';
    }

    @Override
    public TransportAircraft clone() throws CloneNotSupportedException {
        return (TransportAircraft) super.clone();
    }

    public double getMaximumCargoVolume() {
        return maximumCargoVolume;
    }

    public void setMaximumCargoVolume(double maximumCargoVolume) {
        this.maximumCargoVolume = maximumCargoVolume;
    }
}
