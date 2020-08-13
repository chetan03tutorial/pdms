package com.nataraj.management.auction.pdms.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT_DETAILS")
@Getter
@Setter
@NoArgsConstructor
/*@NamedQueries({
        @NamedQuery(name="Product.findByCategory", query = "select p from Product p from where p.category = :category"),
        @NamedQuery(name="Product.findByProductId", query="select p from product p where p.id = :id")
})*/
public class Product {
    @Id
    @GeneratedValue(generator = "product_id_generator")
    @SequenceGenerator(name="product_id_generator", sequenceName = "product_seq")
    @Column(name="PRODUCT_ID")
    private Long id;
    @Column(name="PRODUCT_NAME")
    private String name;
    @Column(name="PRODUCT_CATEGORY")
    private String category;
    @Column(name="PRODUCT_OWNER")
    private Long owner;

    public Product(Long id, String name, String category, Long owner) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.owner = owner;
    }
}
