package com.ifstore.web.comic_store.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

import java.util.UUID;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;
import com.ifstore.web.comic_store.controllers.ComicStorageServiceInterface.UnableToGet;
import com.ifstore.web.comic_store.controllers.ComicStorageServiceInterface.UnableToSave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import lombok.SneakyThrows;

public class ComicStorageServiceTests {

    public MetadataRepositoryInterface mockMetaRepo;
    public ContentRepositoryInterface mockContentRepo;
    public ComicStorageService repo;

    @BeforeEach
    public void setUp() {
        mockMetaRepo = Mockito.mock(MetadataRepositoryInterface.class);
        mockContentRepo = Mockito.mock(ContentRepositoryInterface.class);
        repo = new ComicStorageService(mockMetaRepo, mockContentRepo);
    }

    @Test
    @SneakyThrows
    public void readableErrorOnGetAll() {
        var causeOfAllFailures = new RuntimeException(":(");
        doThrow(causeOfAllFailures).when(mockMetaRepo).getAll();

        var thrown = assertThrows(UnableToGet.class, () -> {
            repo.getAll();
        });

        assertEquals("Unable to get comic.", thrown.getMessage());
        assertEquals(causeOfAllFailures, thrown.getCause());
    }

    @Test
    @SneakyThrows
    public void readableErrorOnGet() {
        var causeOfAllFailures = new RuntimeException(":(");
        doThrow(causeOfAllFailures).when(mockMetaRepo).get(any());

        var thrown = assertThrows(UnableToGet.class, () -> {
            repo.get(UUID.randomUUID());
        });

        assertEquals("Unable to get comic.", thrown.getMessage());
        assertEquals(causeOfAllFailures, thrown.getCause());
    }

    @Test
    @SneakyThrows
    public void readableErrorOnSave() {
        var causeOfAllFailures = new RuntimeException(":(");
        doThrow(causeOfAllFailures).when(mockMetaRepo).save(any());

        var thrown = assertThrows(UnableToSave.class, () -> {
            repo.save(new Content("content".getBytes()), new Metadata(UUID.randomUUID(), "title"));
        });

        assertEquals("Unable to save comic.", thrown.getMessage());
        assertEquals(causeOfAllFailures, thrown.getCause());
    }

}