package dbadvanced.lab;

import dbadvanced.lab.dao.EmployeeDAO;
import dbadvanced.lab.dto.EmployeeDTO;
import dbadvanced.lab.model.entity.Address;
import dbadvanced.lab.model.entity.City;
import dbadvanced.lab.model.entity.Employee;
import dbadvanced.lab.service.api.EmployeeService;
import dbadvanced.lab.util.ConverterUtil;
import dbadvanced.lab.util.MapperUtil;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@Controller
public class Terminal implements CommandLineRunner {

//    @Autowired
//    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public Terminal(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Address address = new Address(new City("Sofia"), "15 Tintyava Street");

        Employee employee01 = new Employee("Ivan", "Georgiev",
                simpleDateFormat.parse("1980-02-12"), address, BigDecimal.valueOf(1000.02));
        employeeService.registerEmployee(employee01);

        System.out.println(employee01);

        EmployeeDTO employeeDTO = ConverterUtil.convertEmployeeToEmployeeDTO(employee01);
        System.out.println("Employee DTO: " + employeeDTO);

//        ModelMapper modelMapper = new ModelMapper();
//        PropertyMap<Employee, EmployeeDTO> employeeDTOMap = new PropertyMap<Employee, EmployeeDTO>() {
//            protected void configure() {
//                map().setName(source.getFirstName());
//                //map(source.getAddress().getCity().getName(), destination.setAddressCityName());
//            }
//        };
//
//        modelMapper.addMappings(employeeDTOMap);
//        EmployeeDTO employeeDTO = modelMapper.map(employee01, EmployeeDTO.class);
//
//        System.out.println("EmployeeDTO: " + employeeDTO);

//        ExpressionMap<Employee, EmployeeDTO> exprMap01 =
//                m -> m.map(src -> src.getFirstName(),
//                        EmployeeDTO::setName);
//
//        EmployeeDTO employeeDTO1 = ConverterUtil.convertCustom(employee01,EmployeeDTO.class, new ExpressionMap[]
//                {exprMap01});

//        TypeMap<Employee, EmployeeDTO> typeMap = modelMapper.createTypeMap(Employee.class, EmployeeDTO.class)
//                .addMapping(Employee::getFirstName, EmployeeDTO::setName);
//        EmployeeDTO employeeDTO1 = typeMap.map(employee01);
//
//        System.out.println("EmployeeDTO with ExpressionMap: " + employeeDTO1);


//        ModelMapper mapper = new ModelMapper();
//        TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);
//
//        // чрез ExpressionMap Се прави мапване на всяко пропърти едно по едно
//        ExpressionMap<Employee, EmployeeDTO> expressionMap01 =
//                m -> m.map(src -> src.getFirstName(),
//                        EmployeeDTO::setName);
//
//        //Ако има повече ExpressionMap се добавят в Set и него го добавяме в TypeMap
//        Set<ExpressionMap> exprMaps = new HashSet<>();
//        exprMaps.add(expressionMap01);
//
//
//        //Set<ExpressionMap> го добавяме в TypeMap
//        for (ExpressionMap<Employee, EmployeeDTO> exprMap : exprMaps) {
//            typeMap.addMappings(exprMap);
//        }
//
//        EmployeeDTO employeeDTO = typeMap.map(employee01);
//
//        System.out.println("EmployeeDTO: " + employeeDTO);



    }
}
