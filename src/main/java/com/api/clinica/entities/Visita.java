package com.api.clinica.entities;


import com.api.clinica.repositories.AnimaleRepo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visita")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipologia")
    private String tipologia;
    @Column(name = "data")
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "id_animale", referencedColumnName = "id")
    @JsonManagedReference
    private Animale animale;

}
