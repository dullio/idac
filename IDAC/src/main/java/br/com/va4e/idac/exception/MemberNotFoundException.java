package br.com.va4e.idac.exception;

public class MemberNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1530946884775826469L;

	public MemberNotFoundException(String exception) {
		super(exception);
	}

}