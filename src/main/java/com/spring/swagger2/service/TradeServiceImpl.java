package com.spring.swagger2.service;

import com.spring.swagger2.domain.Trade;
import com.spring.swagger2.repository.TradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by aditya.gupta2 on 10/5/2017.
 */

@Service
public class TradeServiceImpl implements TradeService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TradeRepository tradeRepository;


    @Override
    public Iterable<Trade> listAllTrades() {
        logger.debug("listing all the trades");
        return tradeRepository.findAll();
    }

    @Override
    public Trade getTradeById(Integer id) {
        logger.debug("finding the trade by id ",id);
        return tradeRepository.findOne(id);
    }

    @Override
    public Trade saveTrade(Trade trade) {
        logger.debug("saving the trade");
        return tradeRepository.save(trade);
    }

    @Override
    public void deleteTrade(Integer id) {
    logger.debug("deleting the trade with the id",id);
     tradeRepository.delete(id);
    }
}
