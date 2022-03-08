package com.ifstore.web.comic_store.services;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;
import com.ifstore.web.comic_store.controllers.ComicStorageServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
public class ComicStorageService implements ComicStorageServiceInterface {
    @Autowired
    private MetadataRepositoryInterface metadataRepository;
    @Autowired
    private ContentRepositoryInterface contentRepository;

    @SneakyThrows
    public void save(Content comic, Metadata metadata) throws IOException {
        metadataRepository.save(metadata);
        contentRepository.save(comic, metadata);
    }

    @SneakyThrows
    public Content get(UUID id) throws IOException {
        var metadata = metadataRepository.get(id);
        return contentRepository.get(metadata);
    }

    @SneakyThrows
    public Set<Metadata> getAll() {
        return metadataRepository.getAll();
    }
}