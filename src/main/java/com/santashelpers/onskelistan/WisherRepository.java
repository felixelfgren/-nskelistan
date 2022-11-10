package com.santashelpers.onskelistan;
import org.springframework.data.repository.CrudRepository;
public interface WisherRepository extends CrudRepository<Wisher, Long> {

    Iterable<Wisher>findAllByOrderByUsername();
}