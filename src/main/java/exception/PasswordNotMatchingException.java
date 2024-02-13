package exception;

public class PasswordNotMatchingException extends RuntimeException {
  public PasswordNotMatchingException(String msg) {
    super(msg);
  }
}
