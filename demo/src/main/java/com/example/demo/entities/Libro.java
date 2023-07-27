package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "libri")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long idLibro;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "data_pubblicazione", nullable = false)
    private String dataPubblicazione;

    @ManyToMany(mappedBy = "libriScritti") // mappato dalla lista libriScritti in Autore
    private List<Autore> listaAutori = new LinkedList<>();

    @OneToMany(mappedBy = "libro")
    @JsonIgnore
    private List<Prestito> prestiti = new LinkedList<>();

}