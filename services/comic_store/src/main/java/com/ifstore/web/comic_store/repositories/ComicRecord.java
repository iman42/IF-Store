package com.ifstore.web.comic_store.repositories;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ComicRecord {
    @Id
    private Long id;

    private String name;
    private String description;
}
