package com.ifstore.web.comic_store.services;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Comic;
import com.ifstore.web.comic_store.ComicReference;
import com.ifstore.web.comic_store.controllers.ComicStorageServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
public class ComicStorageService implements ComicStorageServiceInterface {
    @Autowired
    private ComicReferenceRepositoryInterface referenceRepository;
    @Autowired
    private ComicRepositoryInterface comicRepository;

    @SneakyThrows
    public ComicReference storeComic(Comic comic) throws IOException {
        ComicReference ref = referenceRepository.createAndSaveReference(comic);
        comicRepository.save(comic, ref);
        return ref;
    }

    @SneakyThrows
    public Comic get(UUID id) throws IOException {
        var ref = referenceRepository.get(id);
        return comicRepository.get(ref);
    }

    @SneakyThrows
    public Set<ComicReference> getAll() {
        return referenceRepository.getAll();
    }
}
