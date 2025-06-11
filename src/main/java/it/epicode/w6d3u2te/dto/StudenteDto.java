package it.epicode.w6d3u2te.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private int universitaId;
}
