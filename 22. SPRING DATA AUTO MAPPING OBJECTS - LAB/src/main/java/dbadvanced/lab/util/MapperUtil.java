package dbadvanced.lab.util;

import dbadvanced.lab.dto.EmployeeDTO;
import dbadvanced.lab.model.entity.Employee;
import org.modelmapper.ModelMapper;

import javax.print.attribute.standard.Destination;

public final class MapperUtil {

    public MapperUtil() {
    }

    // Стандартен мапинг, който конвертира от Employee -> EmployeeDTO
    public static EmployeeDTO convertEmployee(Employee employee) {
        ModelMapper modelMapper = new ModelMapper();
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);

//        modelMapper.addMappings(mapper -> {
//            modelMapper.map(empl -> Employee::getFirstName,
//                    EmployeeDTO::setName);
//            mapper.map(src -> src.getBillingAddress().getCity(),
//                    Destination::setBillingCity);
//        });

        return employeeDTO;
    }
}
