package com.mycompany.projetoa3lojaderoupassociais;

import java.util.ArrayList;
import java.util.Random;

public class VendaProduto {
    private int codigoVenda;
    private Produto produto;
    private Cliente cliente;
    private static ArrayList<VendaProduto> registroVendas = new ArrayList<>();
    Random aleatorio = new Random();
    
    public VendaProduto() {
        
    }
    
    public VendaProduto(Roupa roupa, Cliente cliente) {
        this.codigoVenda = aleatorio.nextInt(10000);
        this.produto = roupa;
        this.cliente = cliente;
    }
    
    public VendaProduto(Acessorio acessorio, Cliente cliente) {
        this.codigoVenda = aleatorio.nextInt(10000);
        this.produto = acessorio;
        this.cliente = cliente;
    }
    
    public void exibirRegistroVendaProdutos() {
        for(int i = 0;i < getRegistroVendas().size();i++) {
            System.out.println(getRegistroVendas().get(i).toString());
        }
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public ArrayList<VendaProduto> getRegistroVendas() {
        return registroVendas;
    }

    public void setRegistroVendas(ArrayList<VendaProduto> registroVendas) {
        this.registroVendas = registroVendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Código de venda: " + this.getCodigoVenda() + "\nCódigo de barras do produto vendido: " + this.getProduto().getCodigoBarras() + "\nCliente da venda: " + this.getCliente().getNome() + "\nCPF do cliente da venda: " + this.getCliente().getCpf() + "\n";
    }
}
