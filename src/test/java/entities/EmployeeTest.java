package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import entities.enums.Position;
import exceptions.NegativeSalaryException;

public class EmployeeTest {

  public Employee createEmployee() {
    Employee employee = null;
    try {
      employee = new Employee("John Doe", LocalDate.of(1990, 1, 1), new BigDecimal("1000.00"),
          Position.CONTADOR);
    } catch (NegativeSalaryException e) {
      e.printStackTrace();
    }
    return employee;
  }

  @Test
  @DisplayName("test the employee class getSalary")
  public void testGetSalary() {
    BigDecimal salary = new BigDecimal("1000.00");
    Employee employee = createEmployee();
    assertNotNull(employee);
    assertEquals(salary, employee.getSalary());
  }

  @Test
  @DisplayName("test the employee class incrementSalary")
  public void testIncrementSalary() {
    BigDecimal increment = new BigDecimal("500.00");
    BigDecimal newSalary = new BigDecimal("1500.00");
    Employee employee = createEmployee();
    employee.incrementSalary(increment);
    assertNotNull(employee);
    assertEquals(newSalary, employee.getSalary());
  }

  @Test
  @DisplayName("test the employee class getPostion")
  public void testGetPosition() {
    Employee employee = createEmployee();
    assertNotNull(employee);
    assertEquals("Contador", employee.getPosition());
  }

  @Test
  @DisplayName("test the employee class setPosition")
  public void testSetPosition() {
    Employee employee = createEmployee();
    employee.setPosition(Position.ELETRICISTA);
    assertNotNull(employee);
    assertEquals("Eletricista", employee.getPosition());
  }

  @Test
  @DisplayName("test the employee class toString")
  public void testToString() {
    Employee employee = createEmployee();
    String expected =
        "Name: John Doe, Position: Contador, Salary: R$ 1.000,00, Birthdate: 01/01/1990";
    assertNotNull(employee);
    assertEquals(expected, employee.toString());
  }

}
