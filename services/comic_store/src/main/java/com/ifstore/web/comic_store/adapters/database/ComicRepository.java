package com.ifstore.web.comic_store.adapters.database;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.UUID;

import com.ifstore.web.comic_store.adapters.Result;
import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRecord;
import com.ifstore.web.comic_store.adapters.database.jpa.ComicJpaRepository;
import com.ifstore.web.comic_store.domain.Comic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComicRepository {
    @Autowired
    private ComicJpaRepository jpaRepo;
    
    public Result save(Comic comic){
        var record = new ComicJpaRecord(UUID.randomUUID(), comic.getTitle(), "", "");
        jpaRepo.save(record);
        return Result.success();
    }
    
    public Set<Comic> getAll(){
        return jpaRepo.findAll()
            .stream()
            .map((record) -> new Comic(record.getTitle()))
            .collect(toSet());
    }
}
