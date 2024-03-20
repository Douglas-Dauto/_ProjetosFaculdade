package com.mycompany.projetoa3lojaderoupassociais;

import java.util.Scanner;

public class Principal {
    private static EnumPassoMenu menuAnteriorSelecionado; // Armazena o menu de onde o usuário acessou o submenu de produtos
    private static int opcaoSelecionada = 0;
    private static Administrador adm = new Administrador();
    private static Funcionario func = new Funcionario();
    private static Roupa roupa = new Roupa();
    private static Acessorio acessorio = new Acessorio();
    private static VendaProduto vendaProdutos = new VendaProduto();
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        adm.autoCadastroAdministradores(); // Instância 3 objetos admnistrador
        func.autoCadastroFuncionarios(); // Instância 7 objetos funcionario
        roupa.autoCadastroRoupas(); // Instância 7 objetos roupa
        acessorio.autoCadastroAcessorios(); // Instância 7 objetos acessorio
        carregarMenu(EnumPassoMenu.PASSO_INICIAL); // Carrega o menu com o parâmetro do tipo enum no valor PASSO_INICIAL para mostrar a primeira interface
    }
    
    public static void verificarPassoInicialSelecionado(){
        switch (getOpcaoSelecionada()) { // Verifica qual valor é opcaoSelecionada
            case 1:
                carregarMenu(EnumPassoMenu.PASSO_ADMINISTRADOR);
                break;
            case 2:
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_INICIAL);
                carregarMenu(EnumPassoMenu.PASSO_SUBMENU_PROD);
                break;
            default:
                System.out.println("Saindo do programa...");
                System.exit(0); // Fecha o programa
        }
    }
    
    public static void verificarPassoAdministradorSelecionado(){
        switch(getOpcaoSelecionada()) {
            case 1:
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                break;
            case 2:                 
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                carregarMenu(EnumPassoMenu.PASSO_SUBMENU_PROD);
                break;
            default: 
                carregarMenu(EnumPassoMenu.PASSO_INICIAL);
                break;
        }
    }
    
    public static void verificarPassoFuncSelecionado(){
        switch(getOpcaoSelecionada()) {
                case 1:
                    func.cadastrarFuncionario(); // Executa o método de cadastro e logo em seguida carrega o menu com o paramêtro do tipo enum com o valor PASSO_ADMINISTRADOR para recarregar o mesmo menu
                    carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                    break;
                case 2: 
                    func.buscarFuncionarios();
                    carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                    break;
                case 3: 
                    func.listarFuncionarios();
                    carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                    break;
                case 4: 
                    func.editarFuncionario();
                    carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                    break;
                case 5: 
                    func.removerFuncionario();
                    carregarMenu(EnumPassoMenu.PASSO_SUBMENU_FUNC);
                    break;
                default:
                    carregarMenu(getMenuAnteriorSelecionado());
                    break;
            }
    }
    
    public static void verificarPassoProdSelecionado(){
        switch(getOpcaoSelecionada()) {
                case 1: 
                    setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_SUBMENU_PROD);
                    carregarMenu(EnumPassoMenu.PASSO_VENDER_PRODUTO);
                    break;
                case 2:
                    setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_SUBMENU_PROD);
                    carregarMenu(EnumPassoMenu.PASSO_CADASTRAR_PRODUTO);
                    break;
                case 3: 
                    setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_SUBMENU_PROD);
                    carregarMenu(EnumPassoMenu.PASSO_BUSCAR_PRODUTO);
                    break;
                case 4: 
                    setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_SUBMENU_PROD);
                    carregarMenu(EnumPassoMenu.PASSO_LISTAR_PRODUTO);
                    break;
                case 5: 
                    setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_SUBMENU_PROD);
                    carregarMenu(EnumPassoMenu.PASSO_EDITAR_PRODUTO);
                    break;
                case 6: 
                    setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_SUBMENU_PROD);
                    carregarMenu(EnumPassoMenu.PASSO_REMOVER_PRODUTO);
                    break;
                case 7: 
                    setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_SUBMENU_PROD);
                    carregarMenu(EnumPassoMenu.PASSO_EXIBIR_REGISTRO_VENDA_PRODUTO);
                    break;
                default:
                    carregarMenu(EnumPassoMenu.PASSO_INICIAL);
                    break;
            }
    }
    
    public static void verificarPassoVenderProdutoSelecionado() {
        switch(getOpcaoSelecionada()) {
            case 1:
                roupa.venderRoupas();
                carregarMenu(EnumPassoMenu.PASSO_VENDER_PRODUTO);
                break;
            case 2:
                acessorio.venderAcessorios();
                carregarMenu(EnumPassoMenu.PASSO_VENDER_PRODUTO);
                break;
            default:
                carregarMenu(getMenuAnteriorSelecionado()); // Carrega o menu de onde o usuário veio
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                break;
        }
    }
    
    public static void verificarPassoCadastrarProdutoSelecionado(){
        switch(getOpcaoSelecionada()) {
            case 1:
                roupa.cadastrarRoupas();
                carregarMenu(EnumPassoMenu.PASSO_CADASTRAR_PRODUTO);
                break;
            case 2:
                acessorio.cadastrarAcessorios();
                carregarMenu(EnumPassoMenu.PASSO_CADASTRAR_PRODUTO);
                break;
            default:
                carregarMenu(getMenuAnteriorSelecionado()); 
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                break;
        }    
    }
    
    public static void verificarPassoBuscarProdutoSelecionado(){
        switch(getOpcaoSelecionada()) {
            case 1:
                roupa.buscarRoupas();
                carregarMenu(EnumPassoMenu.PASSO_BUSCAR_PRODUTO);
                break;
            case 2:
                acessorio.buscarAcessorios();
                carregarMenu(EnumPassoMenu.PASSO_BUSCAR_PRODUTO);
                break;
            default:
                carregarMenu(getMenuAnteriorSelecionado());
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                break;
        }
    }
    
    public static void verificarPassoListarProdutoSelecionado(){
        switch(getOpcaoSelecionada()) {
            case 1:
                roupa.listarRoupas();
                carregarMenu(EnumPassoMenu.PASSO_LISTAR_PRODUTO);
                break;
            case 2:
                acessorio.listarAcessorios();
                carregarMenu(EnumPassoMenu.PASSO_LISTAR_PRODUTO);
                break;
            default:
                carregarMenu(getMenuAnteriorSelecionado());
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                break;
        }
    }
    
    public static void verificarPassoEditarProdutoSelecionado() {
        switch(getOpcaoSelecionada()) {
            case 1:
                roupa.editarRoupa();
                carregarMenu(EnumPassoMenu.PASSO_EDITAR_PRODUTO);
                break;
            case 2:
                acessorio.editarAcessorio();
                carregarMenu(EnumPassoMenu.PASSO_EDITAR_PRODUTO);
                break;
            default:
                carregarMenu(getMenuAnteriorSelecionado());
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                break;
        }
    }
    
    public static void verificarPassoRemoverProdutoSelecionado() {
        switch(getOpcaoSelecionada()) {
            case 1:
                roupa.removerRoupa();
                carregarMenu(EnumPassoMenu.PASSO_REMOVER_PRODUTO);
                break;
            case 2:
                acessorio.removerAcessorio();
                carregarMenu(EnumPassoMenu.PASSO_REMOVER_PRODUTO);
                break;
            default:
                carregarMenu(getMenuAnteriorSelecionado());
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                break;
        }
    }
    
    public static void verificarPassoExibirRegistroVendaProdutoSelecionado() {
        switch(getOpcaoSelecionada()) {
            default:
                carregarMenu(getMenuAnteriorSelecionado());
                setMenuAnteriorSelecionado(EnumPassoMenu.PASSO_ADMINISTRADOR);
                break;
        }
    }
          
    public static void carregarMenu(EnumPassoMenu passoMenuSelecionado) { // O parâmetro é do tipo enum e é usado logo abaixo no switch para saber em quam menu entrar
        System.out.println("\n__________ MENU ___________");
        System.out.println("Selecione a opção desejada:\n");
        
        switch(passoMenuSelecionado) { // passoMenuSelecionado é do tipo enum e assume somente os valores dos cases abaixo, o valor que passoMenuSelecionado assumirá depende do parâmetro passado no método carregarMenu()
            case PASSO_INICIAL: {  // Tela inicial do menu
                System.out.println("1 - Sou Administrador");
                System.out.println("2 - Sou Funcionário");
                System.out.println("3 - Sair");
                System.out.print("\nDigite aqui: ");      
                setOpcaoSelecionada(input.nextInt()); // Variável que armazena o número digitado pelo usuário
                verificarPassoInicialSelecionado(); // Após armazenado o número digitado, é chamado um método que irá conter um switch(opcaoSelecionada) que verificará qual o valor de opcaoSelecionada e executará um dos cases, nos cases terá o método carregarMenu() e será passado outro valor do enum como parâmetro, esse valor alterado fará com que o menu que carregue sejá o desejado
                break;
            }
            case PASSO_ADMINISTRADOR: {
                System.out.println("1 - Gerenciar Funcionários");
                System.out.println("2 - Gerenciar Produtos");
                System.out.println("3 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoAdministradorSelecionado();
                break;
            }
            case PASSO_SUBMENU_FUNC: { // Seção do menu de administrador
                System.out.println("1 - Cadastrar Funcionários");
                System.out.println("2 - Buscar Funcionários");
                System.out.println("3 - Listar Funcionários");
                System.out.println("4 - Editar Funcionários");
                System.out.println("5 - Remover Funcionários");
                System.out.println("6 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoFuncSelecionado();
                break;
            }
            case PASSO_SUBMENU_PROD: { // Seção do menu de administrador e funcionário
                System.out.println("1 - Vender Produtos");
                System.out.println("2 - Cadastrar Produtos");
                System.out.println("3 - Buscar Produtos");
                System.out.println("4 - Listar Produtos");
                System.out.println("5 - Editar Produtos");
                System.out.println("6 - Remover Produtos");
                System.out.println("7 - Exibir Registro de Venda de Produtos");
                System.out.println("8 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoProdSelecionado();
                break;
            }
            case PASSO_VENDER_PRODUTO: { // Seção de vendas de produtos
                System.out.println("1 - Vender Roupas");
                System.out.println("2 - Vender Acessorios");
                System.out.println("3 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoVenderProdutoSelecionado();
                break;
            }
            case PASSO_CADASTRAR_PRODUTO: { // Seção de cadastro de produto
                System.out.println("1 - Cadastrar Roupas");
                System.out.println("2 - Cadastrar Acessorios");
                System.out.println("3 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoCadastrarProdutoSelecionado();
                break;
            }
            case PASSO_BUSCAR_PRODUTO: { // Seção de busca de produto
                System.out.println("1 - Buscar Roupas");
                System.out.println("2 - Buscar Acessorios");
                System.out.println("3 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoBuscarProdutoSelecionado();
                break;
            }
            case PASSO_LISTAR_PRODUTO: { //Seção de listagem de produto
                System.out.println("1 - Listar Roupas");
                System.out.println("2 - Listar Acessorios");
                System.out.println("3 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoListarProdutoSelecionado();
                break;
            }
            case PASSO_EDITAR_PRODUTO: { //Seção de edição de produto
                System.out.println("1 - Editar Roupas");
                System.out.println("2 - Editar Acessorios");
                System.out.println("3 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoEditarProdutoSelecionado();
                break;
            }
            case PASSO_REMOVER_PRODUTO: { //Seção de remoção de produto
                System.out.println("1 - Remover Roupas");
                System.out.println("2 - Remover Acessorios");
                System.out.println("3 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoRemoverProdutoSelecionado();
                break;
            }
            case PASSO_EXIBIR_REGISTRO_VENDA_PRODUTO: { //Seção de registro de venda de produto
                vendaProdutos.exibirRegistroVendaProdutos();
                System.out.println("1 - Voltar");
                System.out.print("\nDigite aqui: ");
                setOpcaoSelecionada(input.nextInt());
                verificarPassoExibirRegistroVendaProdutoSelecionado();
                break;
            }
        }
    }

    public static EnumPassoMenu getMenuAnteriorSelecionado() {
        return menuAnteriorSelecionado;
    }

    public static void setMenuAnteriorSelecionado(EnumPassoMenu menuAnteriorSelecionado) {
        Principal.menuAnteriorSelecionado = menuAnteriorSelecionado;
    }

    public static int getOpcaoSelecionada() {
        return opcaoSelecionada;
    }

    public static void setOpcaoSelecionada(int opcaoSelecionada) {
        Principal.opcaoSelecionada = opcaoSelecionada;
    }
}
