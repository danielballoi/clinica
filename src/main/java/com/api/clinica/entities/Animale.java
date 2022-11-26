package com.api.clinica.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "animale")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nome_padrone")
    private String nomePadrone;
    @OneToMany(mappedBy = "animale")
    @JsonBackReference
    private Set<Visita> visitaSet;

    public Animale( Long id,String nome, String nomePadrone) {
        this.id= id;
        this.nome = nome;
        this.nomePadrone = nomePadrone;
    }
}
