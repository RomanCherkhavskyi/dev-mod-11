package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Builder
@NoArgsConstructor
@AllArgsConstructor



@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ticketId;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "client_id")
    private Client client;


    @ManyToOne(targetEntity = Planet.class, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanetId;

    @ManyToOne(targetEntity = Planet.class, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanetId;
}