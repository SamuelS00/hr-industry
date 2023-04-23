package utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entities.Employee;
import entities.enums.Position;

public class DataInitializerTest {

  @Test
  public void shouldInitializeEmployees() {
    List<Employee> employees = DataInitializer.initialize();
    Assertions.assertEquals(10, employees.size());

    // Employee 1
    Employee employee1 = employees.get(0);
    Assertions.assertEquals("Maria", employee1.getName());
    Assertions.assertEquals(LocalDate.of(2000, 10, 18), employee1.getBirthDate());
    Assertions.assertEquals(new BigDecimal("2009.44"), employee1.getSalary());
    Assertions.assertEquals(Position.OPERADOR.getPositionName(), employee1.getPosition());

    // Employee 2
    Employee employee2 = employees.get(1);
    Assertions.assertEquals("João", employee2.getName());
    Assertions.assertEquals(LocalDate.of(1990, 5, 12), employee2.getBirthDate());
    Assertions.assertEquals(new BigDecimal("2284.38"), employee2.getSalary());
    Assertions.assertEquals(Position.OPERADOR.getPositionName(), employee2.getPosition());

    // Employee 3
    Employee employee3 = employees.get(2);
    Assertions.assertEquals("Caio", employee3.getName());
    Assertions.assertEquals(LocalDate.of(1961, 5, 2), employee3.getBirthDate());
    Assertions.assertEquals(new BigDecimal("9836.14"), employee3.getSalary());
    Assertions.assertEquals(Position.COORDENADOR.getPositionName(), employee3.getPosition());

    // Employee 4
    Employee employee4 = employees.get(3);
    Assertions.assertEquals("Miguel", employee4.getName());
    Assertions.assertEquals(LocalDate.of(1988, 10, 14), employee4.getBirthDate());
    Assertions.assertEquals(new BigDecimal("19119.88"), employee4.getSalary());
    Assertions.assertEquals(Position.DIRETOR.getPositionName(), employee4.getPosition());

    // Employee 5
    Employee employee5 = employees.get(4);
    Assertions.assertEquals("Alice", employee5.getName());
    Assertions.assertEquals(LocalDate.of(1995, 1, 5), employee5.getBirthDate());
    Assertions.assertEquals(new BigDecimal("2234.68"), employee5.getSalary());
    Assertions.assertEquals(Position.RECEPCIONISTA.getPositionName(), employee5.getPosition());

    // Employee 6
    Employee employee6 = employees.get(5);
    Assertions.assertEquals("Heitor", employee6.getName());
    Assertions.assertEquals(LocalDate.of(1999, 11, 19), employee6.getBirthDate());
    Assertions.assertEquals(new BigDecimal("1582.72"), employee6.getSalary());
    Assertions.assertEquals(Position.OPERADOR.getPositionName(), employee6.getPosition());

    // Employee 7
    Employee employee7 = employees.get(6);
    Assertions.assertEquals("Arthur", employee7.getName());
    Assertions.assertEquals(LocalDate.of(1993, 3, 31), employee7.getBirthDate());
    Assertions.assertEquals(new BigDecimal("4071.84"), employee7.getSalary());
    Assertions.assertEquals(Position.CONTADOR.getPositionName(), employee7.getPosition());

    // Employee 8
    Employee employee8 = employees.get(7);
    Assertions.assertEquals("Laura", employee8.getName());
    Assertions.assertEquals(LocalDate.of(1994, 7, 8), employee8.getBirthDate());
    Assertions.assertEquals(new BigDecimal("3017.45"), employee8.getSalary());
    Assertions.assertEquals(Position.GERENTE.getPositionName(), employee8.getPosition());

    // Employee 9
    Employee employee9 = employees.get(8);
    Assertions.assertEquals("Heloísa", employee9.getName());
    Assertions.assertEquals(LocalDate.of(2003, 5, 24), employee9.getBirthDate());
    Assertions.assertEquals(new BigDecimal("1606.85"), employee9.getSalary());
    Assertions.assertEquals(Position.ELETRICISTA.getPositionName(), employee9.getPosition());

    // Employee 10
    Employee employee10 = employees.get(9);
    Assertions.assertEquals("Helena", employee10.getName());
    Assertions.assertEquals(LocalDate.of(1996, 9, 2), employee10.getBirthDate());
    Assertions.assertEquals(new BigDecimal("2799.93"), employee10.getSalary());
    Assertions.assertEquals(Position.GERENTE.getPositionName(), employee10.getPosition());

  }

}
