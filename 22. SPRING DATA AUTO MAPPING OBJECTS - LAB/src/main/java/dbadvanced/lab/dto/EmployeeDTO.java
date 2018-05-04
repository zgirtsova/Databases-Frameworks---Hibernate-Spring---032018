package dbadvanced.lab.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeeDTO implements Serializable {

    private String firstName;

    private String addressCityName;

    private BigDecimal salary;

    private String managerLastName;

    public EmployeeDTO(String name, String addressCityName, BigDecimal salary) {
        this.firstName = name;
        this.addressCityName = addressCityName;
        this.salary = salary;
    }

    public EmployeeDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getAddressCityName() {
        return addressCityName;
    }

    public void setAddressCityName(String addressCityName) {
        this.addressCityName = addressCityName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + this.firstName + '\'' +
                ", addressCityName='" + this.addressCityName + '\'' +
                ", salary=" + this.salary +
                '}';
    }
}
