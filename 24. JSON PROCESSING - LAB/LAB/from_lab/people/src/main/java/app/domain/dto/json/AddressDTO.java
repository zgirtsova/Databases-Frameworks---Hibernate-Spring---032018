package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class AddressDTO implements Serializable {

    @Expose
    private String country;

    @Expose
    private String city;

    @Expose
    private String street;


    public AddressDTO() {
    }

    public AddressDTO(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
