package acervo;



public class Cliente {

	
	
	private String nome;
	private String CPF;	
	private String  telefone;
	private String  key = "7600";
	
	
	
	




	


public String getKey() {
		return key;
	}




	///bloco construtor
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	
	Cliente (String nome, String CPF, int idade, String telefone) {
		
		this.nome = nome;
		this.CPF= CPF;
		this.telefone = telefone;

		
	}



	// bloco demais dados


	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getCPF() {
		return CPF;
	}




	public void setCPF(String cPF) {
		CPF = cPF;
	}



	public String  getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone= telefone;
	}
	
	
	
	
	
	   public String toString() {
	        return "Nome: " + nome + 
	               "\nCPF: " + CPF + 
	               "\nTelefone: " + telefone;
	    }
	
	
	
	

	
	
	
	
	
}
