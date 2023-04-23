package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberFormat {

  private NumberFormat() {}

  public static <T> String format(T number) {
    DecimalFormat decimalFormat =
        new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    return decimalFormat.format(number);
  }
}
