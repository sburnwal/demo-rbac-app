package demo.rbacapp.exception;

public class RbacException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RbacException(String s) {
		super(s);
	}
}
