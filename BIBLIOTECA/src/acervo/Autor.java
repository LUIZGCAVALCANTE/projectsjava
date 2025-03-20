package acervo;

import java.time.LocalDate;
import java.time.LocalDateTime;




public class Autor {

	int id ;
	String name;
	LocalDate datanasc;	
	LocalDateTime  sdata =  LocalDateTime.now();
	String obras;


	public Autor() {
		// TODO Auto-generated constructor stub
	}


	public  Autor (int id, String name, LocalDate localDate, String obras ) {
		this.name = name;
		this.id= id;
		this.datanasc = LocalDate.now();
		this.obras = obras;
	}



	public void obras () {
		
		
		
		
	}
	
	
	public String getObras() {
		return obras;
	}


	public void setObras(String obras) {
		this.obras = obras;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDatanasc() {
		return datanasc;
	}


	public void setDatanasc(LocalDate datanasc) {
		this.datanasc = datanasc;
	}


	


	 @Override
	    public String toString() {
	        return "Autor{" +
	                "id=" + id +
	                ", nome ='" + name + '\'' +
	                ", dataNascimento=" + datanasc + '\'' +
	                "Obras" + obras+ '\''+
	                '}';
	    }


	
	 
	
	
}
