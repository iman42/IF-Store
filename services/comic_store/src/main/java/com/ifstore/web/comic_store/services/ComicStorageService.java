package com.ifstore.web.comic_store.services;

import java.util.Set;

import com.ifstore.web.comic_store.adapters.database.ComicRepository;
import com.ifstore.web.comic_store.domain.Comic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComicStorageService {
    @Autowired
    private ComicRepository comicRepository;
    
    public Result storeComic(Comic comic) {
        comicRepository.save(comic);
        return Result.success();
    }
    
    public Set<Comic> getAll() {
        return comicRepository.getAll();
    }
}
