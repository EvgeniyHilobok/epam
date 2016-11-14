package by.epam.airline.entity.transport;

import by.epam.airline.constants.TypeConstants;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.validation.logic.CargoAircraftLogicValidation;

import java.io.Serializable;

public class CargoAircraft extends TransportAircraft implements Cloneable, Serializable { //исключительно грузовой транспортный самолет
    private String sizeOfCargoCompartment; //размер грузового отсека(Длина/Ширина/Высота) (м)
    private String sizeOfCargoHatch; //размер грузового люка(Ширина/Высота) (м)

    public CargoAircraft() {
        super();
        this.sizeOfCargoCompartment = "";
        this.sizeOfCargoHatch = "";
    }

    public CargoAircraft(CargoAircraft cargoAircraft) throws PlaneLogicException {
        super(cargoAircraft.getId(), cargoAircraft.getModel(), cargoAircraft.getEngine(), cargoAircraft.getTotalNumberOfSeats(),
                cargoAircraft.getCapacity(), cargoAircraft.getRangeOfFlight(), cargoAircraft.getHourlyFuelConsumption(),
                cargoAircraft.getMaximumAltitude(), cargoAircraft.getMaximumCargoVolume());
        CargoAircraftLogicValidation logicValidation = new CargoAircraftLogicValidation();
        logicValidation.sizeOfCargoCompartmentLogicValidation(cargoAircraft.getSizeOfCargoCompartment());
        this.sizeOfCargoCompartment = cargoAircraft.getSizeOfCargoCompartment();
        logicValidation.sizeOfCargoHatchLogicValidation(cargoAircraft.getSizeOfCargoHatch());
        this.sizeOfCargoHatch = cargoAircraft.getSizeOfCargoHatch();
    }

    @Override
    protected void generateType() {
        this.setType(TypeConstants.CARGO_TYPE);
    }

    @Override
    public String toString() {
        return super.toString() + " The size of the cargo compartment: " + this.getSizeOfCargoCompartment() + " m." + '\n'
                + " The size of the cargo hatch: " + this.getSizeOfCargoHatch() + " m." + '\n';
    }

    @Override
    public CargoAircraft clone() throws CloneNotSupportedException {
        return (CargoAircraft) super.clone();
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
        if (obj instanceof CargoAircraft) {
            CargoAircraft temp = (CargoAircraft) obj;
            return this.getId() == temp.getId() &&
                    this.getModel().equals(temp.getModel()) &&
                    this.getEngine().equals(temp.getEngine()) &&
                    this.getType().equals(temp.getType()) &&
                    this.getTotalNumberOfSeats() == temp.getTotalNumberOfSeats() &&
                    this.getCapacity() == temp.getCapacity() &&
                    this.getRangeOfFlight() == temp.getRangeOfFlight() &&
                    this.getHourlyFuelConsumption() == temp.getHourlyFuelConsumption() &&
                    this.getMaximumAltitude() == temp.getMaximumAltitude() &&
                    this.getMaximumCargoVolume() == temp.getMaximumCargoVolume() &&
                    this.sizeOfCargoCompartment.equals(temp.sizeOfCargoCompartment) &&
                    this.sizeOfCargoHatch.equals(temp.sizeOfCargoHatch);
        } else return false;
    }

    @Override
    public int hashCode() {
        int result = sizeOfCargoCompartment != null ? sizeOfCargoCompartment.hashCode() : 0;
        result = 31 * result + (sizeOfCargoHatch != null ? sizeOfCargoHatch.hashCode() : 0);
        return result;
    }

    public String getSizeOfCargoCompartment() {
        return sizeOfCargoCompartment;
    }

    public void setSizeOfCargoCompartment(String sizeOfCargoCompartment) {
        this.sizeOfCargoCompartment = sizeOfCargoCompartment;
    }

    public String getSizeOfCargoHatch() {
        return sizeOfCargoHatch;
    }

    public void setSizeOfCargoHatch(String sizeOfCargoHatch) {
        this.sizeOfCargoHatch = sizeOfCargoHatch;
    }
}
