package com.example.pastebin.service;

import com.example.pastebin.entity.Note;
import com.example.pastebin.entity.User;
import com.example.pastebin.repository.NoteRepository;
import com.example.pastebin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService{
    private NoteRepository noteRepository;
    private UserRepository userRepository;
    public NoteServiceImpl(NoteRepository noteRepository,UserRepository userRepository){

        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }
    @Override
    public List<Note> getAll() {
        return noteRepository.getAll();
    }

    @Override
    public Note addNoteToUser(Long id,String note) {
        Note note1 = new Note(note);
        var person = userRepository.findUserById(id);
        note1.setUser(person);
        person.getNotes().add(note1);
        userRepository.save(person);
        return note1;
    }

    @Override
    public void createEmptyNote(String note) {
         noteRepository.insertNote(note);
        System.out.println(note);
    }

    @Override
    public void updateNote(Long id, String note) {
        var oldNote = noteRepository.findById(id);
        oldNote.get().setInformation(note);
        noteRepository.flush();
    }


}
