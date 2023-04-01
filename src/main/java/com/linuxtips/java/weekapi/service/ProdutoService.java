package com.linuxtips.java.weekapi.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import com.linuxtips.java.weekapi.model.Produto;
import com.linuxtips.java.weekapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
    

    private ProdutoRepository produtoRepository;


    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }


    public   Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }



    public List<Produto> listarProdutos(){
        return  produtoRepository.findAll();
    }

 
    public ResponseEntity<Produto>buscarProdutoPeloId(Long id){
        return produtoRepository.findById(id)
        .map(produto->ResponseEntity.ok().body(produto))
        .orElse(ResponseEntity.notFound().build());
    }

    
    public ResponseEntity<Produto>atualizarProdutoPeloId(Produto produto, Long id){
        return produtoRepository.findById(id)
        .map(produtoToUpdate -> {
            produtoToUpdate.setNome(produto.getNome());
            produtoToUpdate.setPreco(produto.getPreco());
            Produto update = produtoRepository.save(produtoToUpdate);
            return ResponseEntity.ok().body(update);
    }).orElse(ResponseEntity.notFound().build());
    }



    public ResponseEntity<Object> excluirProdutoPeloId(Long id){
       return produtoRepository.findById(id)
       .map(cursoToDelete ->{
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
       }).orElse(ResponseEntity.notFound().build());


    }

  
}
