package com.spring.swagger2.service;

import com.spring.swagger2.domain.Trade;

/**
 * Created by aditya.gupta2 on 10/5/2017.
 */
public interface TradeService {

     Iterable<Trade> listAllTrades();
     Trade getTradeById(final Integer id);
     Trade saveTrade(Trade trade);
     void deleteTrade(Integer id);

}
