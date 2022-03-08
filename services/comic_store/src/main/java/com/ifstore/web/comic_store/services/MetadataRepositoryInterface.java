package com.ifstore.web.comic_store.services;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Metadata;

public interface MetadataRepositoryInterface {
    void save(Metadata metadata) throws UnableToSave;

    Metadata get(UUID id) throws UnableToGet;

    Set<Metadata> getAll() throws UnableToGet;

    public class UnableToSave extends Exception {
        public UnableToSave(Throwable cause) {
            super("Unable to save comic metadata.", cause);
        }
    }

    public class UnableToGet extends Exception {
        public UnableToGet(Throwable cause) {
            super("Unable to fetch comic metadata.", cause);
        }
    }
}