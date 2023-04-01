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

import com.linuxtips.java.weekapi.model.Produto;
import com.linuxtips.java.weekapi.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    ProdutoService produtoService;
    

 public ProdutoController(ProdutoService produtoService){
    this.produtoService = produtoService;
 }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criaProduto(@RequestBody Produto produto){
        return produtoService.criarProduto(produto);
    }

    @GetMapping("/") 
    @ResponseStatus(HttpStatus.OK)
    public List<Produto>listarProdutos(){
        return produtoService.listarProdutos();
    }

   @GetMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public ResponseEntity<Produto>buscarProdutoPeloId(@PathVariable(value = "id")Long id){
    return produtoService.buscarProdutoPeloId(id);
   }

     
   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public ResponseEntity<Produto>atualizarProdutoPeloId(@PathVariable(value = "id")Long id,@RequestBody Produto produto){
    return produtoService.atualizarProdutoPeloId(produto, id);
   }


   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public ResponseEntity<Object>excluirProdutoPeloId(@PathVariable(value = "id")Long id){
    return produtoService.excluirProdutoPeloId(id);
   }
}
