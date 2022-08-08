package com.payment.onlinePayment.util;

public final class ExceptionCodes {
	
	public enum EXCEPTION_CODE{
		SUCCESS("000"),
		SYSTEM_ERROR("001"),
		VALIDATON_ERROR("002");
		
		private String code;
		
		EXCEPTION_CODE(String code){
			this.code = code;
		}
		
		public String getCode() {
			return this.code;
		}
		
		public static EXCEPTION_CODE getByKod(String code) {
			for(EXCEPTION_CODE exceptionCode : EXCEPTION_CODE.values()) {
				if(exceptionCode.getCode().equals(code)) {
					return exceptionCode;
				}
			}
			return null;
		}
		
	}

}
