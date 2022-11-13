package com.santashelpers.onskelistan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
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

        if(productRepository.count() == 0){
            productRepository.save(new Product(null, "Gurkburk", 79));
            productRepository.save(new Product(null, "Havregryn", 17));
            productRepository.save(new Product(null, "En get", 7599));
            productRepository.save(new Product(null, "Lasersvärd", 999999));

        }
    }
}
