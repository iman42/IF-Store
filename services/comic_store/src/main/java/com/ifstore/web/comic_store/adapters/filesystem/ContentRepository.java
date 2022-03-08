package com.ifstore.web.comic_store.adapters.filesystem;

import java.nio.file.Files;
import java.nio.file.Path;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;
import com.ifstore.web.comic_store.services.ContentRepositoryInterface;

import org.springframework.stereotype.Repository;

@Repository
public class ContentRepository implements ContentRepositoryInterface {

    private Path toFilePath(Metadata metadata) {
        return (Path.of("/tmp/" + metadata.getId() + ".blob"));
    }

    public void save(Content toSave, Metadata byMetadata) throws UnableToSave {
        try {
            Files.write(toFilePath(byMetadata), toSave.getBytes());
        } catch (Exception e) {
            throw new UnableToSave(e);
        }
    }

    public Content get(Metadata byMetadata) throws UnableToGet {
        try {
            return new Content(Files.readAllBytes(toFilePath(byMetadata)));
        } catch (Exception e) {
            throw new UnableToGet(e);
        }
    }
}