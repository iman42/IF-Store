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
    public void save(Comic comic, ComicReference reference) throws IOException {
        referenceRepository.save(reference);
        comicRepository.save(comic, reference);
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
