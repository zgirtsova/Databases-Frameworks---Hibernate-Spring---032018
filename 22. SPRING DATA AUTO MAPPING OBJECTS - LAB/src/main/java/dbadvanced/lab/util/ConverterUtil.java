package dbadvanced.lab.util;

import dbadvanced.lab.dto.EmployeeDTO;
import dbadvanced.lab.dto.ManagerDTO;
import dbadvanced.lab.model.entity.Employee;
import org.modelmapper.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConverterUtil {

    private ConverterUtil() {
    }

    public static <S, D> D convert(S source, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(source, destinationClass);
    }

    public static <S, D> D convertCustom(S source, Class<D> destClass, ExpressionMap<S, D>... exprMaps) {
        ModelMapper mapper = new ModelMapper();
        TypeMap<S, D> typeMap = mapper.createTypeMap((Class<S>) source.getClass(), destClass);
        for (ExpressionMap<S, D> exprMap : exprMaps) {
            typeMap.addMappings(exprMap);
        }
        return typeMap.map(source);
    }

    public static EmployeeDTO convertEmployeeEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = null;

        ExpressionMap<Employee, EmployeeDTO> mapper =
                m -> m.map(src -> src.getFirstName(),
                        EmployeeDTO::setFirstName);

        ExpressionMap<Employee, EmployeeDTO> mapper1 =
                m -> m.map(src -> src.getAddress().getCity().getName(),
                        EmployeeDTO::setAddressCityName);

        return employeeDTO;
    }

    public static EmployeeDTO workingMapping(Employee employee01) {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<Employee, EmployeeDTO> employeeDTOMap = new PropertyMap<Employee, EmployeeDTO>() {
            protected void configure() {
                map().setFirstName(source.getFirstName());
                //map(source.getAddress().getCity().getName(), destination.setAddressCityName());
            }
        };
        modelMapper.addMappings(employeeDTOMap);
        EmployeeDTO employeeDTO = modelMapper.map(employee01, EmployeeDTO.class);
        return employeeDTO;
    }

    //създава converter
    public static EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee) {
        Converter<String, String> toUpperCase =
                ctx -> ctx.getSource() == null ? "" : ctx.getSource().toUpperCase();

        ExpressionMap<Employee, EmployeeDTO> mappingWithConverter =
                m -> m.using(toUpperCase)
                        .map(src -> src.getFirstName(), EmployeeDTO::setFirstName);
        ExpressionMap<Employee, EmployeeDTO> skipping =
                m -> m.skip(EmployeeDTO::setSalary);

        return convertCustom(employee, EmployeeDTO.class, mappingWithConverter, skipping);

    }

    public static Set<EmployeeDTO> convertEmployeeSetToEmployeeDtoSet(Iterable<Employee> employees){
        ModelMapper mapper = new ModelMapper();
        Set<EmployeeDTO> resultList = new HashSet<>();
        for(Employee employee : employees) {
            EmployeeDTO employeeDTO = convertEmployeeToEmployeeDTO(employee);
            resultList.add(employeeDTO);
        }

        return resultList;
    }

    public static List<ManagerDTO> convertEmployeeListToManagerDtoList(List<Employee> employees) {
        ModelMapper mapper = new ModelMapper();
        List<ManagerDTO> resultList = new ArrayList<>();
        for (Employee e : employees) {
            ManagerDTO managerDTO = convert(e, ManagerDTO.class);
            managerDTO.setManagedEmployees(convertEmployeeSetToEmployeeDtoSet(e.getManagedEmployees()));
            resultList.add(managerDTO);
        }
        return resultList;
    }
}
