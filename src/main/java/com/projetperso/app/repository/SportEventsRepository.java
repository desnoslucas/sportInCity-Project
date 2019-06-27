package com.projetperso.app.repository;

import com.projetperso.app.entity.SportEvents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportEventsRepository extends CrudRepository <SportEvents,Long> {


}
