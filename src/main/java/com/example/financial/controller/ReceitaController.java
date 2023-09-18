package com.example.financial.controller;

import com.example.financial.entity.Receita;
import com.example.financial.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    @Autowired
    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public String listarReceitas(Model model) {
        model.addAttribute("receitas", receitaService.listarTodasReceitas());
        return "listagem";
    }

    @GetMapping("/adicionar")
    public String exibirFormularioReceita(Model model) {
        model.addAttribute("receita", new Receita());
        return "formulario";
    }

    @PostMapping("/adicionar")
    public String adicionarReceita(@ModelAttribute("receita") Receita receita) {
        receitaService.adicionarReceita(receita);
        return "redirect:/receitas";
    }

    @GetMapping("/editar/{id}")
    public String editarReceita(@PathVariable Long id, Model model) {
        Optional<Receita> receita = receitaService.encontrarReceitaPorId(id);
        if (receita.isPresent()) {
            model.addAttribute("receita", receita.get());
            return "formulario";
        } else {
            return "redirect:/receitas";
        }
    }

    @PostMapping("/editar")
    public String atualizarReceita(@ModelAttribute("receita") Receita receita) {
        receitaService.atualizarReceita(receita);
        return "redirect:/receitas";
    }

    @GetMapping("/excluir/{id}")
    public String excluirReceita(@PathVariable Long id) {
        receitaService.excluirReceita(id);
        return "redirect:/receitas";
    }
}


