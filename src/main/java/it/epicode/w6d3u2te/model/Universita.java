package it.epicode.w6d3u2te.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Universita {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String citta;

    @OneToMany(mappedBy = "universita")
}
