package com.projetperso.app.service;


import com.projetperso.app.repository.SportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportTypeService {

    @Autowired
    private SportTypeRepository sportTypeRepository;
}
