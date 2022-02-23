package com.ifstore.web.comic_store.services;

import java.io.IOException;
import java.util.UUID;

import com.ifstore.web.comic_store.adapters.database.ComicReferenceRepository;
import com.ifstore.web.comic_store.adapters.filesystem.ComicRepository;
import com.ifstore.web.comic_store.domain.Comic;
import com.ifstore.web.comic_store.domain.ComicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComicStorageService {
    @Autowired
    private ComicReferenceRepository referenceRepository;
    @Autowired
    private ComicRepository comicRepository;

    public ComicReference storeComic(Comic comic) throws IOException {
        // PLAN: save comic file in folder somewhere, remember filepath
        // PLAN: save comic cover in different folder somwhere, remember filepath

        ComicReference ref = referenceRepository.createAndSaveReference(comic);

        comicRepository.save(comic, ref);

        return ref; // send filepaths
    }

    public Comic get(UUID id) throws IOException {
        var ref = referenceRepository.get(id);
        return comicRepository.get(ref);
    }
}
