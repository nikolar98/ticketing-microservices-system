package com.pmf.rzk.userservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teams", schema = "nr_user_db")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description")
    private String description;

}