package acervo;

import java.util.Scanner;

public class Nucleo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		Biblioteca libre = new Biblioteca (); 
		Cliente client = new Cliente ();
		System.out.println("Seja bem vindo a livraria IZVOC");
		
		
		System.out.println("Temos um dos maiores acervos do mundo com as mais ricas e raras obras literarias de diversas regiões e localidades");
		
		System.out.println("\n Pra personalizarmos seu acesso");
		System.out.println("\n Por gentileza ");
		System.out.println("Digite a opção desejada: ");
		
		System.out.println("Digite 1 para fazer login");
		System.out.println("Digite 2 para sair");
		String option = sc.nextLine();
        while (!option.equals("1") && !option.equals("2")) {
			
			System.out.println("Opção incorreta! Digite novamente!");
            option = sc.nextLine();

		} 
        if (option.equals("1")) {
            System.out.println("Bem-vindo! Vamos fazer o login.");
            System.out.println("Agora digite as seguintes opções: ");
            
            System.out.println("Se for seu primeiro acesso. Digite 1 :");
            System.out.println("Se já for usuário. Digite 2 :");
            System.out.println("Se quiser sair. Digite 3 :");
            System.out.println("Se for ADMIN. Digite 0 :");


            String caso = sc.nextLine();  // Lê a entrada como String

            switch (caso) {
                case "1":
                    System.out.println("Vou precisar de alguns dados para te cadastrar");
                    libre.novoCliente();
                    libre.imprimirClientes();
              	  System.out.println("Agora já pode logar normalmente e consultar nossos livros");
                  System.exit(1);


                    break;
                case "2":
                    System.out.println("Digite seu nome:");
                    String nome = sc.nextLine();
                    System.out.println(nome);
                    System.out.println("Gostaria de ver os nossos livros?");
                    String quero = sc.nextLine();
                    if (quero.equalsIgnoreCase("Sim") && quero.equalsIgnoreCase("sim")) {
                    	
                    	System.out.println("Vou te apresentar as obras disponíveis");
                    	libre.myLivros();
                    	libre.printLivros();
                    	
                    	System.out.println(  nome + "\n Gostaria de emprestar alguma?");
                        String emp = sc.nextLine();

                    	if (emp.equalsIgnoreCase("Sim") && emp.equalsIgnoreCase("sim")) {
                    		System.out.println("Vamos lá");
                    		libre.Emprestar();
                    		
                    		
                    	}
                    	

                    } 
                    
                    
                    
                    
                    else {
                    		System.out.println("Como não escolheu nenhuma das opções:");
                    	 System.out.println("Até mais");
                         System.exit(1);
                    	
                    }
                    break;
                case "3":
                	  System.out.println("Até mais");
                      System.exit(1);
                    break;
                case "0":
                    System.out.println("Olá gestor seja bem vindo ao nosso sistema!");
                    System.out.println("\n para maior seguraça vamos validar seu acesso ok?");
                    System.out.println("Digite seu id de controle");
     			   
                    System.out.println("Bibliotecário");
					System.out.println("Digite seu id de controle");

					String key;
					boolean autenticado = false;

					for (int i = 0; i < 3; i++) { // 3 tentativas
						key = sc.nextLine();

						if (key.trim().equals(client.getKey().trim())) {
							autenticado = true;
							break;
						} else {
							System.out.println("Senha incorreta! Tentativas restantes: " + (2 - i));
						}
					}

					if (autenticado) {
						System.out.println("Vamos lá vou te apresentar as opções disponíveis");
						System.out.println("Deseja inserir um novo usuario?" + "Digite: 1");
						System.out.println("Deseja inserir uma nova obra?" + "Digite: 2");
						System.out.println("Deseja sair do sistema de gerenciamento?" + "Digite: 3");

						int options = sc.nextInt();
						sc.nextLine();

						switch (options) {
							case 1:
								libre.novoCliente();
								System.out.println("Cadastro feito com sucesso!>> ");
								libre.imprimirClientes();
								break;
							case 2:
								System.out.println("Falando em autores, vamos cadastrar ok?");
								libre.Addwiriters();
								libre.writer();
								libre.printWriters();
								break;
							case 3:
								System.out.println("Finalizando aqui!!" + "Até a próxima!");
								System.exit(0);
							default:
								System.out.println("opção inválida");
								break;
						}
					} else {
						System.out.println("Você errou 3 vezes.!");
						  System.out.println("Tchau!!");
	                      System.exit(1);
					}
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            	
            
        } else {
            System.out.println("Encerrando... Tchau!");
        }
		
		

		
		
		
		

			
		
		
		
		
	
       
        
        
		sc.close();
		
		
		
		
		
		
		
		
		
	}

}