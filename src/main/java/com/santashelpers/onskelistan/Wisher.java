package com.santashelpers.onskelistan;

import javax.persistence.*;

@Entity
public class Wisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String name;

}
