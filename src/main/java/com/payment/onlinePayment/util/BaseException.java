package com.payment.onlinePayment.util;

import lombok.Getter;
import lombok.Setter;

public class BaseException extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String hataKodu;
	
	@Getter
	@Setter
	private String ekHataAciklama;
	
	public BaseException() {
		super();
	}
	
	public BaseException(Throwable throwable) {
		super(throwable);
	}

}
