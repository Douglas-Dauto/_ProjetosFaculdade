
package com.mycompany.projetoa3lojaderoupassociais;

public class Pessoa {
    private String cpf, nome, genero;
    private int id, idade;
    private SetorPessoal setorPessoal = new SetorPessoal();
    
    public Pessoa() {
        
    }
    
    public Pessoa(String cpf, String nome, String genero, int idade) {
        this.id = setorPessoal.getFuncionarios().size() + 1;
        this.cpf = cpf;
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public SetorPessoal getSetorPessoal() {
        return setorPessoal;
    }

    public void setSetorPessoal(SetorPessoal setorPessoal) {
        this.setorPessoal = setorPessoal;
    }
}
