package com.mycompany.projetoa3lojaderoupassociais;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Roupa extends Produto implements Comparator<Roupa> {
    private String tipoTecido;
    
    public Roupa() {
        
    }
    
    public Roupa(int codigoBarras, String preco, int quantidade, String tamanho, String cor, String nome, String tipoTecido, String marca) {
        super(codigoBarras, preco, quantidade, tamanho, cor, nome, marca);
        this.tipoTecido = tipoTecido;
    }
    
    public void venderRoupas() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o código de barras da roupa que deseja vender: ");
        String nomeClienteAux, generoClienteAux, vendaCpf = "", numCartaoAux;
        int idadeClienteAux, vendaCodigoBarras = input.nextInt(), qtdVenda = 0, pagamento;
        Roupa roupaVenda = new Roupa();
        boolean passo = false;
        int contadorIndicie = 0;
        
        for(int i = 0;i < getSetorProduto().getRoupas().size();i++) {
            if(getSetorProduto().getRoupas().get(i).getCodigoBarras() == vendaCodigoBarras) {
                roupaVenda = getSetorProduto().getRoupas().get(i);
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
                            vendaProdutos.getRegistroVendas().add(new VendaProduto(roupaVenda, new Cliente(vendaCpf, getSetorPessoal().getClientes().get(i).getNome(), getSetorPessoal().getClientes().get(i).getGenero(), getSetorPessoal().getClientes().get(i).getIdade(), EnumFormaPagamento.DINHEIRO)));
                            if(roupaVenda.getQuantidade() > qtdVenda) {
                                getSetorProduto().getRoupas().set(contadorIndicie, new Roupa(roupaVenda.getCodigoBarras(), roupaVenda.getPreco(), roupaVenda.getQuantidade() - qtdVenda, roupaVenda.getTamanho(), roupaVenda.getCor(), roupaVenda.getNome(), roupaVenda.getTipoTecido(), roupaVenda.getMarca()));
                            } else {
                                getSetorProduto().getRoupas().remove(contadorIndicie);
                            }
                            break;
                        default:
                            System.out.println("Digite o número do cartão: ");
                            numCartaoAux = input.nextLine();
                            numCartaoAux = input.nextLine();
                            VendaProduto vendaProdutosCard = new VendaProduto();
                            vendaProdutosCard.getRegistroVendas().add(new VendaProduto(roupaVenda, new Cliente(vendaCpf, getSetorPessoal().getClientes().get(i).getNome(), getSetorPessoal().getClientes().get(i).getGenero(), getSetorPessoal().getClientes().get(i).getIdade(), EnumFormaPagamento.CARTAO_CREDITO, numCartaoAux)));
                            if(roupaVenda.getQuantidade() > qtdVenda) {
                                getSetorProduto().getRoupas().set(contadorIndicie, new Roupa(roupaVenda.getCodigoBarras(), roupaVenda.getPreco(), roupaVenda.getQuantidade() - qtdVenda, roupaVenda.getTamanho(), roupaVenda.getCor(), roupaVenda.getNome(), roupaVenda.getTipoTecido(), roupaVenda.getMarca()));
                            } else {
                                getSetorProduto().getRoupas().remove(contadorIndicie);
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
                    vendaProdutos.getRegistroVendas().add(new VendaProduto(roupaVenda, new Cliente(vendaCpf, nomeClienteAux, generoClienteAux, idadeClienteAux, EnumFormaPagamento.DINHEIRO)));
                    if(roupaVenda.getQuantidade() > qtdVenda) {
                        getSetorProduto().getRoupas().set(contadorIndicie, new Roupa(roupaVenda.getCodigoBarras(), roupaVenda.getPreco(), roupaVenda.getQuantidade() - qtdVenda, roupaVenda.getTamanho(), roupaVenda.getCor(), roupaVenda.getNome(), roupaVenda.getTipoTecido(), roupaVenda.getMarca()));
                    } else {
                        getSetorProduto().getRoupas().remove(contadorIndicie);
                    }
                    break;
                default:
                    System.out.println("Digite o número do cartão: ");
                    numCartaoAux = input.nextLine();
                    numCartaoAux = input.nextLine();
                    getSetorPessoal().getClientes().add(new Cliente(vendaCpf, nomeClienteAux, generoClienteAux, idadeClienteAux, EnumFormaPagamento.CARTAO_CREDITO, numCartaoAux));
                    VendaProduto vendaProdutosCard = new VendaProduto();
                    vendaProdutosCard.getRegistroVendas().add(new VendaProduto(roupaVenda, new Cliente(vendaCpf, nomeClienteAux, generoClienteAux, idadeClienteAux, EnumFormaPagamento.CARTAO_CREDITO, numCartaoAux)));
                    if(roupaVenda.getQuantidade() > qtdVenda) {
                        getSetorProduto().getRoupas().set(contadorIndicie, new Roupa(roupaVenda.getCodigoBarras(), roupaVenda.getPreco(), roupaVenda.getQuantidade() - qtdVenda, roupaVenda.getTamanho(), roupaVenda.getCor(), roupaVenda.getNome(), roupaVenda.getTipoTecido(), roupaVenda.getMarca()));
                    } else {
                        getSetorProduto().getRoupas().remove(contadorIndicie);
                    }
                    break;
            }
            Collections.sort(getSetorPessoal().getClientes(), new Cliente());
        }
    }
    
    public void cadastrarRoupas() {
        int quantidadeRoupaAux, codigoBarrasAux;
        String precoRoupaAux, corRoupaAux, tipoPecaRoupaAux, tipoTecidoRoupaAux, marcaRoupaAux, tamanhoRoupaAux;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome da(s) roupa(s): ");
        tipoPecaRoupaAux = input.nextLine();
        System.out.println("Digite o tamanho da(s) roupa(s): ");
        tamanhoRoupaAux = input.nextLine();
        System.out.println("Digite a cor da(s) roupa(s): ");
        corRoupaAux = input.nextLine();
        System.out.println("Digite o tipo de tecido da(s) roupa(s): ");
        tipoTecidoRoupaAux = input.nextLine();
        System.out.println("Digite a marca da(s) roupa(s): ");
        marcaRoupaAux = input.nextLine();
        System.out.println("Digite o preço do(s) produto(s): ");
        System.out.print("R$ ");
        precoRoupaAux = input.nextLine();
        System.out.println("Digite a quantidade de roupa(s): ");
        quantidadeRoupaAux = input.nextInt();
        System.out.println("Digite o código de barras da roupa(s): ");
        codigoBarrasAux = input.nextInt();
        
        getSetorProduto().getRoupas().add(new Roupa(codigoBarrasAux, precoRoupaAux, quantidadeRoupaAux, tamanhoRoupaAux, corRoupaAux, tipoPecaRoupaAux, tipoTecidoRoupaAux, marcaRoupaAux));
        Collections.sort(getSetorProduto().getRoupas(), new Roupa());
    }
    
    public void listarRoupas() {
        System.out.println("\nRoupas localizadas: "); 
         
        for(int i = 0;i < getSetorProduto().getRoupas().size();i++) {
            System.out.print("\n|" + (i+1) + "| ");
            System.out.print("Código de barras: " + getSetorProduto().getRoupas().get(i).getCodigoBarras() + " | ");
            System.out.print("Nome: " + getSetorProduto().getRoupas().get(i).getNome() + " | ");
            System.out.print("Marca: " + getSetorProduto().getRoupas().get(i).getMarca() + " | ");
            System.out.print("Cor: " + getSetorProduto().getRoupas().get(i).getCor() + " | ");
            System.out.print("Tamanho: " + getSetorProduto().getRoupas().get(i).getTamanho() + " | ");
            System.out.print("Tipo de tecido: " + getSetorProduto().getRoupas().get(i).getTipoTecido() + " | ");
            System.out.print("Quantidade: " + getSetorProduto().getRoupas().get(i).getQuantidade() + " | ");
            System.out.print("Preço: " + getSetorProduto().getRoupas().get(i).getPreco() + " | ");
        }
        System.out.println("");
    }
    
    public void buscarRoupas() {
        System.out.println("Digite o nome da roupa: ");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine().toLowerCase();  
           
        List<Roupa> roupas = getSetorProduto().getRoupas().stream().filter(f -> f.getNome().toLowerCase().contains(nome)).collect(Collectors.toList());
        
        System.out.println("\nRoupas localizadas: ");
         
        for(int i = 0;i < roupas.size();i++) {
            System.out.print("\n|" + (i+1) + "| ");
            System.out.print("ID: " + roupas.get(i).getId() + " | ");
            System.out.print("Código de barras: " + roupas.get(i).getCodigoBarras() + " | ");
            System.out.print("Nome: " + roupas.get(i).getNome() + " | ");
            System.out.print("Marca: " + roupas.get(i).getMarca() + " | ");
            System.out.print("Cor: " + roupas.get(i).getCor() + " | ");
            System.out.print("Tamanho: " + roupas.get(i).getTamanho() + " | ");
            System.out.print("Tipo de tecido: " + roupas.get(i).getTipoTecido() + " | ");
            System.out.print("Quantidade: " + roupas.get(i).getQuantidade() + " | ");
            System.out.print("Preço: " + roupas.get(i).getPreco() + " | ");
        }
        System.out.println("");
    }
    
    public void editarRoupa() {
        System.out.println("Digite o código de barras da roupa que deseja editar: ");
        Scanner input = new Scanner(System.in);
        String nome, marca, cor, tamanho, tecidoTipo, preco;
        int numSelecionado, buscaCodigoBarras = input.nextInt(), quantidade, codigoBarras;
        
        for(int i = 0;i < getSetorProduto().getRoupas().size();i++) {
            nome = getSetorProduto().getRoupas().get(i).getNome();
            marca = getSetorProduto().getRoupas().get(i).getMarca();
            cor = getSetorProduto().getRoupas().get(i).getCor();
            tamanho = getSetorProduto().getRoupas().get(i).getTamanho();
            tecidoTipo = getSetorProduto().getRoupas().get(i).getTipoTecido();
            quantidade = getSetorProduto().getRoupas().get(i).getQuantidade();
            codigoBarras = getSetorProduto().getRoupas().get(i).getCodigoBarras();
            preco = getSetorProduto().getRoupas().get(i).getPreco();
            
            if(getSetorProduto().getRoupas().get(i).getCodigoBarras() == buscaCodigoBarras) {
                System.out.println("Digite o número do que você deseja editar na roupa: ");
                System.out.println("1 - Editar Código de Barras");
                System.out.println("2 - Editar Nome");
                System.out.println("3 - Editar Marca");
                System.out.println("4 - Editar Cor");
                System.out.println("5 - Editar Tamanho");
                System.out.println("6 - Editar Tipo de Tecido");
                System.out.println("7 - Editar Preço");
                System.out.println("8 - Editar Quantidade");
                System.out.println("9 - Voltar");
                System.out.print("\nDigite aqui: ");
                numSelecionado = input.nextInt();
                nome = input.nextLine();
                
                switch(numSelecionado) {
                    case 1: 
                        System.out.println("Digite o novo código de barras da roupa: ");
                        codigoBarras = input.nextInt();
                        nome = input.nextLine();
                        break;
                    case 2:
                        System.out.println("Digite o novo nome da roupa: ");
                        nome = input.nextLine();
                        break;
                    case 3: 
                        System.out.println("Digite a nova marca da roupa: ");
                        marca = input.nextLine();
                        break;
                    case 4: 
                        System.out.println("Digite a nova cor da roupa: ");
                        cor = input.nextLine();
                        break;
                    case 5:
                        System.out.println("Digite o novo tamanho da roupa: ");
                        tamanho = input.nextLine();
                        break;
                    case 6:
                        System.out.println("Digite o novo tipo de tecido da roupa: ");
                        tipoTecido = input.nextLine();
                        break;
                    case 7:
                        System.out.println("Digite o novo preço da roupa: ");
                        preco = input.nextLine();
                        break;
                    case 8:
                        System.out.println("Digite a nova quantidade da roupa: ");
                        quantidade = input.nextInt();
                        break;
                    default: 
                       // Principal.setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                       // Principal.carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                        break;
                }
                
                if(numSelecionado < 9) {
                    System.out.println("Tem certeza que deseja aplicar a edição? \nDigite \"S\" ou \"N\": ");
                    String opcaoEscolhida = input.nextLine().toUpperCase();

                    if(opcaoEscolhida.equals("S") || opcaoEscolhida.equals("SIM")) {
                        getSetorProduto().getRoupas().set(i, new Roupa(codigoBarras, preco, quantidade, tamanho, cor, nome, tecidoTipo, marca));
                        System.out.println("Roupa editada com sucesso.");
                    } else {
                        System.out.println("A roupa não foi editada.");
                    }
                }
            }
        }
    }
    
    public void removerRoupa() {
        System.out.println("Digite o código de barras da roupa que deseja remover: ");
        Scanner input = new Scanner(System.in);
        int codigoBarras = input.nextInt(), contador = 0;
        
        for(int i = 0;i < getSetorProduto().getRoupas().size();i++) {
            if(getSetorProduto().getRoupas().get(i).getCodigoBarras() == codigoBarras) {
                System.out.println("Tem certeza que deseja remover? \nDigite \"S\" ou \"N\": ");
                String resolveErroScanner = input.nextLine(), opcaoEscolhida = input.nextLine().toUpperCase();
                
                if(opcaoEscolhida.equals("S") || opcaoEscolhida.equals("SIM")) {
                    getSetorProduto().getRoupas().remove(i);
                    System.out.println("Roupa removida com sucesso.");
                } else {
                    System.out.println("A roupa não foi removida.");
                }
            } else if(getSetorProduto().getRoupas().size() == contador) {
                System.out.println("Roupa não encontrada.");
            } contador++;
        }
    }
    
    public void autoCadastroRoupas() {
        Random aleatorio = new Random();        
        getSetorProduto().getRoupas().add(new Roupa(aleatorio.nextInt(10000), "45,79", aleatorio.nextInt(1000), "M", "Vermelho", "Camisa", "Pano", "Puma"));
        getSetorProduto().getRoupas().add(new Roupa(aleatorio.nextInt(10000), "104,99", aleatorio.nextInt(1000), "P", "Verde", "Chapeu", "Pano", "Shein"));
        getSetorProduto().getRoupas().add(new Roupa(aleatorio.nextInt(10000), "431,29", aleatorio.nextInt(1000), "G", "Branco", "Blazer", "Veludo", "Nautico"));
        getSetorProduto().getRoupas().add(new Roupa(aleatorio.nextInt(10000), "60,99", aleatorio.nextInt(1000), "GG", "Preto", "Gravata", "Linho", "Ktny"));
        getSetorProduto().getRoupas().add(new Roupa(aleatorio.nextInt(10000), "350,79", aleatorio.nextInt(1000), "P", "Cinza", "Calca", "Algodão", "Shein"));
        getSetorProduto().getRoupas().add(new Roupa(aleatorio.nextInt(10000), "75,79", aleatorio.nextInt(1000), "M", "Azul", "Camisa", "Pano", "Puma"));
        getSetorProduto().getRoupas().add(new Roupa(aleatorio.nextInt(10000), "23,09", aleatorio.nextInt(1000), "38", "Preto", "Sapato", "Couro", "Nike"));       
        Collections.sort(getSetorProduto().getRoupas(), new Roupa());
    }
    
    @Override
    public int compare(Roupa roupa1, Roupa roupa2) {
        if(roupa1.getNome().toLowerCase().compareTo(roupa2.getNome().toLowerCase()) > 0) {
            return 0;
        }
        return -1;
    }

    public String getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }
}
