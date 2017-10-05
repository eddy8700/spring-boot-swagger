package com.spring.swagger2.repository;

import com.spring.swagger2.domain.Trade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by aditya.gupta2 on 10/5/2017.
 */
@RepositoryRestResource
public interface TradeRepository extends CrudRepository<Trade,Integer> {
}
