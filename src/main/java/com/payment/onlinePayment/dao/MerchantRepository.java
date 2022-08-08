package com.payment.onlinePayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.onlinePayment.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{

}
