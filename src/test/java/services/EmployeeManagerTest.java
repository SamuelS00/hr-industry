package services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import entities.Employee;
import entities.enums.Position;
import exceptions.InvalidMonthException;
import exceptions.NegativeSalaryException;
import utils.DataInitializer;

public class EmployeeManagerTest {

  private EmployeeManager employeeManager;
  private List<Employee> employees = new ArrayList<>();

  @BeforeEach
  public void setup() {
    employees = DataInitializer.initialize();
    employeeManager = new EmployeeManager(employees);
  }

  public Employee createEmployee() {
    Employee employee = null;
    try {
      employee = new Employee("Lucas", LocalDate.of(1998, 3, 11), new BigDecimal("5000"),
          Position.CONTADOR);
    } catch (NegativeSalaryException e) {
      e.printStackTrace();
    }
    return employee;
  };

  @Test
  @DisplayName("Test addEmployee() method with valid input")
  public void testAddEmployee() {
    Employee employee = createEmployee();
    employeeManager.addEmployee(employee);
    assertNotNull(employee);
    assertEquals(11, employeeManager.size());
  }

  @Test
  @DisplayName("Test getEmployee() method")
  public void testGetEmployee() {
    Employee employee = employeeManager.getEmployee("João");
    assertNotNull(employee);
    assertEquals("João", employee.getName());
  }

  @Test
  @DisplayName("Test size() method")
  public void testSize() {
    assertEquals(10, employees.size());
  }

  @Test
  @DisplayName("Test removeEmployee() method")
  public void testRemoveEmployee() {
    Employee employee = employeeManager.getEmployee("Miguel");
    employeeManager.removeEmployee(employee);
    assertEquals(9, employeeManager.size());
    assertNull(employeeManager.getEmployee("Miguel"));
  }

  @Test
  @DisplayName("Test updateSalariesByPercentage method")
  public void testUpdateSalariesByPercentage() {
    double percentage = 10.0;
    employeeManager.updateSalariesByPercentage(percentage);
    BigDecimal expectedNewSalary = new BigDecimal(2210.384).setScale(3, RoundingMode.HALF_UP);
    assertEquals(expectedNewSalary, employeeManager.getEmployee("Maria").getSalary());

  }

  @Test
  @DisplayName("Test groupEmployeesByPosition() method")
  public void testGroupEmployeesByPosition() {
    Map<String, List<Employee>> employeesByPosition = employeeManager.groupEmployeesByPosition();
    assertEquals(7, employeesByPosition.size());
    assertEquals(3, employeesByPosition.get("Operador").size());
    assertEquals(2, employeesByPosition.get("Gerente").size());
  }

  @Test
  @DisplayName("Test printAllEmployees() method")
  void testPrintAllEmployees() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    employeeManager.printAllEmployees();
    String expectedOutput =
        "Name: Maria, Position: Operador, Salary: R$ 2.009,44, Birthdate: 18/10/2000\n"
            + "Name: João, Position: Operador, Salary: R$ 2.284,38, Birthdate: 12/05/1990\n"
            + "Name: Caio, Position: Coordenador, Salary: R$ 9.836,14, Birthdate: 02/05/1961\n"
            + "Name: Miguel, Position: Diretor, Salary: R$ 19.119,88, Birthdate: 14/10/1988\n"
            + "Name: Alice, Position: Recepcionista, Salary: R$ 2.234,68, Birthdate: 05/01/1995\n"
            + "Name: Heitor, Position: Operador, Salary: R$ 1.582,72, Birthdate: 19/11/1999\n"
            + "Name: Arthur, Position: Contador, Salary: R$ 4.071,84, Birthdate: 31/03/1993\n"
            + "Name: Laura, Position: Gerente, Salary: R$ 3.017,45, Birthdate: 08/07/1994\n"
            + "Name: Heloísa, Position: Eletricista, Salary: R$ 1.606,85, Birthdate: 24/05/2003\n"
            + "Name: Helena, Position: Gerente, Salary: R$ 2.799,93, Birthdate: 02/09/1996\n";

    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  @DisplayName("Test printEmployeesByBirthMonth() method")
  void testPrintEmployeesByBirthMonth() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    try {
      employeeManager.printEmployeesByBirthMonth(10);
    } catch (InvalidMonthException e) {
      e.printStackTrace();
    }

    String expectedOutput =
        "Name: Maria, Position: Operador, Salary: R$ 2.009,44, Birthdate: 18/10/2000\n"
            + "Name: Miguel, Position: Diretor, Salary: R$ 19.119,88, Birthdate: 14/10/1988\n";

    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  @DisplayName("Test exception throwing for invalid month in the printEmployeesBybirthMonth method")
  void testPrintEmployeesBybirthMonthInvalidMonth() {
    assertThrows(InvalidMonthException.class, () -> {
      employeeManager.printEmployeesByBirthMonth(13);
      fail("Should throw an exception InvalidMonthException");
    });
  }

  @Test
  @DisplayName("Test printEmployeesInAlphabeticalOrder() method")
  void testPrintEmployeesInAlphabeticalOrder() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    EmployeeManager employeeManager = new EmployeeManager(employees);
    employeeManager.printEmployeesInAlphabeticalOrder();

    String expectedOutput = "Alice\n" + "Arthur\n" + "Caio\n" + "Heitor\n" + "Helena\n"
        + "Heloísa\n" + "João\n" + "Laura\n" + "Maria\n" + "Miguel\n";

    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  @DisplayName("Test printTotalSalaries() method")
  void testPrintTotalSalaries() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    EmployeeManager employeeManager = new EmployeeManager(employees);
    employeeManager.printTotalSalaries();

    String expectedOutput = "Total Salary: R$ 48.564,31\n";

    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  @DisplayName("Test printSalaryInMinimumWage() method")
  public void testPrintSalaryInMinimumWage() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    System.setOut(printStream);

    employeeManager.printSalaryInMinimumWage();

    String expectedOutput = "Name: Maria, Minimum Wage: 1,66\n" + "Name: João, Minimum Wage: 1,88\n"
        + "Name: Caio, Minimum Wage: 8,12\n" + "Name: Miguel, Minimum Wage: 15,78\n"
        + "Name: Alice, Minimum Wage: 1,84\n" + "Name: Heitor, Minimum Wage: 1,31\n"
        + "Name: Arthur, Minimum Wage: 3,36\n" + "Name: Laura, Minimum Wage: 2,49\n"
        + "Name: Heloísa, Minimum Wage: 1,33\n" + "Name: Helena, Minimum Wage: 2,31\n";
    assertEquals(expectedOutput, outputStream.toString());
  }

}
