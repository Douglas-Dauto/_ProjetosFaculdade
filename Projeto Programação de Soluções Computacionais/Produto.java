package com.mycompany.projetoa3lojaderoupassociais;

public class Produto {
    private int id, codigoBarras, quantidade;
    private String preco, cor, nome, marca, tamanho;
    private SetorPessoal setorPessoal = new SetorPessoal();
    private SetorProduto setorProduto = new SetorProduto();

    public Produto() {
        
    }
    
    public Produto(int codigoBarras, String preco, int quantidade, String tamanho, String cor, String nome, String marca) {
        this.id = setorProduto.getRoupas().size() + 1;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.cor = cor;
        this.nome = nome;
        this.marca = marca;
    }
    
    public Produto(int codigoBarras, String preco, int quantidade, String cor, String nome, String marca) {
        this.id = setorProduto.getAcessorios().size() + 1;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.quantidade = quantidade;
        this.cor = cor;
        this.nome = nome;
        this.marca = marca;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public SetorPessoal getSetorPessoal() {
        return setorPessoal;
    }

    public void setSetorPessoal(SetorPessoal setorPessoal) {
        this.setorPessoal = setorPessoal;
    }

    public SetorProduto getSetorProduto() {
        return setorProduto;
    }

    public void setSetorProduto(SetorProduto setorProduto) {
        this.setorProduto = setorProduto;
    }
}
