package dbadvanced.lab.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    @Basic
    private String street;

    @OneToMany(mappedBy = "address")
    private Set<Employee> employees;

    public Address(City city, String street) {
        this.city = city;
        this.street = street;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Set<Employee> getEmployee() {
        return employees;
    }

    public void setEmployee(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", street='" + street + '\'' + '}';
    }
}
