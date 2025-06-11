package it.epicode.w6d3u2te.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Studente {
    @Id
    @GeneratedValue
    private int matricola;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    @ManyToOne
    @JoinColumn(name = "universita_id")
    private Universita universita;
}
