package eng.cpe.se.project.security.exception;

public class AccountAlreadyExistException extends RuntimeException {

	private String message;

	public AccountAlreadyExistException() {
		
	}

	public AccountAlreadyExistException(String msg)
    {
        super(msg);
        this.setMessage(msg);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
