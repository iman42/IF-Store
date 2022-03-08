package com.ifstore.web.comic_store.services;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;
import com.ifstore.web.comic_store.controllers.ComicStorageServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ComicStorageService implements ComicStorageServiceInterface {
    @Autowired
    private MetadataRepositoryInterface metadataRepository;
    @Autowired
    private ContentRepositoryInterface contentRepository;

    public void save(Content comic, Metadata metadata) throws UnableToSave {
        try {
            metadataRepository.save(metadata);
            contentRepository.save(comic, metadata);
        } catch (Exception e) {
            throw new UnableToSave(e);
        }
    }

    public Content get(UUID id) throws UnableToGet {
        try {
            var metadata = metadataRepository.get(id);
            return contentRepository.get(metadata);
        } catch (Exception e) {
            throw new UnableToGet(e);
        }
    }

    public Set<Metadata> getAll() throws UnableToGet {
        try {

            return metadataRepository.getAll();
        } catch (Exception e) {
            throw new UnableToGet(e);
        }
    }
}