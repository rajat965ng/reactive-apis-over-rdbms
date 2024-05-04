package com.product.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "PRODUCT")
public record Product(@Id Long id, String name, String description,double price,
               int quantity, @Transient String augmentedDescription){

    @PersistenceCreator
    public Product(Long id, String name, String description, double price, int quantity) {
        this(id, name, description, price, quantity, null);
    }

    public Product(String name, String description, double price, int quantity) {
        this(null, name, description, price, quantity, null);
    }
}