package listadetarefas.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import listadetarefas.todolist.entity.Tarefa;
import listadetarefas.todolist.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    //Criando uma nova tarefa
    @PostMapping
    List<Tarefa> create(@RequestBody Tarefa tarefa) {
        return tarefaService.create(tarefa);
    }

    //Exibindo todas as tarefas com GET
    @GetMapping
    List<Tarefa> list() { // não precisa passar parâmetro por causa do get
        return tarefaService.list();
    }

    @PutMapping
    List<Tarefa> update(@RequestBody Tarefa tarefa) {
        return tarefaService.update(tarefa);
    }

    @DeleteMapping("{id}") // precisa passar o parâmetro de id na rota
    List<Tarefa> delete(@PathVariable("id") Long id) {
        return tarefaService.delete(id);
    }
}