package com.mycompany.projetoa3lojaderoupassociais;

import java.util.ArrayList;

public class SetorProduto {
    private ArrayList<Roupa> roupas = new ArrayList<>();
    private ArrayList<Acessorio> acessorios = new ArrayList<>();

    public ArrayList<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(ArrayList<Roupa> roupas) {
        this.roupas = roupas;
    }

    public ArrayList<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(ArrayList<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}
