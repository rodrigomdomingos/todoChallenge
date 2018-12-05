package br.com.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.challenge.entity.Task;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
  
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

		
	  public TaskController() {
		  emf = Persistence.createEntityManagerFactory("task");
		  em = emf.createEntityManager();
		  getListOfTask();
	  }
	  
	  @RequestMapping("/salvar")
	  public void salvar(Task task) {
		  em.getTransaction().begin();
		  em.merge(task);
		  em.getTransaction().commit();
		  
		  getListOfTask();
	  }
	  
	  @RequestMapping("/remover")
	  public void remover(Task task) {
		  em.getTransaction().begin();
		  em.remove(task);
		  em.getTransaction().commit();
		  
		  getListOfTask();
	  }
	  
	  @RequestMapping("/update")
	  public void update(int id, String task) {
		  em.getTransaction().begin();
		  Query q = em.createNativeQuery("update task set titulo ='" + task + "' where id= '"+ id  +"'");
		  q.executeUpdate();
		  em.getTransaction().commit();
	  }
	  
	  public void getListOfTask() {
		  Query q = em.createNativeQuery("select * from task", Task.class);
		  @SuppressWarnings("unchecked")
		  List<Task> list = (List<Task>) q.getResultList();
		  this.list = list;
	  }
	  		  
	  	//@RequestMapping("/hello")
		public ModelAndView showMessage(
		@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
			ModelAndView mv = new ModelAndView("helloworld");
			mv.addObject("message", message);
			mv.addObject("name", name);
			
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
