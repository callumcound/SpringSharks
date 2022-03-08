package com.example.sharks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.sharks.entity.Shark;
import com.example.sharks.service.SharkService;

@RestController
@RequestMapping("/shark")
public class SharkController {

		private SharkService service;
		
		private SharkController(SharkService service) {
			this.service = service;
		}
		
		@PostMapping("/create")
		public ResponseEntity<Shark> createShark(@RequestBody Shark shark){
			return new ResponseEntity<Shark>(this.service.create(shark), HttpStatus.CREATED);
		}
		

		@GetMapping("/readAll")
		
		public ResponseEntity<List<Shark>> readAllSharks(){
			return new ResponseEntity<List<Shark>>(this.service.readAll(), HttpStatus.OK);
		}

		@GetMapping("/readById/{id}")
		public ResponseEntity<Shark> readById(@PathVariable long id){
			return new ResponseEntity<Shark>(this.service.readyById(id), HttpStatus.OK); 
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<Shark> updateShark(@PathVariable long id, @RequestBody Shark shark){
			return new ResponseEntity<Shark>(this.service.update(id, shark), HttpStatus.ACCEPTED);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean> deleteShark(@PathVariable long id){
			return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		
}
