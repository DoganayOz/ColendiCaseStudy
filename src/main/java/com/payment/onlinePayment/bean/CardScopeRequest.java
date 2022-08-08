package com.payment.onlinePayment.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CardScopeRequest {
	private int cardId;
	private int mid;
	private String mcc; 
}
