package com.buildindingandco.BuildindingAndCo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import org.springframework.lang.Nullable;

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

public class Vehicules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String numPlaque;

    String brand;

    int builtIn;

    @Nullable
    @OneToOne(fetch = FetchType.EAGER)
    Technicien technicien;
}
