package com.kensuka21.api.shortenerlink.service;

import java.util.List;
import java.util.Optional;

/**
 * Created by kesalcedo on 5/20/2016.
 */
public interface Service<T, PK> {
    Optional<T> save(T obj);
    Optional<T> update(T obj);
    void remove(T obj);
    Optional<List<T>> findAll();
    Optional<T> findOne(PK id);
}
