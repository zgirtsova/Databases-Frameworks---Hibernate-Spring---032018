package dbadvanced.lab.service.api;

import dbadvanced.lab.model.entity.Employee;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public interface EmployeeService {

    public void registerEmployee(Employee employee);
}
