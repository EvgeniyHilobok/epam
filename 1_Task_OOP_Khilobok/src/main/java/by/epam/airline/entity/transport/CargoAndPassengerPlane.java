package by.epam.airline.entity.transport;

import by.epam.airline.constants.TypeConstants;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.validation.logic.CargoAndPassengerPlaneLogicValidation;

import java.io.Serializable;

public class CargoAndPassengerPlane extends TransportAircraft implements Cloneable, Serializable { //грузовой вариант пассажирского самолета
    private double fullSpeed; //максимальная скорость(км/ч)
    private double fuelSupply; //запас топлива(л)

    public CargoAndPassengerPlane() {
        super();
        this.fullSpeed = 0.0;
        this.fuelSupply = 0.0;
    }

    public CargoAndPassengerPlane(CargoAndPassengerPlane cargoAndPassengerPlane) throws PlaneLogicException {
        super(cargoAndPassengerPlane.getId(), cargoAndPassengerPlane.getModel(), cargoAndPassengerPlane.getEngine(),
                cargoAndPassengerPlane.getTotalNumberOfSeats(), cargoAndPassengerPlane.getCapacity(), cargoAndPassengerPlane.getRangeOfFlight(),
                cargoAndPassengerPlane.getHourlyFuelConsumption(), cargoAndPassengerPlane.getMaximumAltitude(), cargoAndPassengerPlane.getMaximumCargoVolume());
        CargoAndPassengerPlaneLogicValidation logicValidation = new CargoAndPassengerPlaneLogicValidation();
        logicValidation.fullSpeedLogicValidation(cargoAndPassengerPlane.getFullSpeed());
        this.fullSpeed = cargoAndPassengerPlane.getFullSpeed();
        logicValidation.fuelSupplyLogicValidation(cargoAndPassengerPlane.getFuelSupply());
        this.fuelSupply = cargoAndPassengerPlane.getFuelSupply();
    }

    @Override
    protected void generateType() {
        this.setType(TypeConstants.CARGO_AND_PASSENGER_TYPE);
    }

    @Override
    public String toString() {
        return super.toString() + " Full speed: " + this.getFullSpeed() + " km/h." + '\n'
                + " Fuel supply: " + this.getFuelSupply() + " liters" + '\n';
    }

    @Override
    public CargoAndPassengerPlane clone() throws CloneNotSupportedException {
        return (CargoAndPassengerPlane) super.clone();
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
        if (obj instanceof CargoAndPassengerPlane) {
            CargoAndPassengerPlane temp = (CargoAndPassengerPlane) obj;
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
                    this.fullSpeed == temp.fullSpeed &&
                    this.fuelSupply == temp.fuelSupply;
        } else return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(fullSpeed);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelSupply);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getFullSpeed() {
        return fullSpeed;
    }

    public void setFullSpeed(double fullSpeed) {
        this.fullSpeed = fullSpeed;
    }

    public double getFuelSupply() {
        return fuelSupply;
    }

    public void setFuelSupply(double fuelSupply) {
        this.fuelSupply = fuelSupply;
    }
}
