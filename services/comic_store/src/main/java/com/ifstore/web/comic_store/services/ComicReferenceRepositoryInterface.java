package com.ifstore.web.comic_store.services;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Comic;
import com.ifstore.web.comic_store.ComicReference;

public interface ComicReferenceRepositoryInterface {

    ComicReference createAndSaveReference(Comic comic);

    ComicReference get(UUID id);

    Set<ComicReference> getAll();

}

