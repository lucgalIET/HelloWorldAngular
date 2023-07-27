package com.example.demo.repository;

import com.example.demo.entities.Prestito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Integer> {

}