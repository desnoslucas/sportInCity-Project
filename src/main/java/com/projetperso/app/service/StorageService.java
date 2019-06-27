package com.projetperso.app.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {
    private static final String ROOT_FOLDER="uploads";


    public void store(MultipartFile file) throws FileAlreadyExistsException {
        if(!file.isEmpty()){

            try {
                Path savedPath= getStoragePath(file.getOriginalFilename());
                Files.copy(file.getInputStream(),savedPath);
            } catch (IOException e) {
                e.printStackTrace();
                throw new FileAlreadyExistsException("le fichier "+file.getOriginalFilename()+" existe deja");

            }

        }

    }

    private Path getStoragePath(String filename) {

        File file=new File(ROOT_FOLDER);
        if(!file.exists()){
            file.mkdir();
        }
        return Paths.get(ROOT_FOLDER,filename);
    }

    public Path load(String filename) {
        return Paths.get(ROOT_FOLDER).resolve(filename);
    }


    public Resource loadAsResource(String filename) {
        Resource resource=null;
        try {
            Path file = load(filename);
            resource= new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                System.err.println("Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            System.err.println("Could not read file: " + filename);
            e.printStackTrace();

        }finally {
            return resource;

        }
    }

}
