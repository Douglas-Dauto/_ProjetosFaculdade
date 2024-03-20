package com.mycompany.projetoa3lojaderoupassociais;

import java.util.ArrayList;

public class SetorPessoal {
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }
    
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
