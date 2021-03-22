package com.ifstore.web.comic_store.repositories;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comics")
public class ComicRecord {
    @Id
    private Long id;

    private String title;
    private String comic_path;
    private String cover_path;
}
