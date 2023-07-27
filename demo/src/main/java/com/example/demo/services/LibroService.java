package com.example.demo.services;

import com.example.demo.entities.Libro;
import com.example.demo.repository.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepo;

    // Create
    public Libro createLibro(Libro libro) {
        return libroRepo.save(libro);
    }

    // Read
    public List<Libro> getAllLibri() {
        return libroRepo.findAll();
    }

    public Libro getLibroById(Long idLibro) {
        return libroRepo.findById(idLibro).orElse(null);
    }

    // Update
    public Libro updateLibro(Long id, Libro libro) {
        // dobbiamo prima cercare l'Libro attraverso l'id. Questa operazione
        // potrebbe fallire
        Optional<Libro> libroCercato = libroRepo.findById(id);
        if (libroCercato.isPresent()) {
//            non possiamo modificare direttamente Libro ma dobbiamo
//            crearne un altro
            Libro nuovoLibro = libroCercato.get(); // copiamo tutti gli attributi

            // poi gli cambio nome, cognome, dataNascita e numeroTelefono
            nuovoLibro.setTitolo(libro.getTitolo());
            nuovoLibro.setCategoria(libro.getCategoria());
            nuovoLibro.setDataPubblicazione(libro.getDataPubblicazione());

            // infine salvo
            return libroRepo.save(nuovoLibro);
        } else {
            throw new EntityNotFoundException("Libro con id \"" + id + "\" non trovato");
        }
    }

    // Delete
    public void deleteLibro(Long id) {
        Optional<Libro> optionalLibro = libroRepo.findById(id);
        if (optionalLibro.isPresent()) {
            libroRepo.delete(optionalLibro.get());
        } else {
            throw new EntityNotFoundException("Libro con id \"" + id + "\" non trovato");
        }
    }

}
