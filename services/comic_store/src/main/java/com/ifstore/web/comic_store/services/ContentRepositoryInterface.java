package com.ifstore.web.comic_store.services;

import java.io.IOException;

import com.ifstore.web.comic_store.Content;
import com.ifstore.web.comic_store.Metadata;

public interface ContentRepositoryInterface {

    void save(Content comic, Metadata metadata) throws IOException;

    Content get(Metadata metadata) throws IOException;

}
