package com.example.pastebin;

import com.example.pastebin.entity.Note;
import com.example.pastebin.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class DynamicSchduledTask {
    @Autowired
    private NoteRepository noteRepository;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    @PostConstruct
    public void scheduleDeletion(){
        LocalDateTime deletionTime = LocalDateTime.now().plusSeconds(10);
        long initialDelay = Duration.between(LocalDateTime.now(), deletionTime).toMillis();
        scheduler.schedule(this::deleteOldNotes, initialDelay, TimeUnit.MILLISECONDS);

    }
    public void deleteOldNotes() {
        // Define the date threshold (e.g., notes created before this date will be deleted)
        LocalDateTime thresholdDateTime = LocalDateTime.now().plusMinutes(1);
        // Delete the notes
        noteRepository.deleteById(15L);

    }
}
