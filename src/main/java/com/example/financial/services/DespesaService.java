package com.example.financial.services;

import com.example.financial.entity.Despesa;
import com.example.financial.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;

    @Autowired
    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public List<Despesa> listarTodasDespesas() {
        return despesaRepository.findAll();
    }

    public Optional<Despesa> encontrarDespesaPorId(Long id) {
        return despesaRepository.findById(id);
    }

    public void adicionarDespesa(Despesa despesa) {
        despesaRepository.save(despesa);
    }

    public void atualizarDespesa(Despesa despesa) {
        despesaRepository.save(despesa);
    }

    public void excluirDespesa(Long id) {
        despesaRepository.deleteById(id);
    }
}


