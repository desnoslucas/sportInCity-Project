package com.projetperso.app.repository;


import com.projetperso.app.entity.Months;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthsRepository extends CrudRepository <Months,Long> {
}
