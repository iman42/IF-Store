package com.ifstore.web.comic_store.adapters.database.jpa;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="comics")
public class ComicJpaRecord {
    @Id
    private UUID id;

    private String title;
    private String comic_path;
    private String cover_path;
}
