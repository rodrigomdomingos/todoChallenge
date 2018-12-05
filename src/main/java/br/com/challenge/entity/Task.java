package br.com.challenge.entity;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
  
@Entity
@Table(name="task")
public class Task {
  
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY) 
      private Long id; 
       
      @Column
      private String titulo; 
      
      public long getId() {
    	  return id;
      } 
       
      public String getTitulo() {
            return titulo;
      }
      public void setTitulo(String titulo) {
            this.titulo = titulo;
      }

}