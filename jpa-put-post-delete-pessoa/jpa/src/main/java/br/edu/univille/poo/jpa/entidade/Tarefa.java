package br.edu.univille.poo.jpa.entidade;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricaoLonga;

    @Column(nullable = false)
    private boolean finalizado = false;

    @Column(nullable = false)
    private LocalDate dataPrevistaFinalizacao;

    private LocalDate dataFinalizacao;

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.length() < 5) {
            throw new RuntimeException("O título da tarefa deve conter pelo menos 5 caracteres.");
        }
        this.titulo = titulo;
    }

    public String getDescricaoLonga() {
        return descricaoLonga;
    }

    public void setDescricaoLonga(String descricaoLonga) {
        this.descricaoLonga = descricaoLonga;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public LocalDate getDataPrevistaFinalizacao() {
        return dataPrevistaFinalizacao;
    }

    public void setDataPrevistaFinalizacao(LocalDate dataPrevistaFinalizacao) {
        if (dataPrevistaFinalizacao == null) {
            throw new RuntimeException("A data prevista de finalização é obrigatória.");
        }
        this.dataPrevistaFinalizacao = dataPrevistaFinalizacao;
    }

    public LocalDate getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDate dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
