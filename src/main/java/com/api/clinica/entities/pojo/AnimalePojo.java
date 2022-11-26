package com.api.clinica.entities.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalePojo {
    private String nome;
    private String nomePadrone;

}
