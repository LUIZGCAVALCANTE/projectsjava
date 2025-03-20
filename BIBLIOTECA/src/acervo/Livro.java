package acervo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Livro {

	Autor at = new Autor(); 
	
	
	LocalDateTime  sdata =  LocalDateTime.now();
	LocalDateTime devo = sdata.plusDays(4).plusHours(1).plusMinutes(2);
	String titulo;
	String genero;
	int id;
	boolean disponibilidade;
	
	
	
	public LocalTime datacad;
	public LocalTime devol;
	
	public Livro  () {
		
		
	}
	
	public Livro (int id, String titulo, Autor autor,boolean disponibilidade) {
		
		this.id= id;
		this.titulo= titulo;
		this.disponibilidade= true;
		
	}
	
	
	
	
	
	
	public void tcad (Date datacad) {
			
		this.datacad = sdata.toLocalTime();
		
	}
	
	public void Devol (LocalTime devol) {
		
		this.devol = devo.toLocalTime();
		System.out.println(devol);
	}






	public Autor getAt() {
		return at;
	}






	public void setAt(Autor at) {
		this.at = at;
	}






	public LocalDateTime getSdata() {
		return sdata;
	}






	public void setSdata(LocalDateTime sdata) {
		this.sdata = sdata;
	}






	public LocalDateTime getDevo() {
		return devo;
	}






	public void setDevo(LocalDateTime devo) {
		this.devo = devo;
	}






	public String getTitulo() {
		return titulo;
	}






	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}






	public String getGenero() {
		return genero;
	}






	public void setGenero(String genero) {
		this.genero = genero;
	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public boolean isDisponibilidade() {
		return disponibilidade;
	}






	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}






	public LocalTime getDatacad() {
		return datacad;
	}






	public void setDatacad(LocalTime datacad) {
		this.datacad = datacad;
	}






	public LocalTime getDevol() {
		return devol;
	}






	public void setDevol(LocalTime devol) {
		this.devol = devol;
	}	

	 public String toString() {
	        return "Livro{" +
	                "id=" + id +
	                ", titulo='" + titulo + '\'' +
	                ", autor=" + at +
	                ", disponivel=" + disponibilidade +
	                ", dataCadastro=" + sdata +
	                ", dataAtualizacao=" + devo +
	                '}';
	    }
	
	

	
	
}
