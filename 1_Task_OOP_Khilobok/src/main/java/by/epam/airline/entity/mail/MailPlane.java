package by.epam.airline.entity.mail;

import by.epam.airline.constants.TypeConstants;
import by.epam.airline.entity.Plane;
import by.epam.airline.exceptions.PlaneLogicException;
import by.epam.airline.validation.logic.MailPlaneLogicValidation;

import java.io.Serializable;

public class MailPlane extends Plane implements Cloneable, Serializable { //почтовый самолет
    private double costOfDelivery; //стоимость доставки (у.е.)
    private double speedDelivery; //скорость доставки (часы)
    private String recipientCountry; //страна-получатель доставки

    public MailPlane() {
        super();
        this.costOfDelivery = 0.0;
        this.speedDelivery = 0.0;
        this.recipientCountry = "";
    }

    public MailPlane(MailPlane mailPlane) throws PlaneLogicException {
        super(mailPlane.getId(), mailPlane.getModel(), mailPlane.getEngine(), mailPlane.getTotalNumberOfSeats(),
                mailPlane.getCapacity(), mailPlane.getRangeOfFlight(), mailPlane.getHourlyFuelConsumption(),
                mailPlane.getMaximumAltitude());
        MailPlaneLogicValidation logicValidation = new MailPlaneLogicValidation();
        logicValidation.costOfDeliveryLogicValidation(mailPlane.getCostOfDelivery());
        this.costOfDelivery = mailPlane.getCostOfDelivery();
        logicValidation.speedDeliveryLogicValidation(mailPlane.getSpeedDelivery());
        this.speedDelivery = mailPlane.getSpeedDelivery();
        logicValidation.recipientCountryLogicValidation(mailPlane.getRecipientCountry());
        this.recipientCountry = mailPlane.getRecipientCountry();
    }

    @Override
    protected void generateType() {
        this.setType(TypeConstants.MAIL_TYPE);
    }

    @Override
    public String toString() {
        return super.toString() + " Cost of delivery: " + this.getCostOfDelivery() + " USD" + '\n'
                + " Speed delivery: " + this.getSpeedDelivery() + " hours" + '\n' + " Recipient country: " +
                this.getRecipientCountry() + '\n';
    }

    @Override
    public MailPlane clone() throws CloneNotSupportedException {
        return (MailPlane) super.clone();
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
        if (obj instanceof MailPlane) {
            MailPlane temp = (MailPlane) obj;
            return this.getId() == temp.getId() &&
                    this.getModel().equals(temp.getModel()) &&
                    this.getEngine().equals(temp.getEngine()) &&
                    this.getType().equals(temp.getType()) &&
                    this.getTotalNumberOfSeats() == temp.getTotalNumberOfSeats() &&
                    this.getCapacity() == temp.getCapacity() &&
                    this.getRangeOfFlight() == temp.getRangeOfFlight() &&
                    this.getHourlyFuelConsumption() == temp.getHourlyFuelConsumption() &&
                    this.getMaximumAltitude() == temp.getMaximumAltitude() &&
                    this.costOfDelivery == temp.costOfDelivery &&
                    this.speedDelivery == temp.speedDelivery &&
                    this.recipientCountry.equals(temp.recipientCountry);
        } else return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(costOfDelivery);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(speedDelivery);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (recipientCountry != null ? recipientCountry.hashCode() : 0);
        return result;
    }

    public double getCostOfDelivery() {
        return costOfDelivery;
    }

    public void setCostOfDelivery(double costOfDelivery) {
        this.costOfDelivery = costOfDelivery;
    }

    public double getSpeedDelivery() {
        return speedDelivery;
    }

    public void setSpeedDelivery(double speedDelivery) {
        this.speedDelivery = speedDelivery;
    }

    public String getRecipientCountry() {
        return recipientCountry;
    }

    public void setRecipientCountry(String recipientCountry) {
        this.recipientCountry = recipientCountry;
    }
}
