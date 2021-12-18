package com.buildindingandco.BuildindingAndCo.model;

import java.util.Collections;
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
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String firstname;

    String fixNumber;

    String mobileNumber;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<Technicien> techniciens = Collections.emptyList();

}