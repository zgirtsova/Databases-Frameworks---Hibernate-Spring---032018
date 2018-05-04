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
    private Set<PhoneNumberDTO> phoneJsonDTOs;


    public PersonDTO() {
        //this.phoneJsonDTOs = new HashSet<>();
    }

    public PersonDTO(String firstName, String lastName, AddressDTO addressImportDTO, Set<PhoneNumberDTO> phoneJsonDTOs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressImportDTO = addressImportDTO;
        this.phoneJsonDTOs = phoneJsonDTOs;
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

    public AddressDTO getAddressImportDTO() {
        return addressImportDTO;
    }

    public void setAddressImportDTO(AddressDTO addressImportDTO) {
        this.addressImportDTO = addressImportDTO;
    }

    public Set<PhoneNumberDTO> getPhoneJsonDTOs() {
        return phoneJsonDTOs;
    }

    public void setPhoneJsonDTOs(Set<PhoneNumberDTO> phoneJsonDTOs) {
        this.phoneJsonDTOs = phoneJsonDTOs;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressImportDTO=" + addressImportDTO +
                //", phoneJsonDTOs=" + phoneNumbers +
                '}';
    }
}
