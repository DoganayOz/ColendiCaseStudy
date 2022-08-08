package com.payment.onlinePayment.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CardRequest {
	private int cardId;
	private int cvv;
	private Date expireDate; 
}
