package com.Architecture_Website.Architecture_Website.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;

    @ManyToOne
    @JsonBackReference
    private AccountEntity owner;

    @ManyToOne
    @JsonBackReference
    private PostEntity post;

    @ManyToOne
    @JsonBackReference
    private ProjectEntity project;
}
