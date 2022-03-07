package com.ifstore.web.comic_store.adapters.database;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.ComicReference;
import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRecord;
import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRepository;
import com.ifstore.web.comic_store.services.ComicReferenceRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ComicReferenceRepository implements ComicReferenceRepositoryInterface {
    @Autowired
    private ComicJpaRepository jpaRepo;

    public void save(ComicReference reference) throws UnableToSave {
        try {
            var record = new ComicJpaRecord(reference.getId().toString(), reference.getTitle(), "", "");
            jpaRepo.save(record);
        } catch (Exception e) {
            throw new UnableToSave(e);
        }
    }

    public Set<ComicReference> getAll() throws UnableToGet {
        try {
            return jpaRepo
                    .findAll()
                    .stream()
                    .map((record) -> toReference(record))
                    .collect(toSet());
        } catch (Exception e) {
            throw new UnableToGet(e);
        }
    }

    private ComicReference toReference(ComicJpaRecord record) {
        return new ComicReference(UUID.fromString(record.getId()), record.getTitle());
    }

    public ComicReference get(UUID id) throws UnableToGet {
        try {
            return toReference(jpaRepo.findById(id.toString()).get());
        } catch (Exception e) {
            throw new UnableToGet(e);
        }
    }
}