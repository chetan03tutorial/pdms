package com.nataraj.management.auction.pdms.dao;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

public class SimpleJpaBaseRepositoryImpl<T,ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements SimpleJpaBaseRepository<T,ID> {

    private final EntityManager em;

    public SimpleJpaBaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    @Override
    @Transactional
    public T customMethod() {
        return null;
    }
}
