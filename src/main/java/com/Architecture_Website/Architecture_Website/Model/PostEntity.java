package com.Architecture_Website.Architecture_Website.Model;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @CreationTimestamp
    @Column(
        updatable = false
    )
    private LocalDateTime uploadAt;
    private Integer viewQuantity;
    private String titleImage;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(columnDefinition = "TEXT")
    private String slug;

    @ManyToOne
    @JsonBackReference
    private AccountEntity account;

    @OneToMany(
            mappedBy = "post"
    )
    @JsonManagedReference
    private Set<VideoEntity> video;

    @OneToMany(
            mappedBy = "post"
    )
    @JsonManagedReference
    private Set<ImageEntity> image;

}
