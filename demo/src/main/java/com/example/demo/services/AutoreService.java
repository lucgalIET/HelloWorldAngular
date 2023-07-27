package com.example.demo.services;

import com.example.demo.entities.Autore;
import com.example.demo.repository.AutoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepo;

    // Create
    public Autore createAutore(Autore autore) {
        return autoreRepo.save(autore);
    }

    // Read
    public List<Autore> getAllAutori() {
        return autoreRepo.findAll();
    }

    public Autore getAutoreById(int id_autore) {
        return autoreRepo.findById(id_autore).orElse(null);
    }

    // Update
    public Autore updateAutore(int id, Autore autore) {
        // dobbiamo prima cercare l'autore attraverso l'id. Questa operazione
        // potrebbe fallire
        Optional<Autore> autoreCercato = autoreRepo.findById(id);
        if (autoreCercato.isPresent()) {
//            non possiamo modificare direttamente autore ma dobbiamo
//            crearne un altro
            Autore nuovoAutore = autoreCercato.get(); // copiamo tutti gli attributi

            // poi gli cambio nome, cognome e dataNascita
            nuovoAutore.setNome(autore.getNome());
            nuovoAutore.setCognome(autore.getCognome());
            nuovoAutore.setDataNascita(autore.getDataNascita());

            // infine salvo
            return autoreRepo.save(nuovoAutore);
        } else {
            throw new EntityNotFoundException("Autore con id \"" + id + "\" non trovato");
        }
    }

    // Delete
    public void deleteAutore(int id) {
        Optional<Autore> optionalAutore = autoreRepo.findById(id);
        if (optionalAutore.isPresent()) {
            autoreRepo.delete(optionalAutore.get());
        } else {
            throw new EntityNotFoundException("Autore con id \"" + id + "\" non trovato");
        }
    }

}
