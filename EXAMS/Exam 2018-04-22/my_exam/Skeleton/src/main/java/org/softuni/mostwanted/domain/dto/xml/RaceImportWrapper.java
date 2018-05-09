package org.softuni.mostwanted.domain.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceImportWrapper {

    @XmlElement(name = "race")
    List<RaceImportXMLDto> races;

    public RaceImportWrapper() {
    }

    public List<RaceImportXMLDto> getRaces() {
        return races;
    }

    public void setRaces(List<RaceImportXMLDto> races) {
        this.races = races;
    }


}
