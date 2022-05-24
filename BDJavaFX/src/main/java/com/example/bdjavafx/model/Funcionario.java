package com.example.bdjavafx.model;

public class Funcionario {
    private int id;
    private String cpf;
    private String nome;
    Departamento departamento;

    public Funcionario(int id, String cpf, String nome, Departamento departamento) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.departamento = departamento;
    }

    public Funcionario(String cpf, String nome, Departamento departamento) {
        this.cpf = cpf;
        this.nome = nome;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
