package org.softuni.mostwanted.domain.dto.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.domain.entities.Town;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

public class DistrictImportJSONDto implements Serializable {


    @Expose
    private String name;

    @Expose
    @SerializedName(value = "townName")
    private String townName;

    public DistrictImportJSONDto() {
    }

    public DistrictImportJSONDto(String name, String town) {
        this.name = name;
        this.townName = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gettownName() {
        return townName;
    }

    public void settownName(String townName) {
        this.townName = townName;
    }
}
