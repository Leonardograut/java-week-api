package com.linuxtips.java.weekapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.linuxtips.java.weekapi.model.Curso;
import com.linuxtips.java.weekapi.repository.CursoRepository;

@Service
public class CursoService {
   
   
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso criaCurso(Curso curso){
        return cursoRepository.save(curso);
    }


    public List<Curso> listarCursos(){
        return  cursoRepository.findAll();
    }

 
    public ResponseEntity<Curso>buscarCursoPeloId(Long id){
        return cursoRepository.findById(id)
        .map(curso->ResponseEntity.ok().body(curso))
        .orElse(ResponseEntity.notFound().build());
    }

    
    public ResponseEntity<Curso>atualizarCursoPeloId(Curso curso, Long id){
        return cursoRepository.findById(id)
        .map(cursoToUpdate -> {
            cursoToUpdate.setNome(curso.getNome());
            cursoToUpdate.setPessoaInstrutora(curso.getPessoaInstrutora());
            cursoToUpdate.setPreco(curso.getPreco());
            Curso update = cursoRepository.save(cursoToUpdate);
            return ResponseEntity.ok().body(update);
    }).orElse(ResponseEntity.notFound().build());
    }



    public ResponseEntity<Object> excluirCursoPeloId(Long id){
       return cursoRepository.findById(id)
       .map(cursoToDelete ->{
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
       }).orElse(ResponseEntity.notFound().build());


    }

    

}
