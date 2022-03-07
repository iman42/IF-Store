package com.ifstore.web.comic_store.adapters.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.UUID;

import com.ifstore.web.comic_store.Comic;
import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRepository;
import com.ifstore.web.comic_store.services.ComicReferenceRepositoryInterface.UnableToGet;
import com.ifstore.web.comic_store.services.ComicReferenceRepositoryInterface.UnableToSave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ComicReferenceRepositoryTests {
    @Mock
    public ComicJpaRepository jpaRepo;

    public ComicReferenceRepository repo;

    @BeforeEach
    public void setUp() {
        repo = new ComicReferenceRepository(jpaRepo);
    }

    @Test
    public void goodErrorWhenFailsToSave() {
        RuntimeException causeOfFailure = new RuntimeException(":(");
        when(jpaRepo.save(Mockito.any())).thenThrow(causeOfFailure);
        Comic comic = new Comic("Title", "Content".getBytes());

        var thrown = assertThrows(UnableToSave.class, () -> {
            repo.createAndSaveReference(comic);
        });

        assertEquals(thrown.getMessage(), "Unable to create and save comic reference.");
        assertEquals(thrown.getCause(), causeOfFailure);
    }

    @Test
    public void goodErrorWhenFailsToGetAll() {
        RuntimeException causeOfFailure = new RuntimeException(":(");
        when(jpaRepo.findAll()).thenThrow(causeOfFailure);

        var thrown = assertThrows(UnableToGet.class, () -> {
            repo.getAll();
        });

        assertEquals(thrown.getMessage(), "Unable to fetch comic reference.");
        assertEquals(thrown.getCause(), causeOfFailure);
    }

    @Test
    public void goodErrorWhenFailsToGet() {
        RuntimeException causeOfFailure = new RuntimeException(":(");
        when(jpaRepo.findById(Mockito.any())).thenThrow(causeOfFailure);

        var thrown = assertThrows(UnableToGet.class, () -> {
            repo.get(UUID.randomUUID());
        });

        assertEquals(thrown.getMessage(), "Unable to fetch comic reference.");
        assertEquals(thrown.getCause(), causeOfFailure);
    }
}