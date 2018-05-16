package ex.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CameraImportJsonDto {

    @Expose
    private String type;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private boolean isFullFrame;

    @Expose
    private int minISO;

    @Expose
    private int maxISO;

    @Expose
    @SerializedName("MaxShutterSpeed")
    private int maxShutterSpeed;

    @Expose
    private String maxVideoResolution;

    @Expose
    private int maxFrameRate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isFullFrame() {
        return isFullFrame;
    }

    public void setFullFrame(boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public int getMinISO() {
        return minISO;
    }

    public void setMinISO(int minISO) {
        this.minISO = minISO;
    }

    public int getMaxISO() {
        return maxISO;
    }

    public void setMaxISO(int maxISO) {
        this.maxISO = maxISO;
    }

    public int getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public int getMaxFrameRate() {
        return maxFrameRate;
    }

    public void setMaxFrameRate(int maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }

}
