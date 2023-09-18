package com.example.financial.controller;

import com.example.financial.entity.Despesa;
import com.example.financial.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService despesaService;

    @Autowired
    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @GetMapping
    public String listarDespesas(Model model) {
        model.addAttribute("despesas", despesaService.listarTodasDespesas());
        return "listagem";
    }

    @GetMapping("/adicionar")
    public String exibirFormularioDespesa(Model model) {
        model.addAttribute("despesa", new Despesa());
        return "formulario";
    }

    @PostMapping("/adicionar")
    public String adicionarDespesa(@ModelAttribute("despesa") Despesa despesa) {
        despesaService.adicionarDespesa(despesa);
        return "redirect:/despesas";
    }

    @GetMapping("/editar/{id}")
    public String editarDespesa(@PathVariable Long id, Model model) {
        Optional<Despesa> despesa = despesaService.encontrarDespesaPorId(id);
        if (despesa.isPresent()) {
            model.addAttribute("despesa", despesa.get());
            return "formulario";
        } else {
            return "redirect:/despesas";
        }
    }

    @PostMapping("/editar")
    public String atualizarDespesa(@ModelAttribute("despesa") Despesa despesa) {
        despesaService.atualizarDespesa(despesa);
        return "redirect:/despesas";
    }

    @GetMapping("/excluir/{id}")
    public String excluirDespesa(@PathVariable Long id) {
        despesaService.excluirDespesa(id);
        return "redirect:/despesas";
    }
}


