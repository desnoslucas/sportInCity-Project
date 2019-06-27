package com.projetperso.app.controller;

import com.projetperso.app.entity.SportEvents;
import com.projetperso.app.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class SportEventsController {

    @Autowired
    private SportEventsService sportEventsService;

    @GetMapping(value = "/")
    public String displayIndex() {
        return "index";
    }

    @GetMapping(value = "/events")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("events");
        List<SportEvents> sportEventsList = sportEventsService.getAllEvents();
        mv.addObject("sportEvents", sportEventsList);
        return mv;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView displayGame(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("eventsContent");
        SportEvents sportEvents=sportEventsService
                .getSpecificEvents(id)
                .orElse(null);
        mv.addObject("event", sportEvents);
        return mv;
    }
    @GetMapping(value = "/addEvents")
    public String displayCreateGame(Model model) {
        model.addAttribute("sportEvents", new SportEventsDto());

        return "addEvents";
    }

    @PostMapping(value = "/addEvents")
    public String createEvent(@ModelAttribute("sportEvents") SportEventsDto dto) {

        if (dto.getFile() != null) {
            sportEventsService.addEvents(dto.getName(), dto.getDescription(), dto.getPrice(), dto.getFile());
        }
        return "redirect:/events";
    }

    @PostMapping(value = "/multipartFile")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file == null) {
            System.out.println("File not found");
        } else if (file.getContentType().equals("text/plain")) {
            InputStreamReader isr = null;
            try {
                isr = new InputStreamReader(file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(isr);
            String c = null;
            while (true) {
                try {
                    if (!((c = br.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(c);
            }
        } else {
            System.out.println("File " + file.getOriginalFilename() + " imported");
            System.out.println("Nothing to display");
        }
    }
}
