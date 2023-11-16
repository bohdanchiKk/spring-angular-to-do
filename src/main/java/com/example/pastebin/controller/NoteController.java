package com.example.pastebin.controller;

import com.example.pastebin.entity.Note;
import com.example.pastebin.entity.User;
import com.example.pastebin.service.NoteService;
import com.example.pastebin.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {
    private NoteService noteService;
    private UserService userService;
    @Autowired
    public NoteController(NoteService noteService, UserService userService){
        this.noteService = noteService;
        this.userService = userService;
    }
//    @PostMapping("/createnote")
//    public String createNote(@RequestParam Long id,@RequestParam String note){
//        Note note1 = new Note(note);
//        note1.setInformation(note);
//        User user = userService.findUserById(id);
//        note1.setUser(user);
//        noteService.persist(note1);
//        return "He";
//    }
//    @PostMapping("/createnote")
//    public String createNote(@RequestParam Long id,@RequestParam String note){
//        Note note1 = new Note(note);
//        note1.setInformation(note);
//        User user = userService.findUserById(id);
//        note1.setUser(user);
////        noteService.persist(note1);
//        return "He";
//    }
    @PostMapping("/addnote")
    public Note addNoteToUser(@RequestParam Long id, @RequestParam String note){
        return noteService.addNoteToUser(id,note);
    }
    @PostMapping("/createnote")
    public Note createEmptyNote(@RequestParam String task){
         noteService.createEmptyNote(task);
         Note note1 = new Note(task);
         return note1;
    }
    @GetMapping("/get")
    public List<Note> getAll(){
        return noteService.getAll();
    }
    @PostMapping("/update")
    public String updateNote(@RequestParam Long id,@RequestParam String task){
        noteService.updateNote(id, task);
        return "Updated";
    }
}
