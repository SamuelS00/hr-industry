package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import entities.enums.Position;
import exceptions.NegativeSalaryException;
import utils.NumberFormat;

public class Employee extends Person {

  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private BigDecimal salary;
  private Position position;

  public Employee(String name, LocalDate birthDate, BigDecimal salary, Position position)
      throws NegativeSalaryException {
    super(name, birthDate);

    if (salary.compareTo(BigDecimal.ZERO) < 0) {
      throw new NegativeSalaryException();
    }

    this.salary = salary;
    this.position = position;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void incrementSalary(BigDecimal salary) {
    BigDecimal newSalary = this.salary.add(salary);
    this.salary = newSalary;
  }

  public String getPosition() {
    return position.getPositionName();
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  @Override
  public String toString() {

    StringBuilder str = new StringBuilder();
    String formattedBirthDate = getBirthDate().format(fmt);
    String formattedSalary = NumberFormat.format(getSalary());

    str.append("Name: ");
    str.append(getName());
    str.append(", Position: ");
    str.append(getPosition());
    str.append(", Salary: R$ ");
    str.append(formattedSalary);
    str.append(", Birthdate: ");
    str.append(formattedBirthDate);

    return str.toString();
  }
}
