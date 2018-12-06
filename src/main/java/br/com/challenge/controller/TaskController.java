package br.com.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.*;
import br.com.challenge.entity.Task;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.text.html.ListView;
  
//Spring MVC
@Controller
@RequestMapping("/")
//JSF
@ManagedBean(name="taskBean")
@SessionScoped
public class TaskController {
	
	  String message = "Spring MVC!";
	  EntityManagerFactory emf;
	  EntityManager em;
	  Task task = new Task();
	  List<Task> list;	

	  /*
	   * Constructor
	   */
	  public TaskController() {
		  emf = Persistence.createEntityManagerFactory("task");
		  em = emf.createEntityManager();
		  getListOfTask();
	  }
	  
	  /*
	   * Save task and update list
	   */
	  public void salvar(Task task) {
		  em.getTransaction().begin();
		  em.merge(task);
		  em.getTransaction().commit();
		  getListOfTask();
	  }
	  
	  /*
	   * remove task and update
	   */
	  public void remover(Task task) {
		  em.getTransaction().begin();
		  em.remove(task);
		  em.getTransaction().commit();
		  
		  getListOfTask();
	  }
	  /*
	   * update task 
	   */
	  @RequestMapping("/update")
	  public void update(int id, String task) {
		  em.getTransaction().begin();
		  Query q = em.createNativeQuery("update task set titulo ='" + task + "' where id= '"+ id  +"'");
		  q.executeUpdate();
		  em.getTransaction().commit();
	  }
	  
	  /*
	   * Get list of all tasks
	   */
	  public void getListOfTask() {
		  Query q = em.createNativeQuery("select * from task", Task.class);
		  @SuppressWarnings("unchecked")
		  List<Task> list = (List<Task>) q.getResultList();
		  this.list = list;
	  }
	  	
	  	/*
	  	 * Spring mvc add task via url
	  	 */
	  	@RequestMapping("/adicionar")
		public ModelAndView showMessage(
		@RequestParam(value = "titulo", required = false, defaultValue = "") String titulo) {
	  		Task nova = new Task();
			nova.setTitulo(titulo);
			salvar(nova);
			ModelAndView mv = new ModelAndView("helloworld");
			mv.addObject("message", message);
			
			return mv;
	  	}
	  	
	  	/*
	  	 * Spring MVC return JSON of all tasks;
	  	 */
		@RequestMapping("/getListJSON")
		public ModelAndView getLisJSON() {
			getListOfTask();
			ModelAndView mv = new ModelAndView(	);
			mv.setView(new MappingJackson2JsonView());
			mv.addObject(getList());
			
			getListOfTask();
			
			return mv;
	  	}
		
		
		public void addTask() {
			salvar(task);
		}
			
		public Task getTask() {
			return task;
		}
			
		public List<Task> getList() {
			return list;
		}
}
