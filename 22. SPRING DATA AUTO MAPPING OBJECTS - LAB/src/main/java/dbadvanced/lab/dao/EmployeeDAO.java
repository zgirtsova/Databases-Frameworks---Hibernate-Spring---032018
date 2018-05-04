package dbadvanced.lab.dao;

import dbadvanced.lab.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    public void findEmployeeByAddressCityName(String cityName);
}
