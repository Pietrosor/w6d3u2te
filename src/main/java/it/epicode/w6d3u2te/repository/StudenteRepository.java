package it.epicode.w6d3u2te.repository;

import it.epicode.w6d3u2te.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente,Integer> {
}
