package com.ifstore.web.comic_store.adapters.database;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRecord;
import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRepository;
import com.ifstore.web.comic_store.Comic;
import com.ifstore.web.comic_store.ComicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComicReferenceRepository {
    @Autowired
    private ComicJpaRepository jpaRepo;

    public ComicReference createAndSaveReference(Comic comic) {
        UUID id = UUID.randomUUID();
        var record = new ComicJpaRecord(id.toString(), comic.getTitle(), "", "");
        jpaRepo.save(record);
        return new ComicReference(id, comic.getTitle());
    }

    public Set<ComicReference> getAll() {
        return jpaRepo.findAll().stream().map((record) -> toReference(record))
                .collect(toSet());
    }

    private ComicReference toReference(ComicJpaRecord record) {
        return new ComicReference(UUID.fromString(record.getId()), record.getTitle());
    }

    public ComicReference get(UUID id) {
        return toReference(jpaRepo.findById(id.toString()).get());
    }
}
