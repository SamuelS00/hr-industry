package services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import entities.Employee;
import utils.NumberFormat;

public class EmployeeManager {

  private static BigDecimal minWage = BigDecimal.valueOf(1212.00);

  private List<Employee> employees;

  public EmployeeManager(List<Employee> employees) {
    this.employees = employees;
  }

  public void addEmployee(Employee employee) {
    this.employees.add(employee);
  }

  public Employee getEmployee(String name) {
    return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
  }

  public int size() {
    return employees.size();
  }

  public void removeEmployee(Employee employee) {
    this.employees.remove(employee);
  }

  public void updateSalariesByPercentage(double percentage) {
    final BigDecimal increasePercentage = BigDecimal.valueOf(percentage / 100);
    employees.forEach(e -> {
      BigDecimal increasedSalary = e.getSalary().multiply(BigDecimal.ONE.add(increasePercentage));
      BigDecimal increment = increasedSalary.subtract(e.getSalary());
      e.incrementSalary(increment);
    });
  }

  public Map<String, List<Employee>> groupEmployeesByPosition() {
    return employees.stream().collect(Collectors.groupingBy(Employee::getPosition));
  }

  public void printAllEmployees() {
    employees.forEach(System.out::println);
  }

  public void printEmployeesByBirthMonth(int month) {
    employees.forEach(e -> {
      int birthDate = e.getBirthDate().getMonthValue();
      if (birthDate == month) {
        System.out.println(e.toString());
      }
    });
  }

  public void printEmployeesInAlphabeticalOrder() {
    List<String> employeesName =
        employees.stream().map(Employee::getName).sorted().collect(Collectors.toList());
    employeesName.forEach(System.out::println);
  }

  public void printTotalSalaries() {
    BigDecimal totalSalary =
        employees.stream().map(Employee::getSalary).reduce(BigDecimal.ONE, BigDecimal::add);
    String formattedSalary = NumberFormat.format(totalSalary);
    System.out.println("Total Salary: R$ " + formattedSalary);
  }

  public void printSalaryInMinimumWage() {
    Function<Employee, String> employeeListFormat = e -> {
      return String.format("Name: %s, Minimum Wage: %s", e.getName(),
          NumberFormat.format(e.getSalary().divide(minWage, 2, RoundingMode.HALF_UP)));
    };

    List<String> employeesMinWage =
        employees.stream().map(employeeListFormat).collect(Collectors.toList());
    employeesMinWage.forEach(System.out::println);
  }
}
