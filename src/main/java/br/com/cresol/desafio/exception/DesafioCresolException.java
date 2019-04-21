package br.com.cresol.desafio.exception;

public class DesafioCresolException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public DesafioCresolException(Exception e) {
		super(e);
	}
	
	public DesafioCresolException( ) {
		super();
	}
	
	public DesafioCresolException(Exception e,String msg) {
		super(msg, e);
	}

	public DesafioCresolException(String msg) {
		super(msg);
	}

}
