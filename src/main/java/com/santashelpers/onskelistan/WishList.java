package com.santashelpers.onskelistan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    int productPrice;
    @OneToMany
    List<Product> products = new ArrayList<>();



    public WishList() {
    }

    public WishList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId()  {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
