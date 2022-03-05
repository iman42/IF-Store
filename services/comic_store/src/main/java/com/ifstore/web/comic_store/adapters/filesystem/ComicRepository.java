package com.ifstore.web.comic_store.adapters.filesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.ifstore.web.comic_store.Comic;
import com.ifstore.web.comic_store.ComicReference;
import com.ifstore.web.comic_store.services.ComicRepositoryInterface;

import org.springframework.stereotype.Repository;

@Repository
public class ComicRepository implements ComicRepositoryInterface{

    private Path toFilePath(ComicReference ref) {
        return (Path.of("/tmp/" + ref.getId() + ".blob"));
    }

    public void save(Comic toSave, ComicReference byReference) throws IOException {
        Files.write(toFilePath(byReference), toSave.getBytes());
    }

    public Comic get(ComicReference byReference) throws IOException {
        return new Comic(
                byReference.getTitle(),
                Files.readAllBytes(toFilePath(byReference)));
    }
}
