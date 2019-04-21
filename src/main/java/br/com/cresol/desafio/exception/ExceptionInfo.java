package br.com.cresol.desafio.exception;

public class ExceptionInfo {

    private String message;
    private String error;

    public ExceptionInfo(String message) {
        this.setMessage(message);
    }

    public ExceptionInfo(String message, String error) {
        this.setMessage(message);
        this.setError(error);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
    
    
}
