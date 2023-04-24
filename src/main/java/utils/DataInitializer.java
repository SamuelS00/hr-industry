package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entities.Employee;
import entities.enums.Position;
import exceptions.NegativeSalaryException;

public class DataInitializer {

  public static List<Employee> initialize() {
    String path = "src/main/resources/employees.csv";
    List<Employee> employees = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();
      while (line != null) {
        String[] fields = line.split(",");
        String name = fields[0];

        LocalDate birthDate = convertStringToLocalDate(fields[1]);
        BigDecimal salary = new BigDecimal(fields[2]);
        Position position = Position.fromString(fields[3]);
        Employee employee = new Employee(name, birthDate, salary, position);

        employees.add(employee);
        line = br.readLine();
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (NegativeSalaryException e) {
      System.out.println("Error: " + e.getMessage());
    }

    return employees;
  }

  private static LocalDate convertStringToLocalDate(String dateString) {
    return LocalDate.of(Integer.parseInt(dateString.substring(6)),
        Integer.parseInt(dateString.substring(3, 5)), Integer.parseInt(dateString.substring(0, 2)));
  }
}
