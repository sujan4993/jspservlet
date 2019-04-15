package com.dtc.dao;

import java.util.List;

public interface Dao<T> {

    List<T> findAll();
    T findById(int id);
    boolean add(T t);
    boolean update(T t);
    boolean delete(int id);
}
