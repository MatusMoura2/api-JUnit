package com.mfapi.app.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfapi.app.domain.User;
import com.mfapi.app.servises.UserServise;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	private UserServise userServise;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(userServise.findById(id));
	}
}
