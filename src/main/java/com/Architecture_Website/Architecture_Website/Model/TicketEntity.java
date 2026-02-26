package com.Architecture_Website.Architecture_Website.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Integer area;
    private String phone;
    private Integer budget;
    private String typeOfConsulting;
    private LocalDateTime timeReceipt;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(
            nullable = false,
            updatable = false
    )
    @CreationTimestamp
    private LocalDateTime createAt;

    @ManyToOne()
    @JsonBackReference
    private AccountEntity account;
}
