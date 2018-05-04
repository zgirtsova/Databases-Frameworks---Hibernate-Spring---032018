package dbadvanced.lab.service.impl;

import dbadvanced.lab.dao.EmployeeDAO;
import dbadvanced.lab.model.entity.Employee;
import dbadvanced.lab.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void registerEmployee(Employee employee) {
        this.employeeDAO.save(employee);
    }
}
