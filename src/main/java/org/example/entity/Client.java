package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "client_name", length = 200, nullable = false)
    private String name;

    @OneToMany(mappedBy = "client", targetEntity = Ticket.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

}