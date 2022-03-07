package com.ifstore.web.comic_store.controllers;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.ifstore.web.comic_store.Comic;
import com.ifstore.web.comic_store.ComicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@CrossOrigin(originPatterns = "http://localhost:*", allowedHeaders = "*") // [FUTURE] make not bad (xss vulnerability).
@RestController
public class ComicController {

    @Autowired
    private ComicStorageServiceInterface comicStorageService;

    final String ENDPOINT = "/comics";

    @PostMapping(ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    public UUID upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        Comic comic = toComic(file);
        ComicReference reference = comicStorageService.save(comic);
        response.setHeader("Location", ENDPOINT + "/" + reference.getId().toString());
        return reference.getId();
    }

    @GetMapping(ENDPOINT)
    public Set<ComicReference> get() {
        return comicStorageService.getAll();
    }

    @GetMapping(ENDPOINT + "/{id}")
    public ResponseEntity<ByteArrayResource> get(@PathVariable String id) throws IOException {
        return toResponse(comicStorageService.get(UUID.fromString(id)));
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadFile() {
    }

    private ResponseEntity<ByteArrayResource> toResponse(Comic comic) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(comic.getBytes()));
    }

    private Comic toComic(MultipartFile file) throws IOException {
        return new Comic(file.getResource().getFilename(), file.getBytes());

    }
}
