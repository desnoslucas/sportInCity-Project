package com.projetperso.app.service;


import com.projetperso.app.entity.City;
import com.projetperso.app.entity.Months;
import com.projetperso.app.entity.SportEvents;
import com.projetperso.app.entity.SportType;
import com.projetperso.app.repository.SportEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class SportEventsService {

    @Autowired
    SportEventsRepository sportEventsRepository;

    @Autowired
    StorageService storageService;

    public List<SportEvents> getAllEvents(){
        List<SportEvents> sportEventsList=
                (List<SportEvents>) sportEventsRepository
                .findAll();
        return sportEventsList;
    }

    public Optional<SportEvents> getSpecificEvents (Long id) {
        return sportEventsRepository.findById(id);
    }

    public void addEvents(String name, String description, Float price, MultipartFile file){
        SportEvents sportEventsToAdd= new SportEvents();
        sportEventsToAdd.setCity(new City("Nice"));
        sportEventsToAdd.setSportType(new SportType("Football"));
        sportEventsToAdd.setMonths(new Months("Juillet"));
        sportEventsToAdd.setName(name);
        sportEventsToAdd.setDescription(description);
        sportEventsToAdd.setPrice(price);

        if (!file.isEmpty()){
            try {
                storageService.store(file);
            } catch (FileAlreadyExistsException e) {
                e.printStackTrace();
            }
            sportEventsToAdd.setPictureName(file.getOriginalFilename());
        }
        sportEventsRepository.save(sportEventsToAdd);
    }
}
