package com.api.clinica.entities.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitaPojo {
    private String data;
    private String tipologia;
    private Long idAnimale;

}
