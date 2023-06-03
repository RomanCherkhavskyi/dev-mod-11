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
@Table(name = "planet")
@Data
public class Planet {
    @Id
    @Column(name = "planet_id", length = 10)
    private String planetId;
    @Column(name = "planet_name", length = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanetId", cascade = CascadeType.ALL)
    private Set<Ticket> departureTickets;

    @OneToMany(mappedBy = "toPlanetId", cascade = CascadeType.ALL)
    private Set<Ticket> arrivalTickets;

}