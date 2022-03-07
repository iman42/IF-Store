package com.ifstore.web.comic_store.controllers;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Comic;
import com.ifstore.web.comic_store.ComicReference;

public interface ComicStorageServiceInterface {

    ComicReference save(Comic comic) throws IOException;

    Set<ComicReference> getAll();

    Comic get(UUID fromString) throws IOException;

}
