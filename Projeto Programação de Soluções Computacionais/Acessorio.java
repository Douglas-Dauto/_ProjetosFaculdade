package com.mycompany.projetoa3lojaderoupassociais;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Acessorio extends Produto implements Comparator<Acessorio> {
    
    public Acessorio() {
        
    }
    
    public Acessorio(int codigoBarras, String preco, int quantidade, String cor, String nome, String marca) {
        super(codigoBarras, preco, quantidade, cor, nome, marca);
    }
    
    public void venderAcessorios() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o código de barras o acessório que deseja vender: ");
        String nomeClienteAux, generoClienteAux, vendaCpf = "", numCartaoAux;
        int idadeClienteAux, vendaCodigoBarras = input.nextInt(), qtdVenda = 0, pagamento;
        Acessorio acessorioVenda = new Acessorio();
        boolean passo = false;
        int contadorIndicie = 0;
        
        for(int i = 0;i < getSetorProduto().getAcessorios().size();i++) {
            if(getSetorProduto().getAcessorios().get(i).getCodigoBarras() == vendaCodigoBarras) {
                acessorioVenda = getSetorProduto().getAcessorios().get(i);
                System.out.println("Qual a quantidade desejada para venda?: ");
                System.out.print("\nDigite aqui: ");
                qtdVenda = input.nextInt();
                System.out.println("Digite o CPF do cliente: ");
                System.out.print("\nDigite aqui: ");
                vendaCpf = input.nextLine();
                vendaCpf = input.nextLine();
                passo = true;
                contadorIndicie = i;
            }
        }
        
        if(passo == true) {
            for(int i = 0;i < getSetorPessoal().getClientes().size();i++) {
                if(getSetorPessoal().getClientes().get(i).getCpf().equals(vendaCpf)) {
                    passo = false;
                    System.out.println("Finalizar venda no cartão de crédito ou dinheiro?: ");
                    System.out.println("1 - Dinheiro");
                    System.out.println("2 - Cartão de crédito");
                    System.out.print("\nDigite aqui: ");
                    pagamento = input.nextInt();

                    switch(pagamento) {
                        case 1:
                            VendaProduto vendaProdutos = new VendaProduto();
                            vendaProdutos.getRegistroVendas().add(new VendaProduto(acessorioVenda, new Cliente(vendaCpf, getSetorPessoal().getClientes().get(i).getNome(), getSetorPessoal().getClientes().get(i).getGenero(), getSetorPessoal().getClientes().get(i).getIdade(), EnumFormaPagamento.DINHEIRO)));
                            if(acessorioVenda.getQuantidade() > qtdVenda) {
                                getSetorProduto().getAcessorios().set(contadorIndicie, new Acessorio(acessorioVenda.getCodigoBarras(), acessorioVenda.getPreco(), acessorioVenda.getQuantidade() - qtdVenda, acessorioVenda.getCor(), acessorioVenda.getNome(), acessorioVenda.getMarca()));
                            } else {
                                getSetorProduto().getAcessorios().remove(contadorIndicie);
                            }
                            break;
                        default:
                            System.out.println("Digite o número do cartão: ");
                            numCartaoAux = input.nextLine();
                            numCartaoAux = input.nextLine();
                            VendaProduto vendaProdutosCard = new VendaProduto();
                            vendaProdutosCard.getRegistroVendas().add(new VendaProduto(acessorioVenda, new Cliente(vendaCpf, getSetorPessoal().getClientes().get(i).getNome(), getSetorPessoal().getClientes().get(i).getGenero(), getSetorPessoal().getClientes().get(i).getIdade(), EnumFormaPagamento.CARTAO_CREDITO, numCartaoAux)));
                            if(acessorioVenda.getQuantidade() > qtdVenda) {
                                getSetorProduto().getAcessorios().set(contadorIndicie, new Acessorio(acessorioVenda.getCodigoBarras(), acessorioVenda.getPreco(), acessorioVenda.getQuantidade() - qtdVenda, acessorioVenda.getCor(), acessorioVenda.getNome(), acessorioVenda.getMarca()));
                            } else {
                                getSetorProduto().getAcessorios().remove(contadorIndicie);
                            }
                            break;
                    }
                    Collections.sort(getSetorPessoal().getClientes(), new Cliente());
                }
            }
        }
        
        if(passo == true) {
            System.out.println("Digite o nome do cliente: ");
            System.out.print("\nDigite aqui: ");
            nomeClienteAux = input.nextLine();
            System.out.println("Digite o genero do cliente: ");
            System.out.print("\nDigite aqui: ");
            generoClienteAux = input.nextLine();
            System.out.println("Digite a idade do cliente: ");
            System.out.print("\nDigite aqui: ");
            idadeClienteAux = input.nextInt();
            System.out.println("Finalizar venda no cartão de crédito ou dinheiro?: ");
            System.out.println("1 - Dinheiro");
            System.out.println("2 - Cartão de crédito");
            System.out.print("\nDigite aqui: ");
            pagamento = input.nextInt();
            
            switch(pagamento) {
                case 1:
                    getSetorPessoal().getClientes().add(new Cliente(vendaCpf, nomeClienteAux, generoClienteAux, idadeClienteAux, EnumFormaPagamento.DINHEIRO));
                    VendaProduto vendaProdutos = new VendaProduto();
                    vendaProdutos.getRegistroVendas().add(new VendaProduto(acessorioVenda, new Cliente(vendaCpf, nomeClienteAux, generoClienteAux, idadeClienteAux, EnumFormaPagamento.DINHEIRO)));
                    if(acessorioVenda.getQuantidade() > qtdVenda) {
                        getSetorProduto().getAcessorios().set(contadorIndicie, new Acessorio(acessorioVenda.getCodigoBarras(), acessorioVenda.getPreco(), acessorioVenda.getQuantidade() - qtdVenda, acessorioVenda.getCor(), acessorioVenda.getNome(), acessorioVenda.getMarca()));
                    } else {
                        getSetorProduto().getAcessorios().remove(contadorIndicie);
                    }
                    break;
                default:
                    System.out.println("Digite o número do cartão: ");
                    numCartaoAux = input.nextLine();
                    numCartaoAux = input.nextLine();
                    getSetorPessoal().getClientes().add(new Cliente(vendaCpf, nomeClienteAux, generoClienteAux, idadeClienteAux, EnumFormaPagamento.CARTAO_CREDITO, numCartaoAux));
                    VendaProduto vendaProdutosCard = new VendaProduto();
                    vendaProdutosCard.getRegistroVendas().add(new VendaProduto(acessorioVenda, new Cliente(vendaCpf, nomeClienteAux, generoClienteAux, idadeClienteAux, EnumFormaPagamento.CARTAO_CREDITO, numCartaoAux)));
                    if(acessorioVenda.getQuantidade() > qtdVenda) {
                        getSetorProduto().getAcessorios().set(contadorIndicie, new Acessorio(acessorioVenda.getCodigoBarras(), acessorioVenda.getPreco(), acessorioVenda.getQuantidade() - qtdVenda, acessorioVenda.getCor(), acessorioVenda.getNome(), acessorioVenda.getMarca()));
                    } else {
                        getSetorProduto().getAcessorios().remove(contadorIndicie);
                    }
                    break;
            }
            Collections.sort(getSetorPessoal().getClientes(), new Cliente());
        }
    }
    
    public void cadastrarAcessorios() {
        int quantidadeAcessorioAux, codigoBarrasAux;
        String precoAcessorioAux, corAcessorioaAux, tipoPecaAcessorioAux, marcaAcessorioAux;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do(s) acessorio(s): ");
        tipoPecaAcessorioAux = input.nextLine();
        System.out.println("Digite a cor do(s) acessorio(s): ");
        corAcessorioaAux = input.nextLine();
        System.out.println("Digite a marca do(s) acessorio(s): ");
        marcaAcessorioAux = input.nextLine();
        System.out.println("Digite o preço do(s) acessorio(s): ");
        System.out.print("R$ ");
        precoAcessorioAux = input.nextLine();
        System.out.println("Digite a quantidade de acessorio(s): ");
        quantidadeAcessorioAux = input.nextInt();
        System.out.println("Digite o código de barras do acessorio(s): ");
        codigoBarrasAux = input.nextInt();
                                                                       //  Adiciona ao ArrayList novos objetos Acessorio com as informações passadas pelo usuário
        getSetorProduto().getAcessorios().add(new Acessorio(codigoBarrasAux, precoAcessorioAux, quantidadeAcessorioAux, corAcessorioaAux, tipoPecaAcessorioAux, marcaAcessorioAux));
        Collections.sort(getSetorProduto().getAcessorios(), new Acessorio());
    }
    
    public void listarAcessorios() {
        System.out.println("\nAcessórios localizados: "); 
         
        for(int i = 0;i < getSetorProduto().getAcessorios().size();i++) {
            System.out.print("\n|" + (i+1) + "| ");
            System.out.print("Código de barras: " + getSetorProduto().getAcessorios().get(i).getCodigoBarras() + " | ");
            System.out.print("Nome: " + getSetorProduto().getAcessorios().get(i).getNome() + " | ");
            System.out.print("Marca: " + getSetorProduto().getAcessorios().get(i).getMarca() + " | ");
            System.out.print("Cor: " + getSetorProduto().getAcessorios().get(i).getCor() + " | ");
            System.out.print("Quantidade: " + getSetorProduto().getAcessorios().get(i).getQuantidade() + " | ");
            System.out.print("Preço: " + getSetorProduto().getAcessorios().get(i).getPreco() + " | ");
        }
        System.out.println("");
    }
    
    public void buscarAcessorios() {
        System.out.println("Digite o nome do acessorio: ");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine().toLowerCase();   
           
        List<Acessorio> acessorios = getSetorProduto().getAcessorios().stream().filter(f -> f.getNome().toLowerCase().contains(nome)).collect(Collectors.toList());
        
        System.out.println("\nAcessórios localizados: "); 
         
        for(int i = 0;i < acessorios.size();i++) {
            System.out.print("\n|" + (i+1) + "| ");
            System.out.print("ID: " + acessorios.get(i).getId() + " | ");
            System.out.print("Código de barras: " + acessorios.get(i).getCodigoBarras() + " | ");
            System.out.print("Nome: " + acessorios.get(i).getNome() + " | ");
            System.out.print("Marca: " + acessorios.get(i).getMarca() + " | ");
            System.out.print("Cor: " + acessorios.get(i).getCor() + " | ");
            System.out.print("Quantidade: " + acessorios.get(i).getQuantidade() + " | ");
            System.out.print("Preço: " + acessorios.get(i).getPreco() + " | ");
        }
        System.out.println("");
    }
    
    public void editarAcessorio() {
        System.out.println("Digite o código de barras do acessorio que deseja editar: ");
        Scanner input = new Scanner(System.in);
        String nome, marca, cor, tamanho, tipoTecido, preco;
        int numSelecionado, buscaCodigoBarras = input.nextInt(), quantidade, codigoBarras;
        
        for(int i = 0;i < getSetorProduto().getAcessorios().size();i++) {
            nome = getSetorProduto().getAcessorios().get(i).getNome();
            marca = getSetorProduto().getAcessorios().get(i).getMarca();
            cor = getSetorProduto().getAcessorios().get(i).getCor();
            quantidade = getSetorProduto().getAcessorios().get(i).getQuantidade();
            codigoBarras = getSetorProduto().getAcessorios().get(i).getCodigoBarras();
            preco = getSetorProduto().getAcessorios().get(i).getPreco();
            
            if(getSetorProduto().getAcessorios().get(i).getCodigoBarras() == buscaCodigoBarras) {
                System.out.println("Digite o número do que você deseja editar no acessório: ");
                System.out.println("1 - Editar Código de Barras");
                System.out.println("2 - Editar Nome");
                System.out.println("3 - Editar Marca");
                System.out.println("4 - Editar Cor");
                System.out.println("5 - Editar Preço");
                System.out.println("6 - Editar Quantidade");
                System.out.println("7 - Voltar");
                System.out.print("\nDigite aqui: ");
                numSelecionado = input.nextInt();
                nome = input.nextLine();
                
                switch(numSelecionado) {
                    case 1: 
                        System.out.println("Digite o novo código de barras do acessório: ");
                        codigoBarras = input.nextInt();
                        nome = input.nextLine();
                        break;
                    case 2:
                        System.out.println("Digite o novo nome do acessório: ");
                        nome = input.nextLine();
                        break;
                    case 3: 
                        System.out.println("Digite a nova marca do acessório: ");
                        marca = input.nextLine();
                        break;
                    case 4: 
                        System.out.println("Digite a nova cor do acessório: ");
                        cor = input.nextLine();
                        break;
                    case 5:
                        System.out.println("Digite o novo preço do acessório: ");
                        preco = input.nextLine();
                        break;
                    case 6:
                        System.out.println("Digite a nova quantidade do acessório: ");
                        quantidade = input.nextInt();
                        break;
                    default: 
                       // Principal.setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                       // Principal.carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                        break;
                }
                
                if(numSelecionado < 7) {
                    System.out.println("Tem certeza que deseja aplicar a edição? \nDigite \"S\" ou \"N\": ");
                    String opcaoEscolhida = input.nextLine().toUpperCase();

                    if(opcaoEscolhida.equals("S") || opcaoEscolhida.equals("SIM")) {
                        getSetorProduto().getAcessorios().set(i, new Acessorio(codigoBarras, preco, quantidade, cor, nome, marca));
                        System.out.println("Acessório editado com sucesso.");
                    } else {
                        System.out.println("O acessório não foi editado.");
                    }
                }
            }
        }
    }
    
    public void removerAcessorio() {
        System.out.println("Digite o código de barras do acessorio que deseja remover: ");
        Scanner input = new Scanner(System.in);
        int codigoBarras = input.nextInt(), contador = 0;
        
        for(int i = 0;i < getSetorProduto().getAcessorios().size();i++) {
            if(getSetorProduto().getAcessorios().get(i).getCodigoBarras() == codigoBarras) {
                System.out.println("Tem certeza que deseja remover? \nDigite \"S\" ou \"N\": ");
                String resolveErroScanner = input.nextLine(), opcaoEscolhida = input.nextLine().toUpperCase();
                
                if(opcaoEscolhida.equals("S") || opcaoEscolhida.equals("SIM")) {
                    getSetorProduto().getAcessorios().remove(i);
                    System.out.println("Acessorio removido com sucesso.");
                } else {
                    System.out.println("O acessorio não foi removido.");
                }
            } else if(getSetorProduto().getAcessorios().size() == contador) {
                System.out.println("Acessorio não encontrado.");
            } contador++;
        }
    }
    
    public void autoCadastroAcessorios() {
        Random aleatorio = new Random();        
        getSetorProduto().getAcessorios().add(new Acessorio(aleatorio.nextInt(10000), "63,55", aleatorio.nextInt(1000), "Vermelho", "Relogio", "Breitling"));
        getSetorProduto().getAcessorios().add(new Acessorio(aleatorio.nextInt(10000), "140,49", aleatorio.nextInt(1000), "Verde", "Colar", "Vivara"));
        getSetorProduto().getAcessorios().add(new Acessorio(aleatorio.nextInt(10000), "41,26", aleatorio.nextInt(1000), "Branco", "Pulsera", "Nautico"));
        getSetorProduto().getAcessorios().add(new Acessorio(aleatorio.nextInt(10000), "4,13", aleatorio.nextInt(1000), "Cinza", "Palheta Barbatana", "virtua"));
        getSetorProduto().getAcessorios().add(new Acessorio(aleatorio.nextInt(10000), "50,99", aleatorio.nextInt(1000), "Preto", "Esticador De Camisa", "Shein"));
        getSetorProduto().getAcessorios().add(new Acessorio(aleatorio.nextInt(10000), "9,17", aleatorio.nextInt(1000), "Azul", "Clips Para Camisa", "Wakauto"));
        getSetorProduto().getAcessorios().add(new Acessorio(aleatorio.nextInt(10000), "118,39", aleatorio.nextInt(1000), "Preto", "Brinco", "Rommanel"));   
        Collections.sort(getSetorProduto().getAcessorios(), new Acessorio());
    }
    
    @Override
    public int compare(Acessorio acessorio1, Acessorio acessorio2) {
        if(acessorio1.getNome().toLowerCase().compareTo(acessorio2.getNome().toLowerCase()) > 0) {
            return 0;
        }
        return -1;
    }
}
