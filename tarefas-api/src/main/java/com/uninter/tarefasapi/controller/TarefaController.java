package com.uninter.tarefasapi.controller;

import com.uninter.tarefasapi.model.Tarefa;
import com.uninter.tarefasapi.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping("/create")
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @GetMapping("/all")
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable Long id) {
        return tarefaRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow();
        tarefa.setNome(tarefaAtualizada.getNome());
        tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
        tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
        return tarefaRepository.save(tarefa);
    }


    @DeleteMapping("/{id}")
    public void removerTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}

