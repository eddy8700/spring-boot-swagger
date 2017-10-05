package com.spring.swagger2.bootstrap;

import com.spring.swagger2.domain.Trade;
import com.spring.swagger2.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by aditya.gupta2 on 10/5/2017.
 */

@Component
public class SpringJpaBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private TradeRepository tradeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadTrades();
    }

    private void loadTrades() {
        Trade trade= new Trade();
        trade.setDescription("ICICI lombard");
        trade.setPrice(new BigDecimal(175));
        trade.setTradeId("T001");
        trade.setTradeName("ICICILOM");
        tradeRepository.save(trade);

        Trade trade1= new Trade();
        trade.setDescription("APEX Froxen");
        trade.setPrice(new BigDecimal(661));
        trade.setTradeId("T002");
        trade.setTradeName("APEXFRZ");
        tradeRepository.save(trade1);


    }
}
