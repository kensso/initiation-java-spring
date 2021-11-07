package angularspring.angular.spring.boot;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Person;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@RestController
	class MonController{
		@Autowired
		@GetMapping("/bonjour")
		public String direBonjour() {
			return "Bonjour";  
		}
	}
	
	@RestController
	class PersonController{
		@Autowired
		EntityManager em;
		@PostMapping("/person")
		@Transactional
		public Person savePerson(@RequestParam String prenom) {
		Person p = new Person();
		p.setPrenom(prenom);
		em.persist(p);
		return p;
	}
	}

}
