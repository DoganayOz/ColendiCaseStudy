package com.payment.onlinePayment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.onlinePayment.bean.CardScopeRequest;
import com.payment.onlinePayment.dao.CardScopeRepository;
import com.payment.onlinePayment.dao.MerchantCategoryRepository;
import com.payment.onlinePayment.model.CardScope;
import com.payment.onlinePayment.model.Merchant;
import com.payment.onlinePayment.model.MerchantCategory;

@Service
public class CardScopeServiceImpl implements CardScopeService {
	
    @Autowired
	private CardScopeRepository cardScopeRepository;
    
    @Autowired
    private MerchantCategoryRepository merchantCategoryRepository;

	@Override
	public CardScope addCardScope(CardScopeRequest input) {
		MerchantCategory merchantCategory = new MerchantCategory();
		CardScope cardScope = new CardScope();
		String mcc = input.getMcc();
		if(input.getMcc().isEmpty() && input.getMcc() == null) {
			merchantCategory = merchantCategoryRepository.findById(input.getMid());
			mcc = merchantCategory.getMcc();
		}
		cardScope.setMcc(mcc);
		cardScope.setCardId(input.getCardId());
		cardScope.setMid(input.getMid());
		
		return cardScopeRepository.save(cardScope);
	}

	@Override
	public List<CardScope> findByCardId(int cardId) {
		return cardScopeRepository.findByCardId(cardId);
	}

}
