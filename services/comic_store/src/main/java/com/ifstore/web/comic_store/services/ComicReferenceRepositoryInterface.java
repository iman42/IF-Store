package com.ifstore.web.comic_store.services;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.ComicReference;

public interface ComicReferenceRepositoryInterface {
    void save(ComicReference reference) throws UnableToSave;

    ComicReference get(UUID id) throws UnableToGet;

    Set<ComicReference> getAll() throws UnableToGet;

    public class UnableToSave extends Exception {
        public UnableToSave(Throwable cause) {
            super("Unable to save comic reference.", cause);
        }
    }

    public class UnableToGet extends Exception {
        public UnableToGet(Throwable cause) {
            super("Unable to fetch comic reference.", cause);
        }
    }
}