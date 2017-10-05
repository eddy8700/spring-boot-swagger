package com.spring.swagger2.controller;

import com.spring.swagger2.domain.Trade;
import com.spring.swagger2.service.TradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aditya.gupta2 on 10/5/2017.
 */

@RestController
@RequestMapping("/trade")
@Api(value="tradeCRUD", description="Operations pertaining to trades")
public class TradeController {

    @Autowired
    private TradeService tradeService;


    @ApiOperation(value = "View a list of available trades", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable listAllTrades() {
        Iterable tradeList = tradeService.listAllTrades();
        return tradeList;
    }


    @ApiOperation(value = "Search a trade with the ID", response = Trade.class)
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET, produces = "application/json")
    public Trade findTradeById(@PathVariable Integer id, Model model) {
        Trade trade = tradeService.getTradeById(id);
        return trade;
    }

    @ApiOperation(value = "Save a trade")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveTrade(@RequestBody Trade trade) {
        tradeService.saveTrade(trade);
        return new ResponseEntity(HttpStatus.OK);

    }

    @ApiOperation(value = "Update a trade")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateTrade(@PathVariable Integer id, @RequestBody Trade trade) {
        Trade savedTrade = tradeService.getTradeById(id);
        savedTrade.setTradeName(trade.getTradeName());
        savedTrade.setPrice(trade.getPrice());
        tradeService.saveTrade(savedTrade);
        return new ResponseEntity("trade updated successfully", HttpStatus.OK);
    }

    @ApiOperation("Delete a trade")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteTrade(@PathVariable Integer id) {
        tradeService.deleteTrade(id);
        return new ResponseEntity("deleted trade", HttpStatus.OK);
    }
}

