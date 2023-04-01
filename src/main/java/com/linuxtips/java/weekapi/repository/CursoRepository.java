package com.linuxtips.java.weekapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linuxtips.java.weekapi.model.Curso;

@Repository
public interface CursoRepository  extends JpaRepository<Curso,Long>{
    
}
