package com.santashelpers.onskelistan;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String name;

    @OneToMany
    List<WishList> wishList = new ArrayList<>();
    //java.util.List<WishList> wishlist = new ArrayList<>();

    public Wisher() {
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