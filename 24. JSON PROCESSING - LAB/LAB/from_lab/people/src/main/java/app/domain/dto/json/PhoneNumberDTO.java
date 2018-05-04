package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class PhoneNumberDTO implements Serializable {

    @Expose
    private String number;



    public PhoneNumberDTO() {
    }

    public PhoneNumberDTO(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumberDTO{" +
                "number='" + number + '\'' +
                '}';
    }
}
