package by.epam.airline.entity.transport;

import by.epam.airline.constants.TypeConstants;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.validation.logic.MilitaryCivilianAirlinerLogicValidation;

import java.io.Serializable;

public class MilitaryCivilianAirliner extends TransportAircraft implements Cloneable, Serializable { //военно-гражданский транспортный самолет
    private double runLength; //длина разбега(м)
    private double maximumTakeOffWeight; //максимальный взлетный вес(кг)

    public MilitaryCivilianAirliner() {
        super();
        this.runLength = 0.0;
        this.maximumTakeOffWeight = 0.0;
    }

    public MilitaryCivilianAirliner(MilitaryCivilianAirliner militaryCivilianAirliner) throws PlaneLogicException {
        super(militaryCivilianAirliner.getId(), militaryCivilianAirliner.getModel(), militaryCivilianAirliner.getEngine(),
                militaryCivilianAirliner.getTotalNumberOfSeats(), militaryCivilianAirliner.getCapacity(), militaryCivilianAirliner.getRangeOfFlight(),
                militaryCivilianAirliner.getHourlyFuelConsumption(), militaryCivilianAirliner.getMaximumAltitude(), militaryCivilianAirliner.getMaximumCargoVolume());
        MilitaryCivilianAirlinerLogicValidation logicValidation = new MilitaryCivilianAirlinerLogicValidation();
        logicValidation.runLengthLogicValidation(militaryCivilianAirliner.getRunLength());
        this.runLength = militaryCivilianAirliner.getRunLength();
        logicValidation.maximumTakeOffWeightLogicValidation(militaryCivilianAirliner.getMaximumTakeOffWeight());
        this.maximumTakeOffWeight = militaryCivilianAirliner.getMaximumTakeOffWeight();
    }

    @Override
    protected void generateType() {
        this.setType(TypeConstants.MILITARY_CIVILIAN_TYPE);
    }

    @Override
    public String toString() {
        return super.toString() + " The run length: " + this.getRunLength() + " m." + '\n'
                + " Maximum take off weight: " + this.getMaximumTakeOffWeight() + " kg." + '\n';
    }

    @Override
    public MilitaryCivilianAirliner clone() throws CloneNotSupportedException {
        return (MilitaryCivilianAirliner) super.clone();
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
        if (obj instanceof MilitaryCivilianAirliner) {
            MilitaryCivilianAirliner temp = (MilitaryCivilianAirliner) obj;
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
                    this.runLength == temp.runLength &&
                    this.maximumTakeOffWeight == temp.maximumTakeOffWeight;
        } else return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(runLength);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maximumTakeOffWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getRunLength() {
        return runLength;
    }

    public void setRunLength(double runLength) {
        this.runLength = runLength;
    }

    public double getMaximumTakeOffWeight() {
        return maximumTakeOffWeight;
    }

    public void setMaximumTakeOffWeight(double maximumTakeOffWeight) {
        this.maximumTakeOffWeight = maximumTakeOffWeight;
    }
}
