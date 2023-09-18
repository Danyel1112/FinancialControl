package com.example.financial.services;

import com.example.financial.entity.Receita;
import com.example.financial.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    @Autowired
    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public List<Receita> listarTodasReceitas() {
        return receitaRepository.findAll();
    }

    public Optional<Receita> encontrarReceitaPorId(Long id) {
        return receitaRepository.findById(id);
    }

    public void adicionarReceita(Receita receita) {
        receitaRepository.save(receita);
    }

    public void atualizarReceita(Receita receita) {
        receitaRepository.save(receita);
    }

    public void excluirReceita(Long id) {
        receitaRepository.deleteById(id);
    }
}


