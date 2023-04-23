package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import entities.enums.Position;
import utils.NumberFormat;

public class Employee extends Person {

  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private BigDecimal salary;
  private Position position;

  public Employee(String name, LocalDate birthDate, BigDecimal salary, Position position) {
    super(name, birthDate);
    this.salary = salary;
    this.position = position;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
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
