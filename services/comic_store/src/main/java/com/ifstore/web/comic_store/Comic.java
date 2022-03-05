package com.ifstore.web.comic_store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Comic {
    private final String title;
    private final byte[] bytes;
}
