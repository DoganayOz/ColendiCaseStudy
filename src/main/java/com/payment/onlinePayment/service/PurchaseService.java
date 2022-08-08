package com.payment.onlinePayment.service;

import com.payment.onlinePayment.bean.BaseOutputResponse;
import com.payment.onlinePayment.bean.PurchaseRequest;

public interface PurchaseService {
	BaseOutputResponse validateCardAndPayment(PurchaseRequest input);

}
