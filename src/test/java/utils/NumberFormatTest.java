package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberFormatTest {

  @Test
  @DisplayName("Test format() method with Integer input")
  public void testFormatInteger() {
    int number = 1000;
    String formattedNumber = NumberFormat.format(number);
    assertEquals("1.000,00", formattedNumber);
  }

  @Test
  @DisplayName("Test format() method with Double input")
  public void testFormatDouble() {
    double number = 1234.567;
    String formattedNumber = NumberFormat.format(number);
    assertEquals("1.234,57", formattedNumber);
  }

  @Test
  @DisplayName("Test format() method with BigDecimal input")
  public void testFormatBigDecimal() {
    String numberString = "1234.567";
    BigDecimal number = new BigDecimal(numberString);
    String formattedNumber = NumberFormat.format(number);
    assertEquals("1.234,57", formattedNumber);
  }

}
