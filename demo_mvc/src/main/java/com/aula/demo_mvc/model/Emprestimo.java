package com.aula.demo_mvc.model;

public class Emprestimo {
    private String dataEmprestimo;
    private String dataDevolucao;
    private String status;

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
