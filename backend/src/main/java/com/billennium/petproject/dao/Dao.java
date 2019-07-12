package com.billennium.petproject.dao;

import java.util.Collection;

public interface Dao<T> {

    T get(int id);

    Collection<T> getAll();

    int save(T t);

    void update(T t);

    void delete(T t);
}
