package com.ifstore.web.comic_store.services;

import java.io.IOException;

import com.ifstore.web.comic_store.Comic;
import com.ifstore.web.comic_store.ComicReference;

public interface ComicRepositoryInterface {

    void save(Comic comic, ComicReference ref) throws IOException;

    Comic get(ComicReference ref) throws IOException;

}

