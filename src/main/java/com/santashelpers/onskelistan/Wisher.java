package com.santashelpers.onskelistan;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Wisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String name;

    java.util.List<WishList> wishlist = new ArrayList<>();

    public Wisher() {
    }

    public java.util.List<WishList> getWishlist() {
        return wishlist;
    }

    public void setWishlist(java.util.List<WishList> wishlist) {
        this.wishlist = wishlist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}