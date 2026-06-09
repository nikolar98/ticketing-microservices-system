package com.pmf.rzk.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "nr_user_db")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Full name is required")
    @Column(name = "full_name", length = 100)
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "active")
    private Boolean active;

}