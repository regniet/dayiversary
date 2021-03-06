package com.acn.powerrangers.dayiversary;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acn.powerrangers.dayiversary.dtos.Dayiversary;
import com.acn.powerrangers.dayiversary.models.User;

//@Controller //das hier gibt html dateien zurück
@RestController 
public class ThousandVersaryController {
	
	@Autowired //damit nehmen wir die variable von UserService
	UserService userservice;
	@Autowired
	DayiversaryService dayiversaryservice;
	
		
	@GetMapping("/users/{id}/dayiversary")
	public Dayiversary tenThousand(@PathVariable("id") Long id) {
		User userById = userservice.readUserById(id);
		return dayiversaryservice.calculate(userById.getBirthDate());
		
		
	}
	

	
}
