package exceptions;

public class NegativeSalaryException extends Exception {

  private static final long serialVersionUID = 1L;

  public NegativeSalaryException() {
    super("Salary cannot be negative");
  }
}
