package com.example.Projeto.services;

import com.example.Projeto.models.ProjetoModel;
import com.example.Projeto.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoModel> findAll(){
        return projetoRepository.findAll();
    }

    public ProjetoModel criarProjeto(ProjetoModel projetoModel){
        return projetoRepository.save(projetoModel);
    }

    public Optional<ProjetoModel> findById(Long id){
        return projetoRepository.findById(id);
    }

    public void deletarProjeto(Long id){
        projetoRepository.deleteById(id);
    }

}