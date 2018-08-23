package com.dev.dapp.ethereum.exception;

/**
 * The Class DAppException.
 */
public class DAppException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8610919568657060940L;

	/**
	 * Instantiates a new d app exception.
	 *
	 * @param msg
	 *            the msg
	 */
	public DAppException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new d app exception.
	 *
	 * @param msg
	 *            the msg
	 * @param t
	 *            the throwable
	 */
	public DAppException(String msg, Throwable t) {
		super(msg, t);
	}

}
