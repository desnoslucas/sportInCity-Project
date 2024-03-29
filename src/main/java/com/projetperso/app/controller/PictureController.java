package com.projetperso.app.controller;

import com.projetperso.app.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PictureController {

    @Autowired
    StorageService storageService;

    @GetMapping("/img/{filename:.+}")
    @ResponseBody

    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource fileResource = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileResource.getFilename() + "\"").body(fileResource);
    }
}

