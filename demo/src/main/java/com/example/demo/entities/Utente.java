package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utente")
    private Long idUtente;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_nascita", nullable = false)
    private LocalDateTime dataNascita;

    @Column(name = "numero_telefono", nullable = false)
    private long numeroTelefono;

    @OneToMany(mappedBy = "utente")
    @JsonIgnore
    private List<Prestito> prestiti = new LinkedList<>();
    public Utente(){

    }
    public Utente(String nome,
                  String cognome,
                  LocalDateTime dataNascita,
                  long numeroTelefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTelefono = numeroTelefono;

    }

   public long getId() {
        return idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDateTime  getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDateTime dataNascita) {
        this.dataNascita = dataNascita;
    }

    public long getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(long numero_telefono) {
        this.numeroTelefono = numero_telefono;
    }

    @Override
    public String toString() {
        return "Utente [id=" + idUtente +
                ", nome=" + nome +
                ", cognome=" + cognome +
                ", data_nascita=" + dataNascita +
                ", numero_telefono=" + numeroTelefono +
                "]";
    }
}