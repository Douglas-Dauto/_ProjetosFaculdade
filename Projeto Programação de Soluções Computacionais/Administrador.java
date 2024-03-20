package com.mycompany.projetoa3lojaderoupassociais;

import java.util.Collections;
import java.util.Comparator;

public class Administrador extends Pessoa implements Comparator<Administrador> {
    
    public Administrador() {
        
    }
    
    public Administrador(String cpf, String nome, int idade, String genero) {
        super(cpf, nome, genero, idade);
    }
    
    public void autoCadastroAdministradores() {
        getSetorPessoal().getAdministradores().add(new Administrador("27408232915", "Leandro", 34, "Masculino"));
        getSetorPessoal().getAdministradores().add(new Administrador("33907453219", "Aline", 28, "Feminino"));
        getSetorPessoal().getAdministradores().add(new Administrador("87139934508", "Lieci", 40, "Feminino"));
        Collections.sort(getSetorPessoal().getAdministradores(), new Administrador());
    }
    
    @Override
    public int compare(Administrador adm1, Administrador adm2) {
        if(adm1.getNome().toLowerCase().compareTo(adm2.getNome().toLowerCase()) > 0) {
            return 0;
        }
        return -1;
    }
}
