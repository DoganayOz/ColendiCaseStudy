package com.payment.onlinePayment.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BaseOutputResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String output;
	
	private String errorCode;
	
	private String errorMessage;
	
	private String errorMessageDescription;
	
	private String description;
}
