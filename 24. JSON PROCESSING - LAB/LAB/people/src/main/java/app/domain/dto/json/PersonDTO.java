package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PersonDTO implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private AddressDTO addressImportDTO;

    @Expose
    private Set<PhoneNumberDTO> phoneNumbers;


    public PersonDTO() {
        //this.phoneNumbers = new HashSet<>();
    }

    public PersonDTO(String firstName, String lastName, AddressDTO addressImportDTO, Set<PhoneNumberDTO> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressImportDTO = addressImportDTO;
        this.phoneNumbers = phoneNumbers;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public AddressDTO getAddress() {
        return this.addressImportDTO;
    }

    public void setAddress(final AddressDTO address) {
        this.addressImportDTO = address;
    }

    public Set<PhoneNumberDTO> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void setPhoneNumbers(final Set<PhoneNumberDTO> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressImportDTO=" + addressImportDTO +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
