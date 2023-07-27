package com.example.demo.entities;

//import com.example.demo.chiave.PrestitoId;

import com.example.demo.chiave.PrestitoId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "prestiti")
public class Prestito {

    @EmbeddedId
    private PrestitoId prestitoId;


    @ManyToOne
    @MapsId("idLibro")
    @JoinColumn(name = "id_libro")
    private Libro libro;

    @ManyToOne
    @MapsId("idUtente")
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @Column(name = "timestamp_prestito_fine")
    private LocalDateTime timestampPrestitoFine;


    public void setPrestitoId(Long idUtente, Long idLibro, LocalDateTime timeStampInizio) {
        this.prestitoId = new PrestitoId(idUtente,idLibro,timeStampInizio);
    }
}
