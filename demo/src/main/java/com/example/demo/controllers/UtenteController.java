package com.example.demo.controllers;

import com.example.demo.entities.Autore;
import com.example.demo.entities.Utente;
import com.example.demo.services.AutoreService;
import com.example.demo.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
@CrossOrigin(origins = "http://localhost:4200")
public class UtenteController {
    @Autowired
    private UtenteService utenteServ;

    // Get
    @GetMapping("/getAll")
    public List<Utente> getAllUtenti(){
        return utenteServ.getAllUtenti();
    }

    @GetMapping("/searchUtente")
    public Utente getUtenteById(@RequestParam(value="id_ricerca", defaultValue = "Nothing was found") Long id_ricerca){
        return utenteServ.getUtenteById(id_ricerca);
    }

    // Post
    @PostMapping("/post")
    public Utente createUtente(@RequestBody Utente utente){
        return utenteServ.createUtente(utente);
    }

    // Put
    @PutMapping("/{id}")
    public Utente updateUtente(@PathVariable("id") Long id, @RequestBody Utente utente) {
        return utenteServ.updateUtente(id, utente);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable("id") Long id) {
        utenteServ.deleteUtente(id);
    }


}
