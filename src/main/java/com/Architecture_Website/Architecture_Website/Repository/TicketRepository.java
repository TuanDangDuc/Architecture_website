package com.Architecture_Website.Architecture_Website.Repository;

import com.Architecture_Website.Architecture_Website.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {
}
