package com.ifstore.web.comic_store.controllers;

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

    @CrossOrigin(originPatterns = "http://localhost:*") //[TODO] make not bad (xss vulnerability).
    @PostMapping("/comics")
    public void upload(@RequestParam("file") MultipartFile file) {}

    @GetMapping("/comics")
    public String getAll(){
        return "bananas";
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadFile() {
    }
}
