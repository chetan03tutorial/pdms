package com.nataraj.management.auction.pdms.dao;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class QueryDslBaseRepositoryImpl<T, ID extends Serializable>
    extends QuerydslJpaPredicateExecutor<T> implements QueryDslBaseRepository<T,ID> {
        /*extends SimpleJpaRepository<T, ID> implements BaseRepository<T,ID> { */

    private final EntityManager em;

    public QueryDslBaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager, EntityPathResolver resolver, CrudMethodMetadata metadata) {
        super(entityInformation, entityManager, resolver, metadata);
        this.em = entityManager;
    }

    /*public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }*/

    @Override
    @Transactional
    public T customMethod() {
        return null;
    }
}
