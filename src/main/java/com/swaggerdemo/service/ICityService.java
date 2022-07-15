package com.swaggerdemo.service;

import com.swaggerdemo.model.City;

import java.util.List;

public interface ICityService {

    public List<City> findAll();

    public boolean save(City city);

    public City find(Long id);

    public boolean update(City city, Long id);

    public boolean delete(Long id);
}
