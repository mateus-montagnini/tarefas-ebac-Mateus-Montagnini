package br.com.mrocha.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

    
	private static final long serialVersionUID = -1389494676398525746L;

	public TipoChaveNaoEncontradaException(String message) {
        this(message, null);
    }

    public TipoChaveNaoEncontradaException(String message, Throwable exception) {
        super(message, exception);
    }
}
