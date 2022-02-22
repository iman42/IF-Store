package com.ifstore.web.comic_store.adapters.database;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRecord;
import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRepository;
import com.ifstore.web.comic_store.domain.Comic;
import com.ifstore.web.comic_store.domain.ComicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComicRepository {
    @Autowired
    private ComicJpaRepository jpaRepo;

    public ComicReference saveTitle(Comic comic) {
        UUID id = UUID.randomUUID();
        var record = new ComicJpaRecord(id, comic.getTitle(), "", "");
        jpaRepo.save(record);
        return new ComicReference(id);
    }

    public Set<Comic> getAll() {
        return jpaRepo.findAll().stream().map((record) -> new Comic(record.getTitle())).collect(toSet());
    }
}
