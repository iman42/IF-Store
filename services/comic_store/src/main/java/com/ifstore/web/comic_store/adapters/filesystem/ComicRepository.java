package com.ifstore.web.comic_store.adapters.filesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.ifstore.web.comic_store.domain.Comic;
import com.ifstore.web.comic_store.domain.ComicReference;

import org.springframework.stereotype.Repository;

@Repository
public class ComicRepository {

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
