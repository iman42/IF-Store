package com.ifstore.web.comic_store.services;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Result {
    public static Result success() {
        return Result.builder().success(true).build();
    }
    private final Boolean success;
}
