package com.payment.onlinePayment.util;

import lombok.Getter;
import lombok.Setter;

public class OnlinePaymentException extends BaseException {
	
	private static final long serialVersionUID = 1L;
	
	public OnlinePaymentException() {
		super();
	}
	
	public OnlinePaymentException(Throwable throwable) {
		super(throwable);
	}
	
	public OnlinePaymentException(String hataKodu, String ekHataAciklama) {
		this.setHataKodu(hataKodu);
		this.setEkHataAciklama(ekHataAciklama);
	}

}
