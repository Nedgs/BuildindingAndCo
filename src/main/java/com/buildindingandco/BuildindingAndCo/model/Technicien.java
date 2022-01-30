package com.buildindingandco.BuildindingAndCo.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;


@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Technicien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    String firstname;

    int age;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    Adress adress;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    Manager manager;

    @ManyToMany
    List<Worksite> worksites;

}