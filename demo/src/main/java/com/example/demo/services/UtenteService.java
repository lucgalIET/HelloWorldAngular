package com.example.demo.services;

import com.example.demo.entities.Utente;
import com.example.demo.repository.UtenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepo;

    // Create
    public Utente createUtente(Utente utente) {
        return utenteRepo.save(utente);
    }

    // Read
    public List<Utente> getAllUtenti() {
        return utenteRepo.findAll();
    }

    public Utente getUtenteById(Long idUtente) {
        return utenteRepo.findById(idUtente).orElse(null);
    }

    // Update
    public Utente updateUtente(Long id, Utente utente) {
        // dobbiamo prima cercare l'Utente attraverso l'id. Questa operazione
        // potrebbe fallire
        Optional<Utente> utenteCercato = utenteRepo.findById(id);
        if (utenteCercato.isPresent()) {
//            non possiamo modificare direttamente Utente ma dobbiamo
//            crearne un altro
            Utente nuovoUtente = utenteCercato.get(); // copiamo tutti gli attributi

            // poi gli cambio nome, cognome, dataNascita e numeroTelefono
            nuovoUtente.setNome(utente.getNome());
            nuovoUtente.setCognome(utente.getCognome());
            nuovoUtente.setDataNascita(utente.getDataNascita());
            nuovoUtente.setNumeroTelefono(utente.getNumeroTelefono());

            // infine salvo
            return utenteRepo.save(nuovoUtente);
        } else {
            throw new EntityNotFoundException("Utente con id \"" + id + "\" non trovato");
        }
    }

    // Delete
    public void deleteUtente(Long id) {
        Optional<Utente> optionalUtente = utenteRepo.findById(id);
        if (optionalUtente.isPresent()) {
            utenteRepo.delete(optionalUtente.get());
        } else {
            throw new EntityNotFoundException("Utente con id \"" + id + "\" non trovato");
        }
    }

}
