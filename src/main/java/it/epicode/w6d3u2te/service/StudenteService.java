package it.epicode.w6d3u2te.service;

import it.epicode.w6d3u2te.dto.StudenteDto;
import it.epicode.w6d3u2te.exception.NotFoundException;
import it.epicode.w6d3u2te.model.Studente;
import it.epicode.w6d3u2te.model.Universita;
import it.epicode.w6d3u2te.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteService {
    @Autowired
    private StudenteRepository studenteRepository;

    @Autowired
    private UniversitaService universitaService;

    public Studente saveStudente(StudenteDto studenteDto) throws NotFoundException {
        Universita universita = universitaService.getUniversita(studenteDto.getUniversitaId());
        Studente studente = new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataNascita(studenteDto.getDataNascita());
        studente.setUniversita(universita);

        return studenteRepository.save(studente);
    }

    public List<Studente> getAllStudenti(){
        return studenteRepository.findAll();
    }

    public Studente getStudente(int matricola)throws NotFoundException {
        return studenteRepository.findById(matricola).orElseThrow(() -> new NotFoundException("studente con matricola "+matricola+" non presente"));
    }

    public Studente updateStudente(int matricola,StudenteDto studenteDto) throws NotFoundException {
        Studente studenteDaAggiornare = getStudente(matricola);

        studenteDaAggiornare.setNome(studenteDto.getNome());
        studenteDaAggiornare.setCognome(studenteDto.getCognome());
        studenteDaAggiornare.setDataNascita(studenteDto.getDataNascita());

        if(studenteDaAggiornare.getUniversita().getId() !=studenteDto.getUniversitaId()){
            Universita universita = universitaService.getUniversita(studenteDto.getUniversitaId());
            studenteDaAggiornare.setUniversita(universita);
        }
        return studenteRepository.save(studenteDaAggiornare);
    }

    public void deleteStudente(int matricola) throws NotFoundException {
        Studente studenteDaCancellare = getStudente(matricola);

        studenteRepository.delete(studenteDaCancellare);
    }
}
