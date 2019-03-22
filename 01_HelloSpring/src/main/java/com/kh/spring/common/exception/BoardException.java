package com.kh.spring.common.exception;

public class BoardException extends RuntimeException {

	public BoardException() {
		super();
	}
	
	public BoardException(String msg) {
		super(msg);
	}
}
