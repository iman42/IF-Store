package com.ifstore.web.comic_store.adapters.filesystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.NoSuchFileException;
import java.util.UUID;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;
import com.ifstore.web.comic_store.services.ContentRepositoryInterface.UnableToGet;
import com.ifstore.web.comic_store.services.ContentRepositoryInterface.UnableToSave;

import org.junit.jupiter.api.Test;

public class ContentRepositoryTests {

    @Test
    public void readableErrorWhenFailsToSave() {
        ContentRepository repo = new ContentRepository();
        var thrown = assertThrows(UnableToSave.class, () -> {
            repo.save(
                    new Content(null),
                    new Metadata(null, null));
        });

        assertEquals("Could not save comic content.", thrown.getMessage());
        assertInstanceOf(NullPointerException.class, thrown.getCause());
    }

    @Test
    public void readableErrorWhenFailsToGet() {
        ContentRepository repo = new ContentRepository();
        var thrown = assertThrows(UnableToGet.class, () -> {
            repo.get(new Metadata(UUID.randomUUID(), "title"));
        });

        assertEquals("Could not load comic content.", thrown.getMessage());
        assertInstanceOf(NoSuchFileException.class, thrown.getCause());
    }

}