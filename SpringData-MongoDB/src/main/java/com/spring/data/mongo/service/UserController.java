package com.spring.data.mongo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.mongo.Users;

@RestController
@RequestMapping("/UserData")
public class UserController   {

	@Autowired
	UserRepository userRepository;

 
  @RequestMapping(value= "/insert", method= RequestMethod.POST)
	public String  insert(@RequestBody Users users) {
	  
		  
		  userRepository.save(users);
		  
		return "added";
		
	}
	
	
  @RequestMapping(value= "/fetchUsers", method= RequestMethod.GET)
  @ResponseBody
	public List<Users> fetch() {
		
		return userRepository.findAll();
		
	}
  
  @RequestMapping(value= "/fetchByID/{id}", method= RequestMethod.GET)
  @ResponseBody
	public Optional<Users> fetch(@PathVariable("id") String id) {
		
		return (Optional<Users>) userRepository.findById(id);
		
	}
	
  @RequestMapping(value= "/update/{id}", method= RequestMethod.PUT)
	public String  update(@PathVariable("id") final String id,@RequestBody final Users users) {
	  
	 
	  
	  Optional<Users> user = userRepository.findById(id);
	  
	  user.ifPresent(new Consumer<Users>() {
		public void accept(Users x) {
			x.setId(id);
			x.setAddress(users.getAddress());
			x.setEmail(users.getEmail());
			x.setName(users.getEmail());
			
		}
	});
	  
	  
		  userRepository.save(users);
		  
		return "updated";
		
	}
  
  @RequestMapping(value= "/delete/{id}", method= RequestMethod.DELETE)
	public String  delete(@PathVariable("id") String id) {
	  
		  
		  userRepository.deleteById(id);
		  
		return "deleted with id" +id+"";
		
	}
  
  @RequestMapping(value= "/deleteAll", method= RequestMethod.DELETE)
	public String  delete() {
	  
		  
		  userRepository.deleteAll();
		  
		return "deleted All";
		
	}
}
