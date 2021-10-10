package ua.com.alevel;

import ua.com.alevel.entity.Table;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.MapperCSV;
import ua.com.alevel.service.ParserCSV;

import java.util.List;

public class MapperMain {
    public static void main(String[] args) {

        ParserCSV parserCSV = new ParserCSV();
        MapperCSV mapperCSV = new MapperCSV();
        Table table = parserCSV.parse(args[0]);

        List<Employee> list = mapperCSV.getObject(Employee.class, table);
        for(Employee employee:list) {
            System.out.println(employee);
        }

    }
}
