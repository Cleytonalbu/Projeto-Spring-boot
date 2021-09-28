package br.com.springboot.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.stream.Optional;

import br.com.springboot.model.Users;

@RestController
@RequestMapping("/users")
public class UserController {
	private List<Users> users = new ArrayList<>();
	
	@GetMapping
	public Users user() {
		Users user = new Users();
		user.setId(1L);
		user.setName("Cleyton");
		user.setUsername("albuquerque");
		return user;
		
	}
	@PostMapping
	public Users user(@RequestBody Users user){
		users.add(user);
		return user;
	}
	@GetMapping("/list")
	public List<Users> list(){
		return users;
	}
	@GetMapping("/{id}")
	public Users user(@PathVariable("id") long id) {
		java.util.Optional<Users> userFind =  users.stream().filter(user -> user.getId() == id).findFirst();
		if(userFind.isPresent()) {
			return userFind.get();
			
		}
		return null;
	}
	
	
	

	
}
