package com.example.demo.services;

import com.example.demo.entities.Libro;
import com.example.demo.entities.Prestito;
import com.example.demo.DTO.PrestitoInputDTO;
import com.example.demo.entities.Utente;
import com.example.demo.repository.LibroRepository;
import com.example.demo.repository.PrestitoRepository;
import com.example.demo.repository.UtenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestitoService {
    @Autowired
    private PrestitoRepository prestitoRepo;
    @Autowired
    private UtenteRepository utenteRepo;
    @Autowired
    private LibroRepository libroRepo;

    // Create
//    public Prestito createPrestito(PrestitoInput prestitoInput) {
//        Optional<Utente> utenteTrovato = utenteRepo.findById(prestitoInput.getIdUtente());
//        Optional<Libro> libroTrovato = libroRepo.findById(prestitoInput.getIdLibro());
//        if(utenteTrovato.isPresent() && libroTrovato.isPresent()) {
//            Utente nuovoUtente = utenteTrovato.get();
//            Libro nuovoLibro = libroTrovato.get();
//            Prestito nuovoPrestito = new Prestito();
//            nuovoPrestito.setUtente(nuovoUtente);
//            nuovoPrestito.setLibro(nuovoLibro);
//            nuovoPrestito.setTimestampPrestitoInizio(prestitoInput.getTimeStampInizio());
//            nuovoPrestito.setTimestampPrestitoFine(prestitoInput.getTimeStampFine());
//            return prestitoRepo.save(nuovoPrestito);
//        }else{
//            throw new EntityNotFoundException("Utente e/o Libro non trovato");
//        }
//
//    }
    // create pt2
    // Create
    public Prestito createPrestito(PrestitoInputDTO prestitoInputDTO) {
        Optional<Utente> utenteTrovato = utenteRepo.findById(prestitoInputDTO.getIdUtente());
        Optional<Libro> libroTrovato = libroRepo.findById(prestitoInputDTO.getIdLibro());
        if(utenteTrovato.isEmpty() || libroTrovato.isEmpty())
            throw new EntityNotFoundException("Utente e/o Libro non trovato");

        Prestito nuovoPrestito = new Prestito();
        nuovoPrestito.setUtente(utenteTrovato.get());
        nuovoPrestito.setLibro(libroTrovato.get());
        nuovoPrestito.setPrestitoId(
                utenteTrovato.get().getId(),
                libroTrovato.get().getIdLibro(),
                prestitoInputDTO.getTimeStampInizio()
                );
        nuovoPrestito.setTimestampPrestitoFine(prestitoInputDTO.getTimeStampFine());
        return prestitoRepo.save(nuovoPrestito);



    }

    // Read
    public List<Prestito> getAllPrestiti() {
        return prestitoRepo.findAll();
    }

    public Prestito getPrestitoById(int id_prestito) {
        return prestitoRepo.findById(id_prestito).orElse(null);
    }

    // Update
//    public Prestito updatePrestito(int id, Prestito prestito) {
//        // dobbiamo prima cercare l'prestito attraverso l'id. Questa operazione
//        // potrebbe fallire
//        Optional<Prestito> prestitoCercato = prestitoRepo.findById(id);
//        if (prestitoCercato.isEmpty())
//            throw new EntityNotFoundException("Prestito con id \"" + id + "\" non trovato");
//
//            Prestito nuovoPrestito = prestitoCercato.get(); // copiamo tutti gli attributi
//
//            // poi gli cambio nome, cognome e dataNascita
//            nuovoPrestito.setLibro(prestito.getLibro());
//            nuovoPrestito.setUtente(prestito.getUtente());
//            nuovoPrestito.setTimestampPrestitoInizio(prestito.getTimestampPrestitoInizio());
//            nuovoPrestito.setTimestampPrestitoFine(prestito.getTimestampPrestitoFine());
//
//            // infine salvo
//            return prestitoRepo.save(nuovoPrestito);
//
//    }

    // Delete
    public void deletePrestito(int id) {
        Optional<Prestito> optionalPrestito = prestitoRepo.findById(id);
        if (optionalPrestito.isPresent()) {
            prestitoRepo.delete(optionalPrestito.get());
        } else {
            throw new EntityNotFoundException("Prestito con id \"" + id + "\" non trovato");
        }
    }

}
