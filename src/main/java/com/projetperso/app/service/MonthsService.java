package com.projetperso.app.service;

import com.projetperso.app.repository.MonthsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthsService {

     @Autowired
    private MonthsRepository monthsRepository;
}
