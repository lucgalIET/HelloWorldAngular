package com.example.demo.chiave;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class PrestitoId implements Serializable {

    @Column(name = "id_utente")
    private Long idLibro;

    @Column(name = "id_libro")
    private Long idUtente;

    @Column(name = "timestamp_prestito_inizio")
    private LocalDateTime timestampPrestitoInizio;

    public PrestitoId(Long idLibro, Long idUtente, LocalDateTime timestampPrestitoInizio) {
        this.idLibro = idLibro;
        this.idUtente = idUtente;
        this.timestampPrestitoInizio = timestampPrestitoInizio;
    }


}
