package com.ifstore.web.comic_store.controllers;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;

public interface ComicStorageServiceInterface {

    void save(Content comic, Metadata byMetadata) throws UnableToSave;

    Set<Metadata> getAll() throws UnableToGet;

    Content get(UUID fromString) throws UnableToGet;

    public class UnableToGet extends Exception {
        public UnableToGet(Throwable cause) {
            super("Unable to get comic.", cause);
        }
    }

    public class UnableToSave extends Exception {
        public UnableToSave(Throwable cause) {
            super("Unable to save comic.", cause);
        }
    }

}
