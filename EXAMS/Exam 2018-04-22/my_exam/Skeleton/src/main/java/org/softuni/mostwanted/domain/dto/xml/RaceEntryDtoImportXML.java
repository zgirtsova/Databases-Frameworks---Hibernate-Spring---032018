package org.softuni.mostwanted.domain.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryDtoImportXML {

    // това ентри го създаваме само, за да напълним <races> xml,
    //защото там се иска само id от RaceEntry и за това правим
    // ново DTO
    @XmlAttribute
    private Integer id;

    public RaceEntryDtoImportXML() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
