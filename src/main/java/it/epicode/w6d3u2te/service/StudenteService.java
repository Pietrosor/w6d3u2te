package it.epicode.w6d3u2te.service;

import it.epicode.w6d3u2te.exception.NotFoundException;
import it.epicode.w6d3u2te.model.Studente;
import it.epicode.w6d3u2te.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudenteService {
    @Autowired
    private StudenteRepository studenteRepository;

    public Studente saveStudente(Studente studente){
        return studenteRepository.save(studente);
    }

    public List<Studente> getAllStudenti(){
        return studenteRepository.findAll();
    }

    public Studente getStudente(int matricola)throws NotFoundException {
        return studenteRepository.findById(matricola).orElseThrow(() -> new NotFoundException("studente con matricola "+matricola+" non presente"));
    }

    public Studente updateStudente(int matricola,Studente studente) throws NotFoundException {
        Studente studenteDaAggiornare = getStudente(matricola);

        studenteDaAggiornare.setNome(studente.getNome());
        studenteDaAggiornare.setCognome(studente.getCognome());
        studenteDaAggiornare.setDataNascita(studente.getDataNascita());

        return studenteRepository.save(studenteDaAggiornare);
    }

    public void deleteStudente(int matricola) throws NotFoundException {
        Studente studenteDaCancellare = getStudente(matricola);

        studenteRepository.delete(studenteDaCancellare);
    }
}
