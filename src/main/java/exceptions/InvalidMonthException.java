package exceptions;

public class InvalidMonthException extends Exception {

  private static final long serialVersionUID = 1L;

  public InvalidMonthException() {
    super("months cannot be less than 1 and greater than 12");
  }
}
