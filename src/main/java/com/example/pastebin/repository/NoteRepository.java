package com.example.pastebin.repository;

import com.example.pastebin.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

    void deleteById(Long id);
    @Query(value = "insert into notes(information) values (:note)",nativeQuery = true)
    void insertNote(@Param("note") String note);
    @Query(value = "select * from notes",nativeQuery = true)
    List<Note> getAll();
}
