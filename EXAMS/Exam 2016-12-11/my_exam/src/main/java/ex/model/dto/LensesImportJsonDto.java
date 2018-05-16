package ex.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class LensesImportJsonDto {

    @Expose
    private String make;

    @Expose
    private int focalLength;

    @Expose
    private BigDecimal maxAperture;

    @Expose
    @SerializedName(value = "compatibleWith")
    private String makeCompatibleWith;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public BigDecimal getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(BigDecimal maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getMakeCompatibleWith() {
        return makeCompatibleWith;
    }

    public void setMakeCompatibleWith(String makeCompatibleWith) {
        this.makeCompatibleWith = makeCompatibleWith;
    }
}
