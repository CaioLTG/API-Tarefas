package listadetarefas.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import listadetarefas.todolist.entity.Tarefa;
import listadetarefas.todolist.repository.TarefaRepository;;

@Service
public class TarefaService {
    private TarefaRepository tarefaRepository;
     
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> create(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
        return list();
    }

    public List<Tarefa> list() {
        Sort sort = Sort.by("nome").ascending();
        return tarefaRepository.findAll(sort);
    }

    public List<Tarefa> update(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
        return list();
    }

    public List<Tarefa> delete(Long id) {
        tarefaRepository.deleteById(id);
        return list();
    }
}