package entities;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import entities.enums.Position;

public class EmployeeTest {

  @Test
  @DisplayName("test the employee class getSalary")
  public void testGetSalary() {
    BigDecimal salary = new BigDecimal("1000.00");
    Employee employee =
        new Employee("John Doe", LocalDate.of(1990, 1, 1), salary, Position.CONTADOR);
    assertEquals(salary, employee.getSalary());
  }

  @Test
  @DisplayName("test the employee class setSalary")
  public void testSetSalary() {
    BigDecimal initialSalary = new BigDecimal("1000.00");
    BigDecimal newSalary = new BigDecimal("1500.00");
    Employee employee =
        new Employee("John Doe", LocalDate.of(1990, 1, 1), initialSalary, Position.CONTADOR);
    employee.setSalary(newSalary);
    assertEquals(newSalary, employee.getSalary());
  }

  @Test
  @DisplayName("test the employee class getPostion")
  public void testGetPosition() {
    Employee employee = new Employee("John Doe", LocalDate.of(1990, 1, 1),
        new BigDecimal("1000.00"), Position.DIRETOR);
    assertEquals("Diretor", employee.getPosition());
  }

  @Test
  @DisplayName("test the employee class setPosition")
  public void testSetPosition() {
    Employee employee = new Employee("John Doe", LocalDate.of(1990, 1, 1),
        new BigDecimal("1000.00"), Position.ELETRICISTA);
    employee.setPosition(Position.ELETRICISTA);
    assertEquals("Eletricista", employee.getPosition());
  }

  @Test
  @DisplayName("test the employee class toString")
  public void testToString() {
    Employee employee = new Employee("John Doe", LocalDate.of(1990, 1, 1),
        new BigDecimal("1000.00"), Position.GERENTE);
    String expected =
        "Name: John Doe, Position: Gerente, Salary: R$ 1.000,00, Birthdate: 01/01/1990";
    assertEquals(expected, employee.toString());
  }

}
