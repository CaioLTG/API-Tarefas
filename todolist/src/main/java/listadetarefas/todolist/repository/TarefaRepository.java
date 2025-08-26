package listadetarefas.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import listadetarefas.todolist.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}