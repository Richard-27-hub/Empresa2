package empresa;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException {
       //Abertura do Scanner
    	Scanner sc = new Scanner(System.in);
    	//Função de Funcionário e Projeto
    	Funcionario func = new Funcionario();
    	 Projeto proj = new Projeto();
       //Variável
    	boolean sair = false;
    	
    	//Menu para entrada de Dados
        while (!sair) {
            System.out.println("");
        	System.out.println("******** MENU ********");
            System.out.println("");
            System.out.println("1 - INCLUIR");
            System.out.println("2 - ALTERAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - LISTAR");
            System.out.println("5 - INCLUIR PROJETO");
            System.out.println("6 - ALTERAR PROJETO");
            System.out.println("7 - EXCLUIR PROJETO");
            System.out.println("8 - LISTAR PROJETO");
            System.out.println("0 - SAIR");
            System.out.println("");
            System.out.print("ESCOLHA UMA OPÇÃO: ");

            int opcao = sc.nextInt();
            sc.nextLine();  // consumir o ENTER
            //switch para cada opção do menu
            switch (opcao) {
            //Inclusão   
            case 1:
                    System.out.print("NOME: ");
                    func.setNome(sc.nextLine());

                    System.out.print("E-MAIL: ");
                    func.setEmail(sc.nextLine());

                    System.out.print("MATRÍCULA: ");
                    func.setMatricula(sc.nextLine());

                    System.out.print("DEPARTAMENTO: ");
                    func.setDepartamento(sc.nextLine());

                    if (func.incluirFuncionario()) {
                        System.out.println("Funcionário incluído com sucesso!");
                        System.out.println("");
                    } else {
                        System.err.println("Erro ao incluir funcionário.");
                        System.out.println("");
                    }
                    break;
                //Alterar
                case 2:
                    System.out.print("ID do funcionário para alterar: ");
                    func.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Novo NOME: ");
                    func.setNome(sc.nextLine());

                    System.out.print("Novo E-MAIL: ");
                    func.setEmail(sc.nextLine());

                    System.out.print("Nova MATRÍCULA: ");
                    func.setMatricula(sc.nextLine());

                    System.out.print("Novo DEPARTAMENTO: ");
                    func.setDepartamento(sc.nextLine());

                    if (func.alterarFuncionario()) {
                        System.out.println("Funcionário alterado com sucesso!");
                        System.out.println("");
                    } else {
                        System.err.println("Erro ao alterar funcionário.");
                        System.out.println("");
                    }
                    break;
                
                //Exclusão
                case 3:
                    System.out.print("ID do funcionário para excluir: ");
                    func.setId(sc.nextInt());
                    sc.nextLine();

                    if (func.excluirFuncionario()) {
                        System.out.println("Funcionário excluído com sucesso!");
                        System.out.println("");
                    } else {
                        System.err.println("Erro ao excluir funcionário.");
                        System.out.println("");
                    }
                    break;
                    
                //Listagem
                case 4:
                    func.listarFuncionario();
                    break;
                
                //Inclusão Projeto
                case 5:
                    System.out.print("NOME PROJETO: ");
                    proj.setNome(sc.nextLine());

                    System.out.print("DESCRIÇÃO PROJETO: ");
                    proj.setDescricao(sc.nextLine());

                    System.out.print("ID do funcionário responsável: ");
                    proj.setIdFuncionario(sc.nextInt());
                    sc.nextLine(); 

                    if (incluirProjeto(proj)) {
                        System.out.println("Projeto cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar projeto.");
                    }
                    break;
               //Alterar Projeto
                case 6:
                	System.out.print("ID do projeto que deseja alterar: ");
                    proj.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    proj.setNome(sc.nextLine());

                    System.out.print("Nova descrição: ");
                    proj.setDescricao(sc.nextLine());

                    System.out.print("Novo ID do funcionário responsável: ");
                    proj.setIdFuncionario(sc.nextInt());
                    sc.nextLine();

                    if (alterarProjeto(proj)) {
                        System.out.println("Projeto alterado com sucesso!");
                    } else {
                        System.out.println("Erro ao alterar projeto.");
                    }
                    break;
                    
                //Exclusão do Projeto
                case 7: 
                	 System.out.print("ID do projeto que deseja excluir: ");
                	    int idExcluir = sc.nextInt();
                	    sc.nextLine();

                	    if (excluirProjeto(idExcluir)) {
                	        System.out.println("Projeto excluído com sucesso!");
                	    } else {
                	        System.out.println("Erro ao excluir projeto.");
                	    }
                	    break;
               
                //Listagem dos Projetos
                case 8:
                proj.listarProjetos();
                    
                //Encerramento do Programa
                case 0:
                    sair = true;
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.err.println("Opção inválida! Tente novamente.");
            }
        }

        sc.close();
    }

	private static boolean excluirProjeto(int idExcluir) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean alterarProjeto(Projeto proj) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean incluirProjeto(Projeto proj) {
		// TODO Auto-generated method stub
		return false;
	}
}
