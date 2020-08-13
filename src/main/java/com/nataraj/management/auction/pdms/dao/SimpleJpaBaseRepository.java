package com.nataraj.management.auction.pdms.dao;

import com.nataraj.management.auction.pdms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.Optional;

public interface SimpleJpaBaseRepository<T,ID extends Serializable> extends JpaRepository<T, ID>{
    // Add my custom methods here
    public T customMethod();
}
