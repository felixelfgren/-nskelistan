package com.santashelpers.onskelistan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String product;


}
