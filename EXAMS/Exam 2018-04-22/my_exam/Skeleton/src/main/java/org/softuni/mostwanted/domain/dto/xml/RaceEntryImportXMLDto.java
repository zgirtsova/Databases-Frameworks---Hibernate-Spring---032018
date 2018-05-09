package org.softuni.mostwanted.domain.dto.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;


@XmlRootElement(name = "race-entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryImportXMLDto implements Serializable {

    @XmlAttribute(name = "has-finished")
    private Boolean hasFinished;

    @XmlAttribute(name = "finish-time")
    private BigDecimal finishTime;

    @XmlAttribute(name = "car-id")
    private int carId;

    @XmlElement(name = "racer")
    private String racerName;

    public RaceEntryImportXMLDto() {
    }

    public RaceEntryImportXMLDto(boolean hasFinished, BigDecimal finishTime, int carId, String racerName) {
        this.hasFinished = hasFinished;
        this.finishTime = finishTime;
        this.carId = carId;
        this.racerName = racerName;
    }

    public boolean getHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public BigDecimal getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(BigDecimal finishTime) {
        this.finishTime = finishTime;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getRacerName() {
        return racerName;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }
}
