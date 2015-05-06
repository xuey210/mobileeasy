package demo.error;

/**
 * 错误信息处理
 * 
 * @author jiekechoo
 *
 */
public class ErrorMessage {

	private int code;
	private String message;

	public ErrorMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
