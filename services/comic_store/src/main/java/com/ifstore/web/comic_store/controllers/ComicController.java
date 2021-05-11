package com.ifstore.web.comic_store.controllers;

import java.util.UUID;

import com.ifstore.web.comic_store.repositories.ComicRecord;
import com.ifstore.web.comic_store.repositories.ComicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ComicController {
    
    @Autowired
    private ComicRepository repo;

    @CrossOrigin(originPatterns = "http://localhost:*") //[TODO] make not bad (xss vulnerability).
    @PostMapping("/comics")
    public void upload(@RequestParam("file") MultipartFile file) { 
        var record = new ComicRecord(UUID.randomUUID(), file.getResource().getFilename(), "", "");
        repo.save(record);
    }

    @GetMapping("/comics")
    public String getAll(){
        var allComics = repo.findAll();
        String allTitles = "[";
        for (var comic : allComics){
            allTitles = allTitles + ("{name: \"" + comic.getTitle() + "\"}\n");
        }
        return allTitles + "]";
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadFile() {
    }
}
