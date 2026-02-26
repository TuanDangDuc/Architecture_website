package com.Architecture_Website.Architecture_Website.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private UUID parentId;

    @OneToMany(
            mappedBy = "category"
    )
    @JsonManagedReference
    private Set<ProjectEntity> projects;
}
