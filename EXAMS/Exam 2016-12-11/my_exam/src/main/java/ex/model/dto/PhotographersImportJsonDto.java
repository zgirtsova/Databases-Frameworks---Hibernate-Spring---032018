package ex.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ex.model.validation.Phone;

import java.util.List;

public class PhotographersImportJsonDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    // @Phone когато е тук, не работи и вкарва грешни phones в базата,
    // като е сложено на Entity-то бачка???
    private String phone;

    @Expose
    @SerializedName(value = "lenses")
    private List<Long> lensSet;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Long> getLensSet() {
        return lensSet;
    }

    public void setLensSet(List<Long> lensSet) {
        this.lensSet = lensSet;
    }
}
