package com.payment.onlinePayment.model;

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
public class MerchantCategory {
	@Id
	@GeneratedValue
	private int id;
	private String mcc;
	private String description;
}
