package com.ifstore.web.comic_store.adapters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Result {
    private final Boolean success;

    public static Result success() {
        return new Result(true);
    }

}
