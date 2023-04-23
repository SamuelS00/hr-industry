package entities.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

  @Test
  @DisplayName("Test getPositionName() method")
  public void testGetPositionName() {
    assertEquals("Operador", Position.OPERADOR.getPositionName());
    assertEquals("Coordenador", Position.COORDENADOR.getPositionName());
    assertEquals("Diretor", Position.DIRETOR.getPositionName());
    assertEquals("Recepcionista", Position.RECEPCIONISTA.getPositionName());
    assertEquals("Contador", Position.CONTADOR.getPositionName());
    assertEquals("Gerente", Position.GERENTE.getPositionName());
    assertEquals("Eletricista", Position.ELETRICISTA.getPositionName());
  }

  @Test
  @DisplayName("Test fromString() method with valid position name")
  public void testFromStringValid() {
    assertEquals(Position.OPERADOR, Position.fromString("Operador"));
    assertEquals(Position.COORDENADOR, Position.fromString("Coordenador"));
    assertEquals(Position.DIRETOR, Position.fromString("Diretor"));
    assertEquals(Position.RECEPCIONISTA, Position.fromString("Recepcionista"));
    assertEquals(Position.CONTADOR, Position.fromString("Contador"));
    assertEquals(Position.GERENTE, Position.fromString("Gerente"));
    assertEquals(Position.ELETRICISTA, Position.fromString("Eletricista"));
  }

  @Test
  @DisplayName("Test fromString() method with invalid position name")
  public void testFromStringInvalid() {
    assertThrows(IllegalArgumentException.class, () -> Position.fromString("Invalid Position"));
  }

}
