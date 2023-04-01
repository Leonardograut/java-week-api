package com.linuxtips.java.weekapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.linuxtips.java.weekapi.model.Curso;
import com.linuxtips.java.weekapi.service.CursoService;

@RestController
@RequestMapping("/api")
public class CursoController {

    CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService =cursoService;
    }
    
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso criaCurso(@RequestBody Curso curso){
        return cursoService.criaCurso(curso);
    }
   
    
    @GetMapping("/") 
    @ResponseStatus(HttpStatus.OK)
    public List<Curso>listarCursos(){
        return cursoService.listarCursos();
    }

   @GetMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public ResponseEntity<Curso>buscarCursoPeloId(@PathVariable(value = "id")Long id){
    return cursoService.buscarCursoPeloId(id);
   }

     
   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public ResponseEntity<Curso>atualizarCursoPeloId(@PathVariable(value = "id")Long id,@RequestBody Curso curso){
    return cursoService.atualizarCursoPeloId(curso, id);
   }


   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public ResponseEntity<Object>excluirCursoPeloId(@PathVariable(value = "id")Long id){
    return cursoService.excluirCursoPeloId(id);
   }


}
