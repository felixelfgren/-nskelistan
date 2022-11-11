package com.santashelpers.onskelistan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Init implements CommandLineRunner {

@Autowired
ListRepository listRepository;
@Autowired
WisherRepository wisherRepository;
@Autowired
ProductRepository productRepository;

    @Override
    public void run(String[] args){
        if(listRepository.count() == 0){
            listRepository.save(new WishList(null, "Adams Önskelista"));
            listRepository.save(new WishList(null, "Simons Önskelista"));
            listRepository.save(new WishList(null, "Malins Önskelista"));
            listRepository.save(new WishList(null, "Felix Önskelista"));
            listRepository.save(new WishList(null, "Fridas Önskelista"));
        }

    }
}
