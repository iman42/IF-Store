package com.ifstore.web.comic_store.controllers;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;

public interface ComicStorageServiceInterface {

    void save(Content comic, Metadata byMetadata) throws IOException;

    Set<Metadata> getAll();

    Content get(UUID fromString) throws IOException;

}
