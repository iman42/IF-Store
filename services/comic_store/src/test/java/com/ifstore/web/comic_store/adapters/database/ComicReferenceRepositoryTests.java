package com.ifstore.web.comic_store.adapters.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.UUID;

import com.ifstore.web.comic_store.Metadata;
import com.ifstore.web.comic_store.adapters.database.jpa.MetadataJpaRepository;
import com.ifstore.web.comic_store.services.MetadataRepositoryInterface.UnableToGet;
import com.ifstore.web.comic_store.services.MetadataRepositoryInterface.UnableToSave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ComicReferenceRepositoryTests {
    @Mock
    public MetadataJpaRepository jpaRepo;

    public MetadataRepository repo;

    @BeforeEach
    public void setUp() {
        repo = new MetadataRepository(jpaRepo);
    }

    @Test
    public void goodErrorWhenFailsToSave() {
        RuntimeException causeOfFailure = new RuntimeException(":(");
        when(jpaRepo.save(Mockito.any())).thenThrow(causeOfFailure);
        var comic = new Metadata(UUID.randomUUID(), "Random Title");

        var thrown = assertThrows(UnableToSave.class, () -> {
            repo.save(comic);
        });

        assertEquals(thrown.getMessage(), "Unable to save comic metadata.");
        assertEquals(thrown.getCause(), causeOfFailure);
    }

    @Test
    public void goodErrorWhenFailsToGetAll() {
        RuntimeException causeOfFailure = new RuntimeException(":(");
        when(jpaRepo.findAll()).thenThrow(causeOfFailure);

        var thrown = assertThrows(UnableToGet.class, () -> {
            repo.getAll();
        });

        assertEquals(thrown.getMessage(), "Unable to fetch comic metadata.");
        assertEquals(thrown.getCause(), causeOfFailure);
    }

    @Test
    public void goodErrorWhenFailsToGet() {
        RuntimeException causeOfFailure = new RuntimeException(":(");
        when(jpaRepo.findById(Mockito.any())).thenThrow(causeOfFailure);

        var thrown = assertThrows(UnableToGet.class, () -> {
            repo.get(UUID.randomUUID());
        });

        assertEquals(thrown.getMessage(), "Unable to fetch comic metadata.");
        assertEquals(thrown.getCause(), causeOfFailure);
    }
}