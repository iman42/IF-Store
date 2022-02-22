package com.ifstore.web.comic_store.services;

import java.util.Set;

import com.ifstore.web.comic_store.adapters.database.ComicRepository;
import com.ifstore.web.comic_store.domain.Comic;
import com.ifstore.web.comic_store.domain.ComicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComicStorageService {
    @Autowired
    private ComicRepository comicRepository;

    public ComicReference storeComic(Comic comic) {
        // PLAN: save comic file in folder somewhere, remember filepath
        // PLAN: save comic cover in different folder somwhere, remember filepath
        return comicRepository.saveTitle(comic);   // send filepaths
    }

    public Set<Comic> getAll() {
        return comicRepository.getAll();
    }
}
