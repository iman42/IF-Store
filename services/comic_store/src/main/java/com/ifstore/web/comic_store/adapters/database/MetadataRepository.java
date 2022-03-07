package com.ifstore.web.comic_store.adapters.database;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Metadata;
import com.ifstore.web.comic_store.adapters.database.jpa.MetadataJpaRecord;
import com.ifstore.web.comic_store.adapters.database.jpa.MetadataJpaRepository;
import com.ifstore.web.comic_store.services.MetadataRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MetadataRepository implements MetadataRepositoryInterface {
    @Autowired
    private MetadataJpaRepository jpaRepo;

    public void save(Metadata metadata) throws UnableToSave {
        try {
            var record = new MetadataJpaRecord(metadata.getId().toString(), metadata.getTitle(), "", "");
            jpaRepo.save(record);
        } catch (Exception e) {
            throw new UnableToSave(e);
        }
    }

    public Set<Metadata> getAll() throws UnableToGet {
        try {
            return jpaRepo
                    .findAll()
                    .stream()
                    .map((record) -> toMetadata(record))
                    .collect(toSet());
        } catch (Exception e) {
            throw new UnableToGet(e);
        }
    }

    private Metadata toMetadata(MetadataJpaRecord record) {
        return new Metadata(UUID.fromString(record.getId()), record.getTitle());
    }

    public Metadata get(UUID id) throws UnableToGet {
        try {
            return toMetadata(jpaRepo.findById(id.toString()).get());
        } catch (Exception e) {
            throw new UnableToGet(e);
        }
    }
}