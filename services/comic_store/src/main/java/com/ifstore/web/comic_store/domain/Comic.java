package com.ifstore.web.comic_store.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Comic {
    private final String title;
    private final byte[] bytes;
}
