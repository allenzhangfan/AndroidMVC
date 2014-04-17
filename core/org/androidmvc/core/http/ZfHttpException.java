package org.androidmvc.core.http;

public class ZfHttpException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ZfHttpException() {}
	
	
	public ZfHttpException(String msg) {
		super(msg);
	}
	
	public ZfHttpException(Throwable ex) {
		super(ex);
	}
	
	public ZfHttpException(String msg,Throwable ex) {
		super(msg,ex);
	}
	
}
