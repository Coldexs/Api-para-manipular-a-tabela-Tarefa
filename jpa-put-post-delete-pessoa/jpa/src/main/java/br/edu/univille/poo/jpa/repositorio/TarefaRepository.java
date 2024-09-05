package br.edu.univille.poo.jpa.repositorio;

import br.edu.univille.poo.jpa.entidade.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // Consultar todas as tarefas não finalizadas
    List<Tarefa> findAllByFinalizadoFalse();

    // Consultar todas as tarefas finalizadas
    List<Tarefa> findAllByFinalizadoTrue();

    // Consultar todas as tarefas atrasadas
    List<Tarefa> findAllByFinalizadoFalseAndDataPrevistaFinalizacaoBefore(LocalDate dataAtual);

    // Consultar todas as tarefas não finalizadas entre duas datas
    List<Tarefa> findAllByFinalizadoFalseAndDataPrevistaFinalizacaoBetween(LocalDate inicio, LocalDate fim);
}
