package com.example.demo.controllers;

import com.example.demo.entities.Autore;
import com.example.demo.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AutoreController{
    @Autowired
    private AutoreService autoreServ;

//    @GetMapping("/autori")
//    public String getAllAutori(){
//        return String.format(autoreServ.getAllAutori().toString());
//    }

    // Read
    @GetMapping("/autori")
    public List<Autore> getAllAutori(){
        return autoreServ.getAllAutori();
    }

    @GetMapping("/searchAutore")
    public Autore getAutoreById(@RequestParam(value = "id_ricerca", defaultValue = "Nothing Was Found") int id_ricerca) {
        return autoreServ.getAutoreById(id_ricerca);
    }


    // Create
    @PostMapping("/post")
    public Autore createAutore(@RequestBody Autore autore) {
        return autoreServ.createAutore(autore);
    }


    // Update
    // per fare l'update va passato l'id tramite url e l'autore tramite il body
    @PutMapping("/{id}")
    public Autore updateAutore(@PathVariable("id") int id, @RequestBody Autore autore) {
        return autoreServ.updateAutore(id, autore);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable("id") int id) {
        autoreServ.deleteAutore(id);
    }

}