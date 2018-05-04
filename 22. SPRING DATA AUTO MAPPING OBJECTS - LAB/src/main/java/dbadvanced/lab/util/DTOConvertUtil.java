package dbadvanced.lab.util;

import dbadvanced.lab.dto.EmployeeDTO;
import dbadvanced.lab.dto.ManagerDTO;
import dbadvanced.lab.model.entity.Employee;
import org.modelmapper.Converter;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public final class DTOConvertUtil {

    private DTOConvertUtil() {
    }

    public static <S, D> D convert(S source, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(source, destinationClass);
    }

    public static <S, D> List<D> convert(Iterable<S> sourceIter, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        List<D> resultList = new ArrayList<>();
        for (S s : sourceIter) {
            D d = convert(s, destinationClass);
            resultList.add(d);
        }

        return resultList;
    }

    public static <S, D> Set<D> convertToSet(Iterable<S> sourceIter, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        Set<D> resultSet = new HashSet<>();
        for (S s : sourceIter) {
            D d = convert(s, destinationClass);
            resultSet.add(d);
        }

        return resultSet;
    }


    public static EmployeeDTO convertEmployeeToEmployeeDto(Employee employee) {
        Converter<String, String> toUpperConverter = ctx -> ctx.getSource() == null ? "" : ctx.getSource().toUpperCase();
        ExpressionMap<Employee, EmployeeDTO> mappingWithConverter =
                m -> m.using(toUpperConverter)
                        .map(src -> src.getManager().getLastName(), EmployeeDTO::setManagerLastName);
        ExpressionMap<Employee, EmployeeDTO> skipping = m -> m.skip(EmployeeDTO::setSalary);
        return convertCustom(employee, EmployeeDTO.class, mappingWithConverter, skipping);
    }

    public static Employee convertEmployeeDtoToEmployee(EmployeeDTO employeeDto) {
        Converter<String, String> toLowerConverter = ctx -> ctx.getSource() == null ? "" : ctx.getSource().toLowerCase();

        ExpressionMap<EmployeeDTO, Employee> mappingWithConverter =
                m -> m.using(toLowerConverter)
                        .<String> map(src -> src.getManagerLastName(), (dest, v) -> dest.getManager().setLastName(v));

        ExpressionMap<EmployeeDTO, Employee> skipping = m -> m.using(toLowerConverter).skip(Employee::setSalary);
        return convertCustom(employeeDto, Employee.class, mappingWithConverter, skipping);
    }

    private  static <S, D> D convertCustom(S source, Class<D> destClass, ExpressionMap<S, D>... exprMaps) {
        ModelMapper mapper = new ModelMapper();
        TypeMap<S, D> typeMap = mapper.createTypeMap((Class<S>) source.getClass(), destClass);
        for (ExpressionMap<S, D> exprMap : exprMaps) {
            typeMap.addMappings(exprMap);
        }
        return typeMap.map(source);
    }

    public static Set<EmployeeDTO> convertEmployeeSetToEmployeeDtoSet(Iterable<Employee> employees) {
        ModelMapper mapper = new ModelMapper();

        Set<EmployeeDTO> resultList = new HashSet<>();

        for (Employee employee : employees) {
            EmployeeDTO employeeDto = convertEmployeeToEmployeeDto(employee);
            resultList.add(employeeDto);
        }

        return resultList;
    }

    public static List<ManagerDTO> convertEmployeeListToManagerDtoList(List<Employee> employees) {
        ModelMapper mapper = new ModelMapper();
        List<ManagerDTO> resultList = new ArrayList<>();
        for (Employee e : employees) {
            ManagerDTO managerDto = convert(e, ManagerDTO.class);
            managerDto.setManagedEmployees(convertEmployeeSetToEmployeeDtoSet(e.getManagedEmployees()));
            resultList.add(managerDto);
        }

        return resultList;
    }
}
