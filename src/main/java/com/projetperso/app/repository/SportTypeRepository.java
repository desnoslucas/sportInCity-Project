package com.projetperso.app.repository;

import com.projetperso.app.entity.SportType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportTypeRepository extends CrudRepository <SportType,Long> {
}
