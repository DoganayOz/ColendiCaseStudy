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
public class Card {
	@Id
	@GeneratedValue
	private int id;
	private int userId;
	private String cardNo;
	private int cvv;
	private Date expireDate;
	private String status;
}
