package com.example.demo.DTO;

import com.example.demo.entities.Prestito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PrestitoInputDTO extends Prestito { //VEDERE
    private Long idLibro;
    private Long idUtente;
    private LocalDateTime timeStampInizio;
    private LocalDateTime timeStampFine;
}
