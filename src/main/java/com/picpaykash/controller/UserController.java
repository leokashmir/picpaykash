package com.picpaykash.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.picpaykash.DTO.ConsumerViewDto;
import com.picpaykash.DTO.SellerViewDTO;
import com.picpaykash.DTO.UsuarioDetalhesDTO;
import com.picpaykash.exceptions.UniqueException;
import com.picpaykash.exceptions.ValidaCamposException;
import com.picpaykash.model.User;
import com.picpaykash.service.ConsumerServiceImpl;
import com.picpaykash.service.SellerServiceImpl;
import com.picpaykash.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private ConsumerServiceImpl consumerService;
	@Autowired
	private SellerServiceImpl sellerService;
	
	
	@PostMapping("/users")
	@ResponseBody
	public ResponseEntity<User> addUsers(@RequestBody User user ) throws UniqueException, IllegalArgumentException, IllegalAccessException, ValidaCamposException {
		
		User userOk = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(userOk);
	}
	
	@GetMapping("/users")
	public List<User> listUsers(@RequestParam("q") String usrFiltro) {
		
		return userService.listUsers(usrFiltro);
	}
	
	@PostMapping("/users/consumers")
	@ResponseBody
	public ResponseEntity<?>  addConsumer(@RequestBody ConsumerViewDto consumer ) throws UniqueException, IllegalArgumentException, IllegalAccessException, ValidaCamposException {
		
		consumerService.addConsumer(consumer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/users/sellers")
	public ResponseEntity<?> addSellers(@RequestBody SellerViewDTO sellerViewDto) throws IllegalArgumentException, IllegalAccessException, UniqueException, ValidaCamposException {
		 
		sellerService.addSeller(sellerViewDto);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/users/{id}")
	@ResponseBody
	public  ResponseEntity<UsuarioDetalhesDTO> listUserById(@PathVariable("id") Long id ) {
		UsuarioDetalhesDTO user = userService.getUsuarioDetalheById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
		
	}
	
	 @RequestMapping(value="/", method= RequestMethod.GET)
	 public RedirectView conusltaAPI() {
	 	 return new RedirectView("https://picpaykash.herokuapp.com/swagger-ui.html");
	  }
	

}
