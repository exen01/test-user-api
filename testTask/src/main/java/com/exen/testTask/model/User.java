package com.exen.testTask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "sur_name", nullable = false)
    private String surName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column(name = "status", nullable = false)
    private String status;
}
