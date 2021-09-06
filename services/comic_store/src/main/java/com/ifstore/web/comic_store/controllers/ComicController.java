package com.ifstore.web.comic_store.controllers;

import java.util.Set;

import com.ifstore.web.comic_store.domain.Comic;
import com.ifstore.web.comic_store.services.ComicStorageService;

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
    private ComicStorageService comicStorageService;

    @CrossOrigin(originPatterns = "http://localhost:*") // [TODO] make not bad (xss vulnerability).
    @PostMapping("/comics")
    public void upload(@RequestParam("file") MultipartFile file) {
        comicStorageService.storeComic(toComic(file));
    }

    @GetMapping("/comics")
    public String getAll() {
        return toResponse(comicStorageService.getAll());
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadFile() {
    }

    private String toResponse(Set<Comic> comics) {
        String allTitles = "[";
        for (var comic : comics) {
            allTitles = allTitles + ("{name: \"" + comic.getTitle() + "\"}\n");
        }
        return allTitles + "]";
    }

    private Comic toComic(MultipartFile file) {
        return new Comic(file.getResource().getFilename());
    }
}
