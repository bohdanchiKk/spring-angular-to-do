package com.example.pastebin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Data
@Table(name = "notes")
@RequiredArgsConstructor
@ToString
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    Long id;
    @Column
    @JsonProperty("notes")
    String information;
    @Column(name = "expiration_date")
    LocalDateTime expirationDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("notes")
    User user;

    public Note(String note){
        this.information = note;
    }

}
