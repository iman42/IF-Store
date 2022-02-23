package com.ifstore.web.comic_store.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ComicReference {
    private final UUID id;
    private final String title;
}
