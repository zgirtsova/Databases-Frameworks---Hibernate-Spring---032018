package org.softuni.mostwanted.domain.dto.json;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class TownImportJSONDto implements Serializable {

    @Expose
    private String name;

    public TownImportJSONDto() {
    }

    public TownImportJSONDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
