package com.ifstore.web.comic_store;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Metadata {
    private final UUID id;
    private final String title;
}
