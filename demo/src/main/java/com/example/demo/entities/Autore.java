package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "autori")
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAutore;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Column(name = "data_nascita", nullable = false)
    private LocalDateTime dataNascita;

    // L'annotazione @ManyToMany permette rappresentare le
    // associazioni N-N. Va specificata la tabella usata nel db e le chiavi primarie esterne.
    // Questo si fa quando nella tabella abbiamo solo le chiavi e non abbiamo altri
    // attributi nella tabella
    @ManyToMany
    @JoinTable(name = "libri_autori",
            joinColumns = @JoinColumn(name = "id_autore"),
            inverseJoinColumns = @JoinColumn(name = "id_libro"))
    private List<Libro> libriScritti = new LinkedList<>();

    public Autore() {

    }

    public Autore(String nome,
                  String cognome,
                  LocalDateTime dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public long getId() {
        return idAutore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String Cognome) {
        this.cognome = Cognome;
    }

    public LocalDateTime getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDateTime dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Autore [id=" + idAutore + ", nome=" + nome + ", cognome=" + cognome + ", data_nascita=" + dataNascita
                + "]";
    }

}