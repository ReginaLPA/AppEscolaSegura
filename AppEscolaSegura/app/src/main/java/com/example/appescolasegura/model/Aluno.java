package com.example.appescolasegura.model;

import java.io.Serializable;

public class Aluno implements Serializable {

    private long ra;
    private String nomeAluno;
    private String responsavel;
    private String email;
    private long senha;

    @Override
    public String toString(){
        return nomeAluno.toString();
    }
    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeProduto) {
        this.nomeAluno = nomeProduto;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public long getRa() {
        return ra;
    }

    public void setRa(long ra) {
        this.ra = ra;
    }
}
