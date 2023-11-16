package com.example.pastebin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "c")
@RequiredArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String name;
    public User(String name){
        this.name = name;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    List<Note> notes = new ArrayList<>();

}
