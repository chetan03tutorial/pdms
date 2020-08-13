package com.nataraj.management.auction.pdms.dao;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

public interface QueryDslBaseRepository<T,ID extends Serializable> extends Repository<T, ID>,
        QuerydslPredicateExecutor<T> {

    // Add my custom methods here
    public T customMethod();
}
