package com.payment.onlinePayment.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PurchaseRequest {
	private int cardId;
	private int mid;
	private double amount; 
}
