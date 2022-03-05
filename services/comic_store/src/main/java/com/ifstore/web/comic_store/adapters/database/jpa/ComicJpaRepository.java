package com.ifstore.web.comic_store.adapters.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicJpaRepository extends JpaRepository<ComicJpaRecord, String> {
}
