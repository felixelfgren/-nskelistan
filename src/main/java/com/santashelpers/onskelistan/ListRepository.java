package com.santashelpers.onskelistan;

import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<WishList, Long> {
    WishList findAllByOrderByProduct();
}
