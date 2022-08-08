package com.payment.onlinePayment.service;

import org.slf4j.Logger;

import com.payment.onlinePayment.bean.BaseOutputResponse;
import com.payment.onlinePayment.util.ExceptionCodes.EXCEPTION_CODE;
import com.payment.onlinePayment.util.OnlinePaymentException;

public class BaseService {

	protected <T> T exceptionResult(T output, Exception e, final Logger LOGGER) {
		OnlinePaymentException onlinePaymentException = createOnlinePaymentException(e, LOGGER);
		
		BaseOutputResponse baseResult = new BaseOutputResponse();
		baseResult.setErrorCode(onlinePaymentException.getHataKodu());
		baseResult.setErrorMessage(onlinePaymentException.getMessage());
		baseResult.setErrorMessageDescription(onlinePaymentException.getEkHataAciklama());
		baseResult.setOutput("0");
		
		return (T) baseResult;
	}
	
	private OnlinePaymentException createOnlinePaymentException(Exception e, final Logger LOGGER) {
		OnlinePaymentException onlinePaymentException;
		if(e instanceof OnlinePaymentException) {
			onlinePaymentException = (OnlinePaymentException) e;
		}else {
			LOGGER.error("HATA", e);
			String messageDescription = descriptionMaxSize(e.getMessage(), 3000);
			onlinePaymentException = new OnlinePaymentException(EXCEPTION_CODE.SYSTEM_ERROR.getCode(), messageDescription);
		}
		return onlinePaymentException;
	}
	
	public static String descriptionMaxSize(String str, int maxSize) {
		if(str == null || str == "") {
			return "";
		}
		if(str.trim().length() > maxSize) {
			return str.trim().substring(0, maxSize);
		}
		return str.trim();
	}
	
	protected <T> T completeResponseResult(T output, String errorCode, String errorMessage) {
		BaseOutputResponse baseResult = (BaseOutputResponse) output;
		
		baseResult.setErrorCode(errorCode);
		baseResult.setErrorMessage(errorMessage);
		
		return (T) baseResult;
	}
}
