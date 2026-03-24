package com.example.Projeto.controllers;

import com.example.Projeto.models.ProjetoModel;
import com.example.Projeto.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name = "/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoServices;

    @GetMapping
    private ResponseEntity<List<ProjetoModel>> findAll(){
        List<ProjetoModel> projetoModelList = projetoServices.findAll();

        return ResponseEntity.ok().body(projetoModelList);
    }

    @PostMapping
    private ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel){
        ProjetoModel novoProjeto = projetoServices.criarProjeto(projetoModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoProjeto.getId()).toUri();

        return ResponseEntity.created(uri).body(novoProjeto);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<ProjetoModel>> findById(@PathVariable Long id){
        Optional<ProjetoModel> projetoModelOptional = projetoServices.findById(id);

        return ResponseEntity.ok().body(projetoModelOptional);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarProjeto(@PathVariable Long id){
        projetoServices.deletarProjeto(id);

        return ResponseEntity.noContent().build();
    }

}