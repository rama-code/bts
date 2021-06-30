package com.bts.Tes.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.bts.Tes.model.Usermodel;
import com.bts.Tes.entity.User;
import com.bts.Tes.entity.Shoopping;
import com.bts.Tes.repository.Userrepository;
import com.bts.Tes.repository.Shooppingrepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class Home{

   @Autowired
	private Userrepository userRepo;
	@Autowired
	private Shooppingrepository shopRepo;

	@PostMapping("/api/users/sigin")
	public Usermodel login(@RequestBody User userinput) {
		 
		User users = userRepo.findByUsernameAndPassword(userinput.getUsername(),userinput.getPassword());
		String token = getJWTToken(users.getUsername());
		Usermodel user = new Usermodel();
		user.setUsername(users.getUsername());
		user.setToken(token);
		user.setEmail(users.getEmail());		
		return user;
		
	}
	@PostMapping("/api/users/sigup")
	public Usermodel sigup(@RequestBody User usersi) {
		 
		User users = userRepo.save(usersi);
		String token = getJWTToken(users.getUsername());
		Usermodel user = new Usermodel();
		user.setUsername(users.getUsername());
		user.setToken(token);
		user.setEmail(users.getEmail());		
		return user;
		
	}
	@GetMapping("/api/users/")
	public List<User> getAll() {
		 
		return userRepo.findAll();
		
	}

	@PostMapping("/api/shoopping")
	public Shoopping add(@RequestBody Shoopping shoop) {
		 
			
		return shopRepo.save(shoop);
		
	}
	@GetMapping("/api/shoopping")
	public List<Shoopping> getAllShop() {
		 
			
		return shopRepo.findAll();
		
	}
	@GetMapping("/api/shoopping/{id}")
	public Shoopping getById(@PathVariable long id ) {
		 
			
		return shopRepo.findById(id);
		
	}
	@PutMapping("/api/shoopping/{id}")
	public Shoopping update(@RequestBody Shoopping shop,@PathVariable long id) {
		 
		Shoopping shopi = shopRepo.findById(id);
		shop.setId(shopi.getId());
		return shopRepo.save(shop);
		
	}

	@DeleteMapping("/api/shoopping/{id}")
	public void deleteById(@RequestBody Shoopping shop,@PathVariable long id ) {
		
			
		shopRepo.deleteById(id);
		
	}





	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}
}
