package com.mycompany.projetoa3lojaderoupassociais;

import java.util.Comparator;

public class Cliente extends Pessoa implements Comparator<Cliente> {
    String numCartao;
    EnumFormaPagamento formaPagamento;

    public Cliente() {
        
    }
    
    public Cliente(String cpf, String nome, String genero, int idade, EnumFormaPagamento formaPagamento) {
        super(cpf, nome, genero, idade);
    }
    
    public Cliente(String cpf, String nome, String genero, int idade, EnumFormaPagamento formaPagamento, String numCartao) {
        super(cpf, nome, genero, idade);
        this.numCartao = numCartao;
    }
    
    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {
        if(cliente1.getNome().toLowerCase().compareTo(cliente2.getNome().toLowerCase()) > 0) {
            return 0;
        }
        return -1;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }
}
