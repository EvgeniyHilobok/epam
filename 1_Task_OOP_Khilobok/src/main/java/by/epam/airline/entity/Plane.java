package by.epam.airline.entity;

import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.validation.logic.PlaneLogicValidation;

import java.io.Serializable;

public abstract class Plane implements Cloneable, Serializable {
    private long id;
    private String model;
    private String engine;
    private String type;
    private int totalNumberOfSeats; //общее число мест (шт.)(вместимость)
    private double capacity; //грузоподъемность(кг)
    private double rangeOfFlight; //дальность полета(км)
    private double hourlyFuelConsumption; //часовой расход топлива(л)
    private double maximumAltitude; //максимальная высота полета(км)

    public Plane() {
        this.id = 0;
        this.model = "";
        this.engine = "";
        generateType();
        this.totalNumberOfSeats = 0;
        this.capacity = 0.0;
        this.rangeOfFlight = 0.0;
        this.hourlyFuelConsumption = 0.0;
        this.maximumAltitude = 0.0;
    }

    public Plane(long id, String model, String engine, int totalNumberOfSeats, double capacity, double rangeOfFlight,
                 double hourlyFuelConsumption, double maximumAltitude) throws PlaneLogicException {
        PlaneLogicValidation logicValidation = new PlaneLogicValidation();
        logicValidation.idLogicValidation(id);
        this.id = id;
        logicValidation.modelLogicValidation(model);
        this.model = model;
        logicValidation.engineLogicValidation(engine);
        this.engine = engine;
        generateType();
        logicValidation.numberOfSeatsLogicValidation(totalNumberOfSeats);
        this.totalNumberOfSeats = totalNumberOfSeats;
        logicValidation.capacityLogicValidation(capacity);
        this.capacity = capacity;
        logicValidation.rangeOfFlightLogicValidation(rangeOfFlight);
        this.rangeOfFlight = rangeOfFlight;
        logicValidation.hourlyFuelConsumptionLogicValidation(hourlyFuelConsumption);
        this.hourlyFuelConsumption = hourlyFuelConsumption;
        logicValidation.maximumAltitudeLogicValidation(maximumAltitude);
        this.maximumAltitude = maximumAltitude;
    }

    protected abstract void generateType();

    @Override
    public String toString() {
        return "Model: " + this.getModel() + '\n' + " Engine: " + this.getEngine() + '\n' + " Type: " + this.getType() + '\n' + " Total number of seats: "
                + this.getTotalNumberOfSeats() + " pc." + '\n' + " Capacity: " + this.getCapacity() + " kg." + '\n' + " Range of flight: " + this.getRangeOfFlight()
                + " km." + '\n' + " Hourly fuel consumption: " + this.getHourlyFuelConsumption() + " kg." + '\n' + " Maximum altitude: " +
                this.getMaximumAltitude() + " km." + '\n';
    }

    @Override
    public Plane clone() throws CloneNotSupportedException {
        return (Plane) super.clone();
    }

    public String getModel() {
        return model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getRangeOfFlight() {
        return rangeOfFlight;
    }

    public void setRangeOfFlight(double rangeOfFlight) {
        this.rangeOfFlight = rangeOfFlight;
    }

    public double getHourlyFuelConsumption() {
        return hourlyFuelConsumption;
    }

    public void setHourlyFuelConsumption(double hourlyFuelConsumption) {
        this.hourlyFuelConsumption = hourlyFuelConsumption;
    }

    public double getMaximumAltitude() {
        return maximumAltitude;
    }

    public void setMaximumAltitude(double maximumAltitude) {
        this.maximumAltitude = maximumAltitude;
    }
}
