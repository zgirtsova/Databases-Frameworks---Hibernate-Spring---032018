package dbadvanced.lab.dto;

import dbadvanced.lab.model.entity.Employee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class ManagerDTO implements Serializable {

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    private String addressCityName;

    private Set<Employee> managedEmployees;

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAddressCityName() {
        return addressCityName;
    }

    public void setAddressCityName(String addressCityName) {
        this.addressCityName = addressCityName;
    }

    public Set<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", addressCityName='" + addressCityName + '\'' +
                ", managedEmployees=" + managedEmployees.size() +
                '}';
    }
}
