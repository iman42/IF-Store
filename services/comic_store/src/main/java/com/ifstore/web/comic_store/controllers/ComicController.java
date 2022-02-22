package com.ifstore.web.comic_store.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.ifstore.web.comic_store.domain.Comic;
import com.ifstore.web.comic_store.domain.ComicReference;
import com.ifstore.web.comic_store.services.ComicStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    final String GET_ENDPOINT = "/comics";

    @CrossOrigin(originPatterns = "http://localhost:*", allowedHeaders = "*") // [FUTURE] make not bad (xss vulnerability).
    @PostMapping("/comics")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        Comic comic = toComic(file);
        ComicReference reference = comicStorageService.storeComic(comic);
        response.setHeader("Location", GET_ENDPOINT + "/" + reference.id.toString());
    }

    @GetMapping(GET_ENDPOINT)
    public String getAll() {
        return toResponse(comicStorageService.getAll());
    }

    @GetMapping(GET_ENDPOINT + "/{id}")
    public String get(@PathVariable String id) {
        return "";
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
