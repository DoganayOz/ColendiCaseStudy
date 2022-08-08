package com.payment.onlinePayment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTransaction {
	@Id
	@GeneratedValue
	private int id;
	private int transactionTypeId;
	private int cardId;
	private int mId;
	private double amount;
	private Date transactionTime;
}
