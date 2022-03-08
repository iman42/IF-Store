package com.ifstore.web.comic_store.services;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;

public interface ContentRepositoryInterface {

    void save(Content comic, Metadata metadata) throws UnableToSave;

    Content get(Metadata metadata) throws UnableToGet;

    public class UnableToGet extends Exception {
        public UnableToGet(Throwable cause) {
            super("Could not load comic content.", cause);
        }
    }

    public class UnableToSave extends Exception {
        public UnableToSave(Throwable cause) {
            super("Could not save comic content.", cause);
        }
    }
}
