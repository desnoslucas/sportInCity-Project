package com.projetperso.app.repository;


import com.projetperso.app.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository <City,Long> {
}
