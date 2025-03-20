package acervo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emprestimo {
private Cliente cliente;	
private Livro livro;
private Autor autor; 
private LocalDateTime dataemp;
private LocalDateTime sadata;





public Emprestimo(Cliente clienteEncontrado, String livroNome, LocalDate now) {
	// TODO Auto-generated constructor stub
}



public LocalDateTime getSadata() {
	return sadata;
}



private boolean devolvido;	
	
	
	public void emprestarLivro(Cliente cliente, Livro livro, Autor autor) {
		
		this.cliente = cliente;
		this.livro = livro;
		this.autor = autor;
		this.dataemp =  LocalDateTime.now();
		this.devolvido = false;
		this.sadata = LocalDateTime.now();
	}
	
	
	
	public void devolverLivro() {
		
		this.devolvido = true;
		System.out.println("O livro foi devolvido!");
		livro.Devol(livro.getDevol());
	}
	
	
	
	
	public void verEmprestimo () {
		
		System.out.println("Usuario" + cliente);
		System.out.println("Retirou a Obra"+ livro);
		System.out.println("Escrito por "+ autor);
		System.out.println("Na data "+ dataemp);
		System.out.println("Com devolução prevista para: " + livro.devol);

		
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Livro getLivro() {
		return livro;
	}



	public void setLivro(Livro livro) {
		this.livro = livro;
	}



	public Autor getAutor() {
		return autor;
	}



	public void setAutor(Autor autor) {
		this.autor = autor;
	}



	public LocalDateTime getDataemp() {
		return dataemp;
	}



	public void setDataemp(LocalDateTime dataemp) {
		this.dataemp = dataemp;
	}



	public boolean isDevolvido() {
		return devolvido;
	}



	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}
	
	
	
	 @Override
	    public String toString() {
	        return "Emprestimo{" +
	                ", livro=" + livro +
	                ", nomeUsuario='" + cliente + '\'' +
	                ", dataEmprestimo=" +  sadata +
	                ", dataDevolucao=" + dataemp +
	                '}';
	    }
	
	
}
