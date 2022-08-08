package com.payment.onlinePayment.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payment.onlinePayment.bean.CardRequest;
import com.payment.onlinePayment.model.Card;
import com.payment.onlinePayment.service.CardService;

@RestController
@RequestMapping("/Card")
public class CardController {
	
	@Autowired
	private CardService cardService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Card addCard(@RequestBody Card card) {
	    return cardService.addCard(card);
	}

	
    @RequestMapping(method = RequestMethod.PUT, path = "/reIssueCard")
    public Card reIssueCard(@Valid @RequestBody CardRequest input) {  
    	 return  cardService.reIssueCard(input);
    }
    
	@GetMapping("/{userId}")
	public List<Card> getCardsByUserId(@PathVariable int userId){
	    return cardService.getCardsByUserId(userId);
	}
    
    @PutMapping("/cancelCard/{cardId}")
    public Integer cancelCard(@PathVariable int cardId) throws SQLException {  
	    return cardService.cancelCard(cardId);
	}
}
