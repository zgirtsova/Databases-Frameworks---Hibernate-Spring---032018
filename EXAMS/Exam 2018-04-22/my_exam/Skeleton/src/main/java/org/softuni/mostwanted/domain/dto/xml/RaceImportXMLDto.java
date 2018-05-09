package org.softuni.mostwanted.domain.dto.xml;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceImportXMLDto implements Serializable {

    @XmlElement(name = "laps")
    private Integer laps;

    @XmlElement(name = "district-name")
    private String districtName;

    @Expose
    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    private Set<RaceEntryDtoImportXML> entries;

    public RaceImportXMLDto() {
    }

    public RaceImportXMLDto(Integer laps, String districtName, Set<RaceEntryDtoImportXML> entries) {
        this.laps = laps;
        this.districtName = districtName;
        this.entries = entries;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Set<RaceEntryDtoImportXML> getEntries() {
        return entries;
    }

    public void setEntries(Set<RaceEntryDtoImportXML> entries) {
        this.entries = entries;
    }
}
