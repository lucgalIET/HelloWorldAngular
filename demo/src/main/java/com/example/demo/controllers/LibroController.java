package com.example.demo.controllers;

import com.example.demo.entities.Autore;
import com.example.demo.entities.Libro;
import com.example.demo.services.AutoreService;
import com.example.demo.services.LibroService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/libri")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {
    @Autowired
    private LibroService libroServ;

    @Autowired
    private AutoreService autoreService;

    // Get
    @GetMapping("/getAll")
    public List<Libro> getAllLibri(){
        val libri = libroServ.getAllLibri();

        val autori = autoreService.getAllAutori();
        List<Autore> autoriList = new ArrayList<>();
        List<Autore> autoriList1 = new ArrayList<>();
        List<Autore> autoriList2 = new ArrayList<>();
        autoriList.add(autori.get(0));
        autoriList.add(autori.get(1));
        autoriList.add(autori.get(2));
        autoriList.add(autori.get(3));
        autoriList1.add(autori.get(7));
        autoriList1.add(autori.get(8));
        autoriList2.add(autori.get(3));

        libri.get(0).setListaAutori(autoriList1);
        libri.get(1).setListaAutori(autoriList);
        libri.get(2).setListaAutori(autoriList2);
        return libri;
    }

    @GetMapping("/searchLibro")
    public Libro getLibroById(@RequestParam(value="id_ricerca", defaultValue = "Nothing was found") Long id_ricerca){
        return libroServ.getLibroById(id_ricerca);
    }

    // Post
    @PostMapping("/post")
    public Libro createLibro(@RequestBody Libro libro){
        return libroServ.createLibro(libro);
    }

    // Put
    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable("id") Long id, @RequestBody Libro libro) {
        return libroServ.updateLibro(id, libro);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable("id") Long id) {
        libroServ.deleteLibro(id);
    }


}
