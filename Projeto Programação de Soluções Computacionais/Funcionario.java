package com.mycompany.projetoa3lojaderoupassociais;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;

public class Funcionario extends Pessoa implements Comparator<Funcionario> {
    private String cargo;
    private int anosExperiencia;
    
    public Funcionario() {
        
    }
    
    public Funcionario(String cpf, String nome, String genero, int idade, String cargo, int anosExperiencia) {
        super(cpf, nome, genero, idade);
        this.cargo = cargo;
        this.anosExperiencia = anosExperiencia;
    }
    
    public void cadastrarFuncionario() {
        String cpfFuncAux, nomeFuncAux, generoFuncAux, cargoFuncAux;
        int idadeFuncAux, anosExperienciaFuncAux;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o CPF do funcionário: ");
        cpfFuncAux = input.nextLine();
        System.out.println("Digite o nome do funcionário: ");
        nomeFuncAux = input.nextLine();
        System.out.println("Digite o genero do funcionário: ");
        generoFuncAux = input.nextLine();        
        System.out.println("Digite o cargo do funcionário: ");
        cargoFuncAux = input.nextLine();
        System.out.println("Digite a idade do funcionário: ");
        idadeFuncAux = input.nextInt();
        System.out.println("Digite os anos de experiência do funcionário: ");
        anosExperienciaFuncAux = input.nextInt();
        
        getSetorPessoal().getFuncionarios().add(new Funcionario(cpfFuncAux, nomeFuncAux, generoFuncAux, idadeFuncAux, cargoFuncAux, anosExperienciaFuncAux));
        Collections.sort(getSetorPessoal().getFuncionarios(), new Funcionario());
    }
    
    public void listarFuncionarios() {
        System.out.println("\nFuncionarios localizados: "); 
         
        for(int i = 0;i < getSetorPessoal().getFuncionarios().size();i++) {
            System.out.print("\n|" + (i+1) + "| ");
            System.out.print("CPF: " + getSetorPessoal().getFuncionarios().get(i).getCpf() + " | ");
            System.out.print("Nome: " + getSetorPessoal().getFuncionarios().get(i).getNome() + " | ");
            System.out.print("Cargo: " + getSetorPessoal().getFuncionarios().get(i).getCargo() + " | ");
            System.out.print("Genero: " + getSetorPessoal().getFuncionarios().get(i).getGenero() + " | ");
            System.out.print("Idade: " + getSetorPessoal().getFuncionarios().get(i).getIdade() + " | ");
            System.out.print("Anos de experiencia: " + getSetorPessoal().getFuncionarios().get(i).getAnosExperiencia());
        }
        System.out.println("");
    }
    
    public void buscarFuncionarios() {
        System.out.println("Digite o nome do funcionário que deseja buscar: ");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine().toLowerCase();        
           
        List<Funcionario> funcionarios = getSetorPessoal().getFuncionarios().stream().filter(f -> f.getNome().toLowerCase().contains(nome)).collect(Collectors.toList());
        System.out.println("\nFuncionarios localizados: ");
            
        for(int i = 0;i < funcionarios.size();i++) {
            System.out.print("\n|" + (i+1) + "| ");
            System.out.print("ID: " + funcionarios.get(i).getId() + " | ");
            System.out.print("CPF: " + funcionarios.get(i).getCpf() + " | ");
            System.out.print("Nome: " + funcionarios.get(i).getNome() + " | ");
            System.out.print("Cargo: " + funcionarios.get(i).getCargo() + " | ");
            System.out.print("Genero: " + funcionarios.get(i).getGenero() + " | ");
            System.out.print("Idade: " + funcionarios.get(i).getIdade() + " | ");
            System.out.print("Anos de experiencia: " + funcionarios.get(i).getAnosExperiencia());
        }
        System.out.println("");
    }
    
    public void editarFuncionario() {
        System.out.println("Digite o cpf do funcionário que deseja editar: ");
        Scanner input = new Scanner(System.in);
        String buscaCpf = input.nextLine(), cpf, nome, cargo, genero;
        int numSelecionado, idade, anosExp;
        
        for(int i = 0;i < getSetorPessoal().getFuncionarios().size();i++) {
            cpf = getSetorPessoal().getFuncionarios().get(i).getCpf();
            nome = getSetorPessoal().getFuncionarios().get(i).getNome();
            cargo = getSetorPessoal().getFuncionarios().get(i).getCargo();
            genero = getSetorPessoal().getFuncionarios().get(i).getGenero();
            idade = getSetorPessoal().getFuncionarios().get(i).getIdade();
            anosExp = getSetorPessoal().getFuncionarios().get(i).getAnosExperiencia();
            
            if(getSetorPessoal().getFuncionarios().get(i).getCpf().equals(buscaCpf)) {
                System.out.println("Digite o número do que você deseja editar no funcionário: ");
                System.out.println("1 - Editar Cpf");
                System.out.println("2 - Editar Nome");
                System.out.println("3 - Editar Cargo");
                System.out.println("4 - Editar Genero");
                System.out.println("5 - Editar Idade");
                System.out.println("6 - Editar Anos de Experiência");
                System.out.println("7 - Voltar");
                System.out.print("\nDigite aqui: ");
                numSelecionado = input.nextInt();
                buscaCpf = input.nextLine();
                
                switch(numSelecionado) {
                    case 1: 
                        System.out.println("Digite o novo cpf do funcionário: ");
                        cpf = input.nextLine();
                        break;
                    case 2:
                        System.out.println("Digite o novo nome do funcionário: ");
                        nome = input.nextLine();
                        break;
                    case 3: 
                        System.out.println("Digite o novo cargo do funcionário: ");
                        cargo = input.nextLine();
                        break;
                    case 4: 
                        System.out.println("Digite o novo genero do funcionário: ");
                        genero = input.nextLine();
                        break;
                    case 5:
                        System.out.println("Digite a nova idade do funcionário: ");
                        idade = input.nextInt();
                        break;
                    case 6:
                        System.out.println("Digite a nova quantidade de anos de experiência do funcionário: ");
                        anosExp = input.nextInt();
                        break;
                    default: 
                        Principal.setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                        Principal.carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                        break;
                }
                
                if(numSelecionado < 7) {
                    System.out.println("Tem certeza que deseja aplicar a edição? \nDigite \"S\" ou \"N\": ");
                    String opcaoEscolhida = input.nextLine().toUpperCase();

                    if(opcaoEscolhida.equals("S") || opcaoEscolhida.equals("SIM")) {
                        getSetorPessoal().getFuncionarios().set(i, new Funcionario(cpf, nome, genero, idade, cargo, anosExp));
                        System.out.println("Funcionário editado com sucesso.");
                    } else {
                        System.out.println("O funcionário não foi editado.");
                    }
                }
            }
        }
    }
    
    public void removerFuncionario() {
        System.out.println("Digite o cpf do funcionário que deseja remover: ");
        Scanner input = new Scanner(System.in);
        String cpf = input.nextLine();
        int contador = 0;
        
        for(int i = 0;i < getSetorPessoal().getFuncionarios().size();i++) {
            if(getSetorPessoal().getFuncionarios().get(i).getCpf().equals(cpf)) {
                System.out.println("Tem certeza que deseja remover? \nDigite \"S\" ou \"N\": ");
                String opcaoEscolhida = input.nextLine().toUpperCase();
                
                if(opcaoEscolhida.equals("S") || opcaoEscolhida.equals("SIM")) {
                    getSetorPessoal().getFuncionarios().remove(i);
                    System.out.println("Funcionário removido com sucesso.");
                } else {
                    System.out.println("O funcionário não foi removido.");
                }
            } else if(getSetorPessoal().getFuncionarios().size() == contador) {
                System.out.println("Funcionário não encontrado.");
            } contador++;
        }
    }
    
    public void autoCadastroFuncionarios() {
        Random aleatorio = new Random();
        getSetorPessoal().getFuncionarios().add(new Funcionario("83539276409", "Ana Beatriz", "Feminino", 30, "Gerente de vendas", aleatorio.nextInt(10)));
        getSetorPessoal().getFuncionarios().add(new Funcionario("97558211451", "Diego Castro", "Masculino", 19, "Operador de Loja", 0));
        getSetorPessoal().getFuncionarios().add(new Funcionario("15646108935", "Catarina Bragança", "Feminino", 25, "Promotora de vendas", aleatorio.nextInt(9)));
        getSetorPessoal().getFuncionarios().add(new Funcionario("37700138723", "Lucas Oliveira", "Masculino", 38, "Analista de pós-venda", aleatorio.nextInt(16)));
        getSetorPessoal().getFuncionarios().add(new Funcionario("18244522198", "Marcos Francisco", "Masculino", 29, "Consultor de vendas", aleatorio.nextInt(9)));
        getSetorPessoal().getFuncionarios().add(new Funcionario("62034208506", "Luana Dias", "Feminino", 21, "Assistente comercial", aleatorio.nextInt(9)));
        getSetorPessoal().getFuncionarios().add(new Funcionario("38971590690", "Vinícios Sampaio", "Masculino", 40, "Auxiliar de vendas", aleatorio.nextInt(19)));
        Collections.sort(getSetorPessoal().getFuncionarios(), new Funcionario());
    }
    
    @Override
    public int compare(Funcionario func1, Funcionario func2) {
        if(func1.getNome().toLowerCase().compareTo(func2.getNome().toLowerCase()) > 0) {
            return 0;
        }
        return -1;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }
}
