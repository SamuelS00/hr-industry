package application;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import entities.Employee;
import exceptions.InvalidMonthException;
import services.EmployeeManager;
import utils.DataInitializer;
import utils.TitleLog;

public class Main {

  public static void main(String[] args) {

    TitleLog.execute("Inserir todos os funcionários, na mesma ordem da tabela.");
    List<Employee> employees = DataInitializer.initialize();
    EmployeeManager employeeManager = new EmployeeManager(employees);
    TitleLog.linebreak();

    TitleLog.execute("Remover o funcionário “João” da lista.");
    Optional<Employee> employee = Optional.ofNullable(employeeManager.getEmployee("João"));
    if (employee.isPresent()) {
      employeeManager.removeEmployee(employee.get());
    }
    TitleLog.linebreak();

    TitleLog.execute("Imprimir todos os funcionários com todas suas informações:");
    employeeManager.printAllEmployees();
    TitleLog.linebreak();

    TitleLog.execute("Atualizar a lista de funcionários com aumento de salário de 10%.");
    employeeManager.updateSalariesByPercentage(10.0);
    TitleLog.linebreak();

    TitleLog.execute("Agrupar e Imprimir os funcionários, agrupados por função: ");
    Map<String, List<Employee>> employeesByPosition = employeeManager.groupEmployeesByPosition();
    employeesByPosition.forEach((p, e) -> {
      List<String> employeesName = e.stream().map(e2 -> e2.getName()).collect(Collectors.toList());
      System.out.printf("Position: %s, Employees: %s%n", p, employeesName.toString());
    });
    TitleLog.linebreak();

    try {
      TitleLog.execute("Imprimir os funcionários que fazem aniversário no mês 10 e 12: ");
      employeeManager.printEmployeesByBirthMonth(10);
      employeeManager.printEmployeesByBirthMonth(12);
      TitleLog.linebreak();
    } catch (InvalidMonthException e) {
      e.printStackTrace();
    }

    TitleLog.execute("Imprimir a lista de funcionários por ordem alfabética: ");
    employeeManager.printEmployeesInAlphabeticalOrder();
    TitleLog.linebreak();

    TitleLog.execute("Imprimir o total dos salários dos funcionários: ");
    employeeManager.printTotalSalaries();
    TitleLog.linebreak();

    TitleLog.execute("Imprimir quantos salários mínimos ganha cada funcionário: ");
    employeeManager.printSalaryInMinimumWage();
    TitleLog.linebreak();
  }
}
