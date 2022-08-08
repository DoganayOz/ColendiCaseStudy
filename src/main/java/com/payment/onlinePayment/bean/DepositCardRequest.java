package com.payment.onlinePayment.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class DepositCardRequest {
	private int cardId;
	private double amount;
}
