package com.buildindingandco.BuildindingAndCo.model;

import java.util.List;

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
public class Worksite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    Float price;

    @Nullable
    @OneToOne(fetch = FetchType.EAGER)
    Adress adress ;

    @Nullable
    @ManyToMany(mappedBy = "worksites")
    List<Technicien> techniciens;

}
