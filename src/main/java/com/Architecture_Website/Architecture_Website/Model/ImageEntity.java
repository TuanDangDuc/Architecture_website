package com.Architecture_Website.Architecture_Website.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JsonBackReference
    private ProjectEntity project;

    @ManyToOne()
    @JsonBackReference
    private PostEntity post;
}
