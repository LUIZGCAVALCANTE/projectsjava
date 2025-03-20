package acervo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Biblioteca {

	LocalDateTime  sdata =  LocalDateTime.now();
    DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Map<Integer, String> livros = new HashMap<>();
	private List<Emprestimo> emprestimos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	private Map<Integer, Autor> writer = new HashMap<>();
	

	private Scanner scanner = new Scanner (System.in);
	// gerenciamento de emprestimos //
	public void Emprestar() {
	    System.out.println("Digite seu nome de usuário:");
	    String nomeCliente = scanner.nextLine();

	    Cliente clienteTrue = null;
	    for (Cliente cliente : clientes) {
	        if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
	            clienteTrue = cliente;
	            break;
	        }
	    }

	    if (clienteTrue == null) {
	        System.out.println("Cliente não encontrado. Deseja se cadastrar? (S/N)");
	        String resposta = scanner.nextLine();
	        if (resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s")) {
	            novoCliente();  
	            Emprestar();  
	            return;
	        } else {
	            System.out.println("Até mais!");
	            return;
	        }
	    }

	    System.out.println("Seja bem-vindo, " + clienteTrue.getNome());
	    System.out.println("Digite agora o nome do livro que você deseja: ");
	    String livroUser = scanner.nextLine();

	    Integer livroId = null;
	    String livroNome = null;

	    for (Map.Entry<Integer, String> entry : livros.entrySet()) {
	        if (entry.getValue().equalsIgnoreCase(livroUser)) {
	            livroId = entry.getKey();
	            livroNome = entry.getValue();
	            break;
	        }
	    }

	    if (livroNome != null) {
	        System.out.println("Livro encontrado: " + livroNome);
	    } else {
	        // Aqui caso o livro não seja encontrado, mostrar lista e permitir seleção pela ID
	        System.out.println("Livro não encontrado.");
	        System.out.println("Livros disponíveis:");

	        // Mostrar a lista de livros com seus IDs
	        for (Map.Entry<Integer, String> entry : livros.entrySet()) {
	            System.out.println("ID: " + entry.getKey() + " - " + entry.getValue());
	        }

	        System.out.println("Digite o ID do livro que você deseja emprestar:");
	        try {
	            int idEscolhido = Integer.parseInt(scanner.nextLine());

	            if (livros.containsKey(idEscolhido)) {
	                livroNome = livros.get(idEscolhido);
	                livroId = idEscolhido;
	                System.out.println("Você escolheu: " + livroNome);
	            } else {
	                System.out.println("ID inválido. Empréstimo não realizado.");
	                return;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Entrada inválida. Tente novamente.");
	            return;
	        }
	    }

	    Emprestimo novoEmprestimo = new Emprestimo(clienteTrue, livroNome, LocalDate.now());
	    emprestimos.add(novoEmprestimo);
	    livros.put(livroId, clienteTrue.getNome());

	    LocalDate dataDevolucao = LocalDate.now().plusDays(14);
	    System.out.println("\nEmpréstimo registrado com sucesso!");
	    System.out.println("Cliente: " + clienteTrue.getNome());
	    System.out.println("Livro: " + livroNome);
	    System.out.println("Data do Empréstimo: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	    System.out.println("Data de Devolução: " + dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	// gerenciamento de clientes//

	public void novoCliente (){
		
		System.out.println("Vou iniciar seu cadastro ok?");
		
		int inter = 1;
		
		for (int i = 0; i <  inter; i ++) {
			 System.out.println("Vou precisar de alguns dados ok?");
			 
			 System.out.println("Me informe seu nome completo");
			 
			 String nome  = scanner.nextLine();
			 System.out.println("Me informe seu CPF");
			 String CPF = scanner.nextLine();
			 System.out.println("Me informe seu telefone");
			 String telefone = scanner.nextLine();
			 	 
			 Cliente novoCliente = new Cliente ();
			 
			   novoCliente.setNome(nome);
               novoCliente.setCPF(CPF);
               novoCliente.setTelefone(telefone);
               
               clientes.add(novoCliente);
			 
		}
	}
	
	public void imprimirClientes() {
	    if (clientes.isEmpty()) {
	        System.out.println("Nenhum cliente cadastrado.");
	    } else {
	        System.out.println("Clientes cadastrados:");
	        for (Cliente cliente : clientes) {
	            System.out.println(cliente); 
	            System.out.println("-------------------------------------");
	        }
	    }
	}

	public List<Cliente> ListarUsers(){
		
		return clientes;
		
	}
	
	public void adicionarUser(Cliente cliente) {
		
	clientes.add(cliente);
		
		
	}
	
	public void removeUser(Cliente cliente) {
		
	clientes.remove(cliente);
		
		
	}
	
	public List<Cliente> getClientes() {
		return clientes; 
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	} 
	
	public void users() {
		
		
		
	}
	
	
	//------------------------------------//
	//------- gerenciamento de autores ------// 
	public void Addwiriters (){
		System.out.println("Digite um id para o autor  a partir de 12");
		int identificador = scanner.nextInt();
		scanner.nextLine();
		
		if (writer.containsKey(identificador)) {
			
			System.out.println("ID já em uso escolha outro");
			return;
			
		}else if (identificador <= 12) {
		
		System.out.println("ID deve ser maior que 11 digite outro!");
		return;

		}
		
		
		System.out.println("Digite o nome do Autor");
		String name = scanner.nextLine();
		
		System.out.println("Digite a data de nascimento");
		String input = scanner.nextLine();
		LocalDate sdata = LocalDate.parse(input, form);
		
		System.out.println("Digite o nome da obra");
		
		String obra = scanner.nextLine();
		
		writer.put(identificador, new Autor(identificador, name, sdata,obra ));
		System.out.println("Autor cadastrado!");
	}

	
    public void writer() {
        writer.put(1, new Autor(1, "J. K. Rowling", LocalDate.of(1965, 7, 31), "Escritora da saga Harry Potter"));
        writer.put(2, new Autor(2, "Michael T. Goodrich, Roberto Tamassia", 
                                LocalDate.of(1958, 3, 12), 
                                "JAVA COMPLETO - ALGORITMOS - MACHINE LEARNING\nEstruturas de Dados e Algoritmos em Java"));
        writer.put(3, new Autor(3, "Robert C. Martin", LocalDate.of(1952, 12, 5), "Clean Code: Habilidades Práticas do Agile Software"));
        writer.put(4, new Autor(4, "Erich Gamma, Richard Helm, Ralph Johnson", 
                                LocalDate.of(1961, 3, 13), 
                                "Padrões de Projeto: Elementos Reutilizáveis de Software Orientado a Objetos"));
        writer.put(5, new Autor(5, "Paul Deitel & Harvey Deitel", LocalDate.of(1959, 4, 22), "Java: Como Programar - Deitel & Deitel"));
        writer.put(6, new Autor(6, "Paulo Fagundes", LocalDate.of(1975, 8, 30), "Introdução à Inteligência Artificial com Python"));
        writer.put(7, new Autor(7, "François Chollet", LocalDate.of(1985, 9, 16), "Deep Learning com Python"));
        writer.put(8, new Autor(8, "Aurélien Géron", LocalDate.of(1978, 5, 20), "Machine Learning com Scikit-Learn, Keras e TensorFlow"));
        writer.put(9, new Autor(9, "Bob Martin", LocalDate.of(1952, 4, 5), "O Codificador Limpo: Um Código de Conduta para Programadores Profissionais"));
        writer.put(10, new Autor(10, "Kathy Sierra", LocalDate.of(1957, 1, 20), "Head First Java: Uma Abordagem Divertida e Visual para Aprender Java"));
        writer.put(11, new Autor(11, "Loiane Groner", LocalDate.of(1980, 11, 5), "Estruturas de Dados e Algoritmos com JavaScript"));
    }
	public void printWriters() {
	    for (Map.Entry<Integer, Autor> entry : writer.entrySet()) {
	        System.out.println("ID: " + entry.getKey() + " - " + entry.getValue());
	    }
	}

		

	
	
	// gerenciamento dos livros//	
	
	public void myLivros() {
			
		  	livros.put(1, "Harry Potter e o Cálice de Fogo");
		    livros.put(2, "Harry Potter e a Ordem da Fênix");
		    livros.put(3, "Harry Potter e o Enigma do Príncipe");
		    livros.put(4, "Harry Potter e as Relíquias da Morte");
		    livros.put(5, "Harry Potter e a Criança Amaldiçoada (Bônus)");
		    livros.put(6, "JAVA COMPLETO - ALGORITMOS - MACHINE LEARNING");
		    livros.put(7, "Estruturas de Dados e Algoritmos em Java");
		    livros.put(8, "Clean Code: Habilidades Práticas do Agile Software");
		    livros.put(9, "Padrões de Projeto: Elementos Reutilizáveis de Software Orientado a Objetos");
		    livros.put(10, "Java: Como Programar - Deitel & Deitel");
		    livros.put(11, "Introdução à Inteligência Artificial com Python");
		    livros.put(12, "Deep Learning com Python - François Chollet");
		    livros.put(13, "Machine Learning com Scikit-Learn, Keras e TensorFlow");
		    livros.put(14, "O Codificador Limpo: Um Código de Conduta para Programadores Profissionais");
		    livros.put(15, "Head First Java: Uma Abordagem Divertida e Visual para Aprender Java");
		    livros.put(16, "Estruturas de Dados e Algoritmos com JavaScript");

	}
	 
	
	public void addLivros () {
		
		System.out.println("Digite um id pro Livro a partir de 17");
		
		int id = scanner.nextInt();
		scanner.nextLine();

		
		if (livros.containsKey(id)) {
            System.out.println("Esse ID já está em uso! Tente outro.");
            return;
        }else if (id <= 16) {
            System.out.println("O ID deve ser maior que 16.");
            return;
        }
        System.out.println("Digite o nome do livro:");
        String nome = scanner.nextLine();
		
        livros.put(id, nome);
        
        System.out.println("Livro adicionado com sucesso!");
        
        System.out.println("Lista de livros atualizada: ");
        printLivros();
	}
	
	

	
	
	public void printLivros() {
	    if (livros.isEmpty()) {
	        System.out.println("Nenhum livro cadastrado.");
	    } else {
	        System.out.println("Livros cadastrados:");
	        for (Map.Entry<Integer, String> entry : livros.entrySet()) {
	            System.out.println("ID: " + entry.getKey() + " - " + entry.getValue());
	        }
	    }
	}

	
	
	
	
	
	
	public Map<Integer, String> getLivros() {
		return livros;
	}

	public void setLivros(Map<Integer, String> livros) {
		this.livros = livros;
	}
	
	
	///emp///
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	
	
	
	
	
	
	
	
	
	
}
