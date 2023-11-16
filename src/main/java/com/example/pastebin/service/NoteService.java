package com.example.pastebin.service;

import com.example.pastebin.entity.Note;
import com.example.pastebin.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {
    List<Note> getAll();
    Note addNoteToUser(Long id,String note);

    void createEmptyNote(String note);

    void updateNote(Long id, String note);
}
